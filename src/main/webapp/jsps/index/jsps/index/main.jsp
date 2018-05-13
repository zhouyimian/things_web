<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/7
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
<head>
    <!-- META TAGS -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Knowledge Base Theme</title>

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/jsps/index/images/favicon.png" />

    <!-- Style Sheet-->
    <link rel="stylesheet" href="style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css' href='${pageContext.request.contextPath}/jsps/index/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css' href='${pageContext.request.contextPath}/jsps/index/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css' href='${pageContext.request.contextPath}/jsps/index/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css' href='${pageContext.request.contextPath}/jsps/index/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css' href='${pageContext.request.contextPath}/jsps/index/css/custom5152.html?ver=1.0' type='text/css' media='all' />


</head>

<body>
<jsp:include page="navigation.jsp" />
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">
            <!-- start of page content -->
            <div class="span8 page-content">
                <!-- Basic Home Page Template -->
                <div class="row separator">
                    <section class="span4 articles-list">
                        <h3>最新资源</h3>
                        <ul class="articles">
                            <li class="article-entry standard">
                                <c:forEach items="${newestResource}" var="resource">
                                    <h4><a href="${pageContext.request.contextPath}/ResourceController/findResourceByRid.action?rid=${resource.rid}">${resource.resource_title}</a></h4>
                                    <span class="article-meta"><fmt:formatDate value='${resource.update_time}' pattern='yyyy-MM-dd'/></span>
                                </c:forEach>
                            </li>
                        </ul>
                    </section>
                    <section class="span4 articles-list">
                        <h3>最新文章</h3>
                        <ul class="articles">
                            <c:forEach items="${newestArticle}" var="article">
                                <li class="article-entry standard">
                                    <h4><a href="<c:url value='/ArticleController/findArticleByAid.action?aid=${article.aid}'/>">${article.title}</a></h4>
                                    <span class="article-meta"><fmt:formatDate value='${article.update_time}' pattern='yyyy-MM-dd'/><a href="#" title="View all posts in Theme Development"></a></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </section>
                </div>
            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">

                <section class="widget">
                    <div class="support-widget">
                        <h3 class="title">查找不到资源？</h3>
                        <p class="intro">Need more support? If you did not found the resource, contact us for further help.</p>
                    </div>
                </section>

                <section class="widget">
                    <div class="quick-links-widget">
                        <h3 class="title">链接</h3>
                        <ul id="menu-quick-links" class="menu clearfix">
                            <li><a href="${pageContext.request.contextPath}/jsps/index/jsps/index/index.jsp">主页</a></li>
                            <li><a href="${pageContext.request.contextPath}/jsps/index/jsps/article/articles-list.jsp">文章列表</a></li>
                            <li><a href="${pageContext.request.contextPath}/jsps/index/jsps/feedback/feedback.jsp">联系我们</a></li>
                        </ul>
                    </div>
                </section>

                <section class="widget">
                    <h3 class="title">标签</h3>
                    <div class="tagcloud">
                        <c:forEach items="${categoryList}" var="category">
                            <a href="#" class="btn btn-mini">${category.cname}</a>
                        </c:forEach>
                    </div>
                </section>
            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->
</body>
</html>