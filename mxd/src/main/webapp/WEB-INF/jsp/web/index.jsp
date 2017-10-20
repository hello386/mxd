<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<link rel="stylesheet" type="text/css" href="${base}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${base}/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${base}/themes/demo.css">	
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${base}/res/edtor/wangEditor.min.js"></script>
<script type="text/javascript" src="${base}/js/index.js"></script>

<script type="text/javascript">
var me = '<%=session.getAttribute("me") %>';
var base = '${base}';
</script>
</head>
<body>
<input type="hidden" id="columnId">
<div style="margin:20px 0;"></div>
<!-- <ul id="tt" class="easyui-tree"></ul> -->
	
	
	<div class="easyui-layout" style="width:1000px;height:550px;">
		
		<div data-options="region:'west'"  style="width:300px;">
		
		
			<div class="easyui-layout"  data-options="fit:true">
				<div data-options="region:'west',split:true,border:false"       title="站点"  style="width:150px"> 
				   <ul id="tt" class="easyui-tree"></ul>
				   </div>
				<div data-options="region:'center',split:true,border:false"    title="栏目"   style="width:150px">
				    <ul id="tt_coloum" class="easyui-tree"></ul>
				</div>
			</div>
			
			
		</div>
		<div data-options="region:'center'" title="文章列表">
		<table id="dg"  data-options="rownumbers:true,singleSelect:true,pagination:true" 
		   style="width:700px;height:500px"  toolbar="#tb">
		<thead>
			<tr>
				<th data-options="field:'TITLE',width:80">标题</th>
				<th data-options="field:'PAGE_NAME',width:80">栏目</th>
				<th data-options="field:'EDITOR_NAME',width:80">作者</th>
				<th data-options="field:'ENTITY_TYPE',width:80">类型</th>
				<th data-options="field:'RELEASE_DATE',width:80">发布时间</th>
				<th data-options="field:'INFOSUMMARY',width:80">摘要</th>
				<th data-options="field:'PAGE_ID',width:80 " >栏目id</th>
				<th data-options="field:'KEY',width:80 " >文章编号</th>
				
			</tr>
		</thead>
		</table>
		<div id="tb">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:showAddArticle()">添加</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:editArticle()">修改</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:delArticle()">删除</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-more" plain="true" onclick="javascript:showArticle()">查看</a>
</div>
		</div>
	</div>
	
	<!-- 弹出的窗口  编辑文章 -->
	<div id="w" class="easyui-window" title="窗口"   style="width:900px;height:500px;padding:5px;"
	data-options="iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:true,closable:true">
			
		<div class="easyui-layout" data-options="fit:true"  >
			
  标题：<input type="text" id=title>
   文章类型：
  <select id="ENTITY_TYPE" name="ENTITY_TYPE"  >
   <option value="HTML">HTML</option>
   <option value="ATTACHMENT">附件</option>
   <option value="URL">URL</option>
  </select>
<input type='text' id ='ENTITY_URL' name='ENTITY_URL' class='eps-article-title-input' value='http://'/>
<!-- 附件类型上传 -->
<form id="attachmentForm" method="post" enctype="multipart/form-data">
  <input id="upload1" class="easyui-filebox" name="file1" data-options="prompt:'选择文件...',onChange:function(){uploadFiles()}" style="width: 150px" />
   </form>
<!-- 附件类型上传  end-->
<!-- 内容编辑 -->
	<div id="content"  >
    </div>
    
    <input id="saveandpublish" type="button" value="保存并发布" onclick="saveArticle()" />
    
			<!-- <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('ok')" style="width:80px">Ok</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')" style="width:80px">Cancel</a>
			</div> -->
		</div>
	</div>
	
	<div id="detailW" class="easyui-window" title="窗口"   style="width:900px;height:500px;padding:5px;"
	data-options="iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:true,closable:true">
			
		<div class="easyui-layout" data-options="fit:true"  >
			
    
			<!-- <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('ok')" style="width:80px">Ok</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')" style="width:80px">Cancel</a>
			</div> -->
		</div>
	</div>
	
</body>
</html>