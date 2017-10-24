<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${base}/css/styles.css">

</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			
			<form class="form"  id="loginForm">
				<input type="text" placeholder="Username"  name="username">
				<input type="password" placeholder="Password"  name="password" >
				<button type="submit" id="login_button">Login</button>
			</form>
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>

<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<script>
/* $('#login-button').click(function (event) {
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
}); */
</script>

<!-- 把user id复制到一个js变量 -->
<script type="text/javascript">
    var me = '${me.userId}';
    var base = '${base}';
    $(function() {
    	
        $("#login_button").click(function() {
            $.ajax({
                url : base + "/user/login",
                type: "POST",
                data:$('#loginForm').serialize(),
                error: function(request) {
                    alert("Connection error");
                },
                dataType:"json",
                success: function(data) {
                   // alert(data);
                    if (data == true) {
                        //alert("登陆成功");
                        //location.reload();
                        location.href= base + "/service/";
                    } else {
                        alert("登陆失败,请检查账号密码")
                    }
                }
            });
            return false;
        });
        
    });
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
<!-- <h1>数据管理系统</h1> -->
</div>
</body>
</html>