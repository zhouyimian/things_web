<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/7
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/css/form-elements.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/jsps/user/SignIn/assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>注册</strong>Sign Up</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>欢迎注册</h3>
                            <p>输入用户名，密码，确认密码，电子邮箱</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form id="registForm" role="form" action="<c:url value='/UserController/regist.action'/>" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="username">Username</label>
                                <input type="text" name="username" placeholder="Username..."
                                       class="form-username form-control" id="username" value="KingYM">
                            </div>
                            <div id="usernameError" style="text-align: center;color: red"></div>


                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <input type="password" name="password" placeholder="Password..."
                                       class="form-password form-control" id="password" value="313976009">
                            </div>
                            <div id="passwordError" style="text-align: center;color: red"></div>


                            <div class="form-group">
                                <label class="sr-only" for="confirmpassword">ConfirmPassword</label>
                                <input type="password" name="password" placeholder="ConfirmPassword..."
                                       class="form-password form-control" id="confirmpassword" value="313976009">
                            </div>
                            <div id="confirmpasswordError" style="text-align: center;color: red"></div>


                            <div class="form-group">
                                <label class="sr-only" for="email">Email</label>
                                <input type="text" name="email" placeholder="Email..."
                                       class="form-password form-control" id="email" value="313976009@qq.com">
                            </div>
                            <div id="emailError" style="text-align: center;color: red"></div>

                            <button type="submit" class="btn">注册</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<script src="${pageContext.request.contextPath}/jsps/user/SignUp/assets/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/jsps/user/SignUp/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/jsps/user/SignUp/assets/js/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}/jsps/user/SignUp/assets/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/jsps/user/SignUp/assets/js/signup.js"></script>

</body>

</html>
