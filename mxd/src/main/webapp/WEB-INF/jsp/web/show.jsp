<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript" src="${base}/js/jquery.min.js"></script>

<script type="text/javascript">
var me = '<%=session.getAttribute("me") %>';
var base = '${base}';
</script>
</head>
<body>
${obj.article.TITLE}
${obj.article.CONTENT}
	
</body>
</html>