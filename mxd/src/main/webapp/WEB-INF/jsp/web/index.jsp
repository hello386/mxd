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
<script type="text/javascript" src="${base}/js/ajaxfileupload.js"></script>


<script type="text/javascript">
var me = '${me.userId}';
var base = '${base}';
</script>
</head>
<body>
<input type="hidden" id="columnId">
<input type="hidden" id="to_columnId"><!-- 要移动到或copy到的栏目 不能和当前栏目columnId相同 -->
<input type="hidden" id="to_columnId_name"><!-- 要移动到或copy到的栏目  频道唯一标识 -->
<input type="hidden" id="filepath">
<input type="hidden" id="opt_type"><!-- 操作类型：添加-add，更新-update   move-移动   copy-复制-->
<input type="hidden" id="key"><!-- 编辑的时候 文章的 KEY -->
<input type="hidden" id="siteEnname"><!-- 站点英文名字 保存附件的时候要用 -->
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
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"  onclick='showOptArticle("move")'>移动</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"  onclick='showOptArticle("copy")'>复制</a>
	<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-more" plain="true" onclick="javascript:showArticle()">查看</a> -->
</div>
		</div>
	</div>
	
	<!-- 弹出的窗口  编辑文章 -->
	<div id="w" class="easyui-window" title="窗口"   style="width:900px;height:500px;padding:5px;"
	data-options="iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:true,closable:true,modal:true">
			
		<div class="easyui-layout" data-options="fit:true"  >
			
  标题：<input type="text" id=title>
   文章类型：
  <select id="ENTITY_TYPE" name="ENTITY_TYPE"  >
   <option value="HTML">HTML</option>
   
  <option value="ATTACHMENT">附件</option> <!-- 我的tomcat不能传文件到crm上 只能传到自己服务器上 -->
   <option value="URL">URL</option>
  </select>
<input type='text' id ='ENTITY_URL' name='ENTITY_URL' class='eps-article-title-input' value='http://'/>
<!-- 附件类型上传 -->
<!-- 点击图片，打开文件选择器，确定，上传。(这是网络上的一个图片) -->  
<input id="fileToUpload"   type="file"  name="fileToUpload"><button onclick="startUpload()">点击开始上传</button>
<!-- 附件类型上传  end-->
摘要：
<textarea rows="" cols=""  id="infosummary"></textarea>
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
	
	<div id=optW class="easyui-window" title="Layout Window" icon="icon-help" 
	   style="width:400px;height:250px;padding:5px;background: #fafafa;"
	   data-options="modal:true,closed:true">
		<div class="easyui-layout" fit="true">
			<div region="west" split="true" style="width:200px;">
				<ul class="easyui-tree" id="opt_site">
					<!-- <li>
						<span>Library</span>
						<ul>
							<li><span>easyui</span></li>
							<li><span>Music</span></li>
							<li><span>Picture</span></li>
							<li><span>Database</span></li>
						</ul>
					</li> -->
				</ul>
			</div>
			<div region="center" border="true"  split="true" style="width:200px;">
				<ul class="easyui-tree" id="opt_col">
					<!-- <li>
						<span>Library</span>
						<ul>
							<li><span>easyui</span></li>
							<li><span>Music</span></li>
							<li><span>Picture</span></li>
							<li><span>Database</span></li>
						</ul>
					</li> -->
				</ul>
			</div>
			<div region="south" border="false" style="text-align:right;height:30px;line-height:30px;">
				<a class="easyui-linkbutton" icon="icon-ok" href="javascript:startMovOrCopy()">确定</a>
				<a class="easyui-linkbutton" icon="icon-cancel" href="javascript:$('#optW').window('close')">取消</a>
			</div>
		</div>
	</div>
	
</body>
</html>