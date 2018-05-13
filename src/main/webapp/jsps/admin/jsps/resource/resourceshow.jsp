<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/20
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsps/admin/lib/bootstrap/css/bootstrap.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsps/admin/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/jsps/admin/lib/font-awesome/css/font-awesome.css">

    <script src="${pageContext.request.contextPath }/jsps/admin/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->



</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
<!--<![endif]-->

<jsp:include page="../index/navigation.jsp" />

<div class="content">

    <div class="header">
        <h1 class="page-title">${resource.resource_title}</h1>
    </div>
    <ul class="breadcrumb">
        <li class="active">资源</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">
            <form id="submit-form" method="get">
                <div class="well">
                    ${resource.resource_article}
                </div>
                <c:if test="${resource.state==0}">
                    <input type="hidden" id="state" name="state">
                    <input type="hidden" id="rid" name="rid">
                    <input type="submit" value="确认审核" name="agree" onclick="is_submit(agree)" />
                    <input type="submit" value="审核未通过" name="disagree" onclick="is_submit(disagree)" />
                </c:if>
            </form>
        </div>
    </div>
</div>

<script>
    function is_submit(method){
        var methodname=method.value;
        if(methodname=="确认审核"){
            document.getElementById("submit-form").action="${pageContext.request.contextPath }/ResourceController/changeResourceState.action";
            document.getElementById("state").value="1";
            document.getElementById("rid").value="${resource.rid}";
        }
        else{
            document.getElementById("submit-form").action="${pageContext.request.contextPath }/ResourceController/changeResourceState.action";
            document.getElementById("state").value="2";
            document.getElementById("rid").value="${resource.rid}";
        }
        document.getElementById("submit-form").submit();
    }
</script>

<script src="${pageContext.request.contextPath }/jsps/admin/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
    });
</script>

</body>
</html>



