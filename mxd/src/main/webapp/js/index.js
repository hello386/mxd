var jsonArray = [];
var editor;
$(function() {
	$('#tt')
			.tree(
					{
						url : base + '/service/userMgrSite',
						onClick : function(node) {
							// alert(node.text); // alert node text property
							// when clicked
							// var columUrl =
							// base+'/service/getPageTreeNode?parentId='+node.parentId+"&siteId="+node.id;
							$("#siteEnname").val(node.userMgrSite.siteEnname);
							var columUrl = base
									+ '/service/getPageTreeNode?parentId=-1&siteId='
									+ node.id;
							console.log(columUrl);
							$('#tt_coloum')
									.tree(
											{
												url : columUrl,
												onClick : function(node) {
													// alert(node.text); //
													// alert node text property
													// when clicked
													// var url =
													// base+'/article/getArticleByPage?columnId='+node.id+"&pageNo=1&pageSize=10";
													var url = base
															+ '/article/getArticleByPage?columnId='
															+ node.id;
													$("#columnId").val(node.id);// 在页面设置上栏目id
																				// 添加文章时用

													initTable(url);
													console.log(url);
												}
											});
						}
					});

	initTable();

	$('#w').window('close');
	$('#detailW').window('close');
	

	// 初始化编辑器
	var E = window.wangEditor;
	editor = new E('#content');
	// 或者 var editor = new E( document.getElementById('#editor') )
	editor.create();
	// 隐藏输入url
	//$("#url_tr").hide();
	// 隐藏附件上传
	//$("#fj_tr").hide();

	//$("#fileToUpload").hide();
	
	$("#ENTITY_TYPE").change(function() {
		var et = $(this).val();
		entityTypeChang(et);

	});
	
	/*//点击打开文件选择器  
    $("#upload").on('click', function() {  
        $('#fileToUpload').click();  
    });  */
  //选择文件之后执行上传  
    /*$('#fileToUpload').on('change', function() {  
        $.ajaxFileUpload({  
            url: base+'/article/upload',  
            secureuri:false,  
            fileElementId:'fileToUpload',//file标签的id  
            dataType: 'json',//返回数据的类型  
            success: function (data, status) {  
                //把图片替换  
               // var obj = jQuery.parseJSON(data);  
                //$("#upload").attr("src", "../image/"+obj.fileName);  
            	var  filePath=data;
            	alert(filePath);
               $("#filepath").val(filePath);
            },  
            error: function (data, status, e) {  
                alert(e);  
            }  
        });  
    });  */

});

function entityTypeChang(et){
	if (et == "URL") {
		$("#url_tr").show();
		$("#content").hide();
		$("#fj_tr").hide();
	}
	if (et == "HTML") {
		$("#url_tr").hide();
		$("#content").show();
		$("#fj_tr").hide();
	}
	if (et == "ATTACHMENT") {
		$("#url_tr").hide();
		$("#content").hide();
		$("#fj_tr").show();
	}
}

function initTable(url) {
	$('#dg').datagrid({
		url : url,
		loadMsg : '数据加载中...',
		onLoadSuccess : function(data) {
			if (data.status != "0") {
				showMsg("错误", result.statusInfo);
			}
		},
		onLoadError : function() {
			showMsg("错误", "服务器错误-加载数据出错");

		}
		
	});
	$('#dg').datagrid('hideColumn', 'PAGE_ID');
	$('#dg').datagrid('hideColumn', 'ARTICLE_DYNIAMIC_URL');

	// $('#dg').datagrid('hideColumn','STAFF_ID');
}

function formatTitle(val,row){
	
	if (row.ENTITY_TYPE =="URL"){
		var rurl= '<a href= "'+row.ARTICLE_DYNIAMIC_URL+'" target="_blank">'+val+'</a>';
		return rurl;
	} else {
		return val;
	}
}

//显示添加文章
function showAddArticle() {
	$("#opt_type").val("add");
	// 清空里面的内容
	cleanW();
	var columnId = $("#columnId").val();
	if (columnId == "") {
		showMsg("信息", "请选择栏目");
	} else {
		// var toAddUrl=base+'/article/toAddArticle?columnId='+columnId;;
		// $('#w').window('refresh', toAddUrl);
		$('#w').window('open');
	}

}
function saveArticle() {
	var opt_type=$("#opt_type").val();//新增 还是更新
	var key=$("#key").val();//新增 还是更新
	var siteEnname=$("#siteEnname").val();//站点英文名称 保存附件要用 

	var columnId = $("#columnId").val();
	var addUrl = base + '/article/addArticle';
	/*
	 * 1(保存草稿)，2(保存并发布)
	 */
	var status = "2";
	var entityType = $("#ENTITY_TYPE").val();
	var title = $("#title").val();
	var content = editor.txt.html();
	var infosummary = $("#infosummary").val();
	var filepath = $("#filepath").val();//上传附件后页面保存的路径
	/*
	 * var data={ title: title, content: content ,columnId:columnId,
	 * status:status,entityType:entityType };
	 */
	var data = {};
	data["title"] = title;
	data["content"] = content;
	data["columnId"] = columnId;
	data["status"] = status;
	data["entityType"] = entityType;
	data["infosummary"] = infosummary;
	data["filepath"] = filepath;
	data["optType"]=opt_type;
	data["key"]=key;
	data["siteEnname"]=siteEnname;
	if (entityType == "URL") {
		var ENTITY_URL = $("#ENTITY_URL").val();
		data["entieyUrl"] = ENTITY_URL;
		/*
		 * data={ title: title ,columnId:columnId,
		 * status:status,entityType:entityType,entieyUrl:ENTITY_URL };
		 */
	}
	if(entityType == "ATTACHMENT" && opt_type=="add" && filepath==""){
		showMsg("提示信息", "没有上传附件");
		return;
	}

	$.post(addUrl, data, function(data) {
		console.log(data);
		if (data.status == "0") {
			$('#w').window('close');
			$('#dg').datagrid("reload", {});

		}
		showMsg("提示信息", data.statusInfo);

	}, "json");

}

function editArticle() {
	$("#opt_type").val("update");
	cleanW();
	var row = $('#dg').datagrid('getSelected');
	//var rows = $('#dg').datagrid('getSelections');
	
	//if (rows && rows.length==1) {
	if (row) {
		//var row=rows[0];
		if(row.ENTITY_TYPE=="ATTACHMENT"){
			showMsg("提示信息", "目前不能编辑附件类型文章");
			return;
		}
		
		$("#key").val(row.KEY);
		var getUrl = base + '/article/getArticle?columnId=' + row.PAGE_ID
		+ '&key=' + row.KEY;
             console.log(getUrl);
             $.get(getUrl,function(data){
            	 $("#title").val(data.article.TITLE);
            	 $("#infosummary").val(data.article.INFOSUMMARY);
            	editor.txt.html(data.article.CONTENT);
            	 
            	var et = data.article.ENTITY_TYPE;
            	entityTypeChang(et);
            	$("#ENTITY_TYPE").val(et);
            	if(et=="URL"){
            		$("#ENTITY_URL").val(data.article.ENTITY_URL);
            	}
            	if(et=="ATTACHMENT"){
            		var filePathArr = data.article. ARTICLE_DYNIAMIC_URL.split("/");
            		var filename =filePathArr[filePathArr.length-1];
            		$("#input_file_name").val(filename);
            		//$("#fileToUpload").val(filename);
            		//alert(filename);
            		//$("#fileToUpload").hide();
            	}
            	
            	
            	 $('#w').window('open');
             },"json");
	}else{
		showMsg("错误","请选择一行");
	}
}
function delArticle() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确认要删除吗?', function(r) {
			if (r) {

				var delUrl = base + '/article/delArticle?columnId='
						+ row.PAGE_ID + '&key=' + row.KEY;
				console.log(delUrl);
				$.get(delUrl, function(result) {
					if (result.status != "0") {
						showMsg("错误", result.statusInfo);
					} else {// 成功
						showMsg("操作成功", result.statusInfo);
						$('#dg').datagrid("reload", {});
					}
				}, "json");

			}
		});
	}
}

function showArticle() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		var getUrl = base + '/article/getArticle?columnId=' + row.PAGE_ID
				+ '&key=' + row.KEY;
		console.log(getUrl);
		$('#detailW').window('open');
		$('#detailW').window('refresh', getUrl);

	}
}

// 显示提示消息
function showMsg(title, msg) {
	$.messager.show({
		title : title,
		msg : msg,
		timeout : 5000,
		showType : 'slide'
	});
}

function cleanW() {
	$("#title").val("");
	editor.txt.html('');
	$("#ENTITY_URL").val("http://");
	$("#infosummary").val("");
	$("#key").val("");
	$("#ENTITY_TYPE").val("HTML");
	$("#input_file_name").val("");
	$("#filepath").val("");
	$("#key").val("");
	$("#input_file").html("<input   id='fileToUpload'   type='file'   name='fileToUpload' />");
}

function startUpload(){
	$("#upload_btn").attr("disabled",true).html("上传中....."); 
        $.ajaxFileUpload({  
            url: base+'/article/upload',  
            secureuri:false,  
            fileElementId:'fileToUpload',//file标签的id  
            dataType: 'json',//返回数据的类型  
            success: function (data, status) { 
                //把图片替换  
               // var obj = jQuery.parseJSON(data);  
                //$("#upload").attr("src", "../image/"+obj.fileName);  
            	var  filePath=data.path;
            	var fileName=data.oldName;
            	//alert(filePath);
               $("#filepath").val(filePath);
               $("#upload_btn").attr("disabled",false).html("确定"); 
               /*var filePathArr = filePath.split("/");
              
               if(filePathArr.length==1){
            	   filePathArr = filePath.split("\\");
               }
       		   var filename =filePathArr[filePathArr.length-1];*/
       		   $("#input_file_name").val(fileName);
               showMsg("操作成功", "上传文件成功");
               $('#selectFile').dialog('close');
            }, 
            error: function (data, status, e) {  
                alert(e);  
                $("#upload_btn").attr("disabled",false).html("确定."); 
            }  
        });  
    
}
//移动 复制 文章
function showOptArticle(opt_type){
	$("#opt_type").val(opt_type);
	$('#opt_site').tree(
			{
				url : base + '/service/userMgrSite',
				onClick : function(node) {
					
					//$("#siteEnname").val(node.userMgrSite.siteEnname);
					var columUrl = base
							+ '/service/getPageTreeNode?parentId=-1&siteId='
							+ node.id;
					console.log(columUrl);
					$('#opt_col').tree(
									{
										url : columUrl,
										onClick : function(node) {
											$("#to_columnId").val(node.id);
											$("#to_columnId_name").val(node.id);
										}
									});
				}
			});
	
	
	$('#optW').window('open');
}
function startMovOrCopy(){
	var  columnId = $("#columnId").val();
	var to_columnId=$("#to_columnId").val();
	var opt_type=$("#opt_type").val();
	
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		
		if(columnId == to_columnId){
			//alert("不能选择当前栏目");
			showMsg("错误", "不能选择当前栏目");
			return;
		}
		if(to_columnId==""){
			showMsg("错误", "请选择要移动到的栏目");
			return;
		}
		
		var optUrl = base + '/article/moveOrCopy?to_columnId=' + to_columnId
				+ '&key=' + row.KEY+"&opt_type="+opt_type+"&columnId="+columnId;
		console.log(optUrl);

		$.get(optUrl, function(result) {
			if (result.status != "ok") {
				showMsg("错误", result.statusInfo);
			} else {// 成功
				showMsg("操作成功", result.statusInfo);
				$('#dg').datagrid("reload", {});
			}
			$('#optW').window('close');
		}, "json");
	}else{
		showMsg("错误", "请选择一行");
		
	}
	
}
