  
    var jsonArray = [];
    var editor ;
    $(function() {
    	$('#tt').tree({
    	    url:base+'/service/userMgrSite',
    	    onClick: function(node){
    			//alert(node.text);  // alert node text property when clicked
    	    	//var columUrl = base+'/service/getPageTreeNode?parentId='+node.parentId+"&siteId="+node.id;
    	    	var columUrl = base+'/service/getPageTreeNode?parentId=-1&siteId='+node.id;
    	    	console.log(columUrl);
    	    	$('#tt_coloum').tree({
    	    	    url:columUrl,
    	    	    onClick: function(node){
    	    			//alert(node.text);  // alert node text property when clicked
    	    	    	//var url = base+'/article/getArticleByPage?columnId='+node.id+"&pageNo=1&pageSize=10";
    	    	    	var url = base+'/article/getArticleByPage?columnId='+node.id;
    	    	    	$("#columnId").val(node.id);//在页面设置上栏目id  添加文章时用
    	    	    	
    	    	    	initTable(url);
    	    			console.log(url);
    	    		}
    	    	});
    		}
    	});
    	
    	initTable();
    	
    	$('#w').window('close');
    	$('#detailW').window('close');
    	
		//初始化编辑器
		var E = window.wangEditor;
		 editor = new E('#content');
		// 或者 var editor = new E( document.getElementById('#editor') )
		editor.create();
		//隐藏输入url
		$("#ENTITY_URL").hide();
		//隐藏附件上传 
		$("#attachmentForm").hide();
		
		$("#ENTITY_TYPE").change(function(){
			var et = $(this).val();
			if(et=="URL"){
				$("#ENTITY_URL").show();
				$("#content").hide();
				$("#attachmentForm").hide();
			}
			if(et=="HTML"){
				$("#ENTITY_URL").hide();
				$("#content").show();
				$("#attachmentForm").hide();
			}
			if(et=="ATTACHMENT"){
				$("#ENTITY_URL").hide();
				$("#content").hide();
				$("#attachmentForm").show();
			}
			
		});
		
		
		
		
    });
    
    
    function initTable(url){
		$('#dg').datagrid({
    	    url:url,
    	    loadMsg:'数据加载中...',
    	    onLoadSuccess: function(data){
    	    	if(data.status != "0"){
    	    		showMsg("错误",result.statusInfo);
    	    	}
    	    },
    	onLoadError: function(){
    		showMsg("错误","服务器错误-加载数据出错");
    		
    	}
    	});
		$('#dg').datagrid('hideColumn','PAGE_ID');
		
		
		//$('#dg').datagrid('hideColumn','STAFF_ID');
	}
    
    
    function showAddArticle(){
    	//清空乘客里面的内容
		cleanW();
    	var columnId= $("#columnId").val();
    	if(columnId==""){
    		showMsg("信息","请选择栏目");
    	}else{
    		// var toAddUrl=base+'/article/toAddArticle?columnId='+columnId;;
             //$('#w').window('refresh', toAddUrl);
     		$('#w').window('open');
    	}
    	
    }
    function uploadFiles() {
    	      $('#attachmentForm').form('submit', {                
    	                  url: 'Upload.aspx?fjssmk=Xmgl',
    	                 success: function (result) {
    	                     var result = eval('(' + result + ')');
    	                      //可以写一些提示的代码等等..
    	                  }
    	             });
    }
    function saveArticle(){
    	var columnId= $("#columnId").val();
    	var addUrl=base+'/article/addArticle';
    	/*
    	 * 1(保存草稿)，2(保存并发布)
    	 */
    	var status="2";
    	var  entityType= $("#ENTITY_TYPE").val();
    	var title=$("#title").val();
    	var content = editor.txt.html()
    	var data={ title: title, content: content ,columnId:columnId,
 		       status:status,entityType:entityType
	       };
	       if(entityType =="URL"){
	    	   var ENTITY_URL=$("#ENTITY_URL").val();
	    	   data={ 
	    			   title: title ,columnId:columnId,
	     		       status:status,entityType:entityType,entieyUrl:ENTITY_URL
	    	       };
	       }
    	
    	$.post( addUrl, 
    			data,
    			function( data ) {
			    		console.log(data);
			    		if(data.status=="0"){
			    			$('#w').window('close');
			    			$('#dg').datagrid("reload",{ }); 
			    			
			    		}
			    		showMsg("提示信息",data.statusInfo);
			    		
			    	} ,"json");
    	
    }
    
    function editArticle(){
    	alert("修改");
    }
    function delArticle(){
    	var row = $('#dg').datagrid('getSelected');
    	 if (row) {
    		 $.messager.confirm('Confirm', '确认要删除吗?', function (r) {
                 if (r) {
                	 
                    var delUrl=base+'/article/delArticle?columnId='+row.PAGE_ID+'&key='+row.KEY;
                    console.log(delUrl);
                    $.get(delUrl, function(result){
                    	if(result.status!="0"){
                    		showMsg("错误",result.statusInfo);
                    	}else{//成功
                    		showMsg("操作成功",result.statusInfo);
                    		 $('#dg').datagrid("reload",{ });  
                    	}
                      },
                      "json");
                  
                 }
             });
    	 }
    }
    
    function showArticle(){
		 var row = $('#dg').datagrid('getSelected');
	   	 if (row) {
	   		 var getUrl=base+'/article/getArticle?columnId='+row.PAGE_ID+'&key='+row.KEY;
	            console.log(getUrl);
	            $('#detailW').window('open');
	            $('#detailW').window('refresh', getUrl);
        		
        		
	   	 }
	 }
    
    //显示提示消息
    function showMsg(title,msg){
    	$.messager.show({
			title:title,
			msg:msg,
			timeout:5000,
			showType:'slide'
		});
    }
   
    function cleanW(){
    	$("#title").val("");
    	editor.txt.html('');
    	var content = editor.txt.html()
    }
   