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
<script type="text/javascript" src="${base}/js/index.js"></script>

<script type="text/javascript">
var me = '<%=session.getAttribute("me") %>';
var base = '${base}';
</script>
</head>
<body>
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
		<table id="dg"  data-options="rownumbers:true,singleSelect:true,pagination:true" style="width:700px;height:500px">
		<thead>
			<tr>
				<th data-options="field:'TITLE',width:80">TITLE</th>
			</tr>
		</thead>
		</table>
							<%-- <table id="dg"  style="width:700px;height:500px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:''${base}/article/getArticleByPage',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'TITLE',width:80">TITLE</th>
			</tr>
		</thead>
	</table> --%>
		</div>
	</div>
	
</body>
</html>