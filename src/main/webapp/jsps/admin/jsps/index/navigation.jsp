<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/24
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">

            <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
            <li id="fat-menu" class="dropdown">
                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-user"></i> Jack Smith
                    <i class="icon-caret-down"></i>
                </a>

                <ul class="dropdown-menu">
                    <li><a tabindex="-1" href="#">My Account</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                    <li class="divider visible-phone"></li>
                    <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                </ul>
            </li>

        </ul>
        <a class="brand" href="#">
            <span class="second">东西网后台管理系统
                <c:if test="${adminer!=null}">
                    管理员：${adminer.adminname}
                </c:if>
            </span>
        </a>
    </div>
</div>

<div class="sidebar-nav">
    <a href="#accounts" class="nav-header collapsed" data-toggle="collapse"><i class="icon-briefcase"></i>账号管理<i class="icon-chevron-up"></i></a>
    <ul id="accounts" class="nav nav-list collapse">
        <li ><a href="<c:url value='/PageQueryController/loadUserspage.action?UserpageQuery=1'/>">用户账号</a></li>
        <li ><a href="<c:url value='/PageQueryController/loadAdminerspage.action?AdminerpageQuery=1'/>">管理员账号</a></li>
    </ul>

    <a href="#article-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>文章管理<i class="icon-chevron-up"></i></a>
    <ul id="article-menu" class="nav nav-list collapse">
        <li ><a href="<c:url value='/PageQueryController/loadArticlepage.action?ArticlepageQuery=1'/>">所有文章</a></li>
        <li ><a href="<c:url value='/PageQueryController/getArticleListByState.action?state=0&ArticlepageQuery=1'/> ">文章审核</a></li>
    </ul>

    <a href="#resource-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-legal"></i>资源管理<i class="icon-chevron-up"></i></a>
    <ul id="resource-menu" class="nav nav-list collapse">
        <li ><a href="<c:url value='/PageQueryController/loadResourcepage.action?ResourcepageQuery=1'/>">所有资源</a></li>
        <li ><a href="<c:url value='/PageQueryController/getResourceListByState.action?state=0&ResourcepageQuery=1' />">资源审核</a></li>
    </ul>

    <a href="#feedback-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-legal"></i>用户反馈<i class="icon-chevron-up"></i></a>
    <ul id="feedback-menu" class="nav nav-list collapse">
        <li ><a href="<c:url value='/PageQueryController/getFeedbackList.action?FeedbackpageQuery=1'/>">所有反馈</a></li>
        <li ><a href="<c:url value='/PageQueryController/getFeedbackListByState.action?state=0&FeedbackpageQuery=1' />">反馈查询</a></li>
    </ul>

    <a href="#category-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-legal"></i>类别管理<i class="icon-chevron-up"></i></a>
    <ul id="category-menu" class="nav nav-list collapse">
        <li><a href="<c:url value='/PageQueryController/loadCategorypage.action?CategorypageQuery=1'/>">所有类别</a></li>
        <li><a href="<c:url value='/jsps/admin/jsps/category/addcategory.jsp'/>">增加类别</a></li>
    </ul>
</div>
