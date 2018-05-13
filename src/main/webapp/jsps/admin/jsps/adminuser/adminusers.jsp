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
        <h1 class="page-title">全部用户</h1>
    </div>

    <ul class="breadcrumb">
        <li class="active">Users</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">

            <div class="well">
                <table class="table">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>电子邮箱</th>
                        <th style="width: 26px;"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${UserpageQuery.items}" var="user">
                        <tr>
                            <td>${user.uid}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>


            <div class="pagination">
                <ul>
                    <c:if test="${UserpageQuery.currentPage!=1}">
                        <li><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=1'/>">首页</a></li>
                        <li><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=${UserpageQuery.currentPage-1}'/>">上一页</a></li>
                    </c:if>
                    <c:choose>
                        <c:when test="${UserpageQuery.totalPage<=6}">
                            <c:set var="begin" value="1" />
                            <c:set var="end" value="${UserpageQuery.totalPage}" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="${UserpageQuery.currentPage-2 }"/>
                            <c:set var="end" value="${UserpageQuery.currentPage + 3}"/>
                            <c:if test="${begin < 1 }">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="6"/>
                            </c:if>
                            <c:if test="${end > UserpageQuery.totalPage }">
                                <c:set var="begin" value="${UserpageQuery.totalPage-5 }"/>
                                <c:set var="end" value="${UserpageQuery.totalPage}"/>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${begin >1 }">
                    <li><a href="#" class="btn active">...</a></li>
                    </c:if>
                    <c:forEach var="i" begin="${begin}" end="${end}">
                        <c:choose>
                            <c:when test="${i==UserpageQuery.currentPage}">
                                <li><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=${i}'/>" style="background: #575bd1" class="btn active">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=${i}'/>" class="btn active">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${end < UserpageQuery.totalPage }">
                        <li><a href="#" class="btn active">...</a></li>
                    </c:if>
                    <c:if test="${UserpageQuery.currentPage!=UserpageQuery.totalPage}">
                    <li><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=${UserpageQuery.currentPage+1}'/>">下一页</a></li>
                        <li><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=${UserpageQuery.totalPage}'/>">尾页</a></li>
                    </c:if>
                </ul>
            </div>

            <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Delete Confirmation</h3>
                </div>
                <div class="modal-body">
                    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                    <button class="btn btn-danger" data-dismiss="modal">Delete</button>
                </div>
            </div>



            <footer>
                <hr>
                <p>&copy; 2012 <a href="<c:url value='#'/>" target="_blank">Portnine</a></p>
            </footer>

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



