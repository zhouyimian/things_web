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

    <!--  文章编辑器-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsps/index/simditor-2.3.5/styles/simditor.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsps/index/simditor-2.3.5/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsps/index/simditor-2.3.5/scripts/module.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsps/index/simditor-2.3.5/scripts/hotkeys.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsps/index/simditor-2.3.5/scripts/uploader.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsps/index/simditor-2.3.5/scripts/simditor.min.js"></script>

    <script>
        $(document).ready(function(){
            //初始化文本编辑器
            var editor = new Simditor({
                //textarea的id
                textarea: $('#content'),
                //工具条都包含哪些内容
                toolbar:['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', 'ol', 'ul', 'code', 'table',  'link', 'image', 'hr', 'indent', 'outdent', 'alignment'],
            });
        });
    </script>

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

    <ul class="breadcrumb">
        <li class="active">用户反馈</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="well">
                ${feedBack.message}
            </div>
            <c:if test="${feedBack.state==0}">
                <form action="<c:url value='/FeedBackController/feedbackuser.action' />" method="post">
                    <input type="hidden" name="fid" value="${feedBack.fid}">
                    <textarea name="feedbacnmessage" id="content" class="required span6" rows="6" title="* Please enter your message"></textarea>
                    <input type="submit" value="回复用户">
                </form>
            </c:if>
            <c:if test="${feedBack.state==1}">
                ${feedBack.feedbackmessage}
            </c:if>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath }/jsps/admin/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
    });
</script>

</body>
</html>



