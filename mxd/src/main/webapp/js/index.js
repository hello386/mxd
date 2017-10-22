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
	$("#ENTITY_URL").hide();
	// 隐藏附件上传
	$("#fileToUpload").hide();

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
		$("#ENTITY_URL").show();
		$("#content").hide();
		$("#fileToUpload").hide();
	}
	if (et == "HTML") {
		$("#ENTITY_URL").hide();
		$("#content").show();
		$("#fileToUpload").hide();
	}
	if (et == "ATTACHMENT") {
		$("#ENTITY_URL").hide();
		$("#content").hide();
		$("#fileToUpload").show();
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

	// $('#dg').datagrid('hideColumn','STAFF_ID');
}

//显示添加文章
function showAddArticle() {
	$("#opt_type").val("add");
	// 清空乘客里面的内容
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
	if (row) {
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
            		//$("#fileToUpload").val(filename);
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
	$("#ENTITY_URL").val("");
	$("#infosummary").val("");
	$("#key").val("");
}

function startUpload(){
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
            	//alert(filePath);
               $("#filepath").val(filePath);
            },  
            error: function (data, status, e) {  
                alert(e);  
            }  
        });  
    
}
