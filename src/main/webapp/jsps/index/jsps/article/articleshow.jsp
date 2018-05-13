<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/7
  Time: 11:10
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

    <link rel="shortcut icon" href="../../images/favicon.png" />




    <!-- Style Sheet-->
    <link rel="stylesheet" href="style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css' href='${pageContext.request.contextPath}/jsps/index/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css' href='${pageContext.request.contextPath}/jsps/index/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css' href='${pageContext.request.contextPath}/jsps/index/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css' href='${pageContext.request.contextPath}/jsps/index/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css' href='${pageContext.request.contextPath}/jsps/index/css/custom5152.html?ver=1.0' type='text/css' media='all' />


    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script></script>
    <![endif]-->

</head>

<body>

<jsp:include page="../index/navigation.jsp" />


<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">
                <article class=" type-post format-standard hentry clearfix">
                    <h1 class="post-title"><a href="#">${article.title}</a></h1>
                    <div class="post-meta clearfix">
                        <span class="date"><fmt:formatDate value='${article.update_time}' pattern='yyyy-MM-dd'/></span>
                        <span class="category"><a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a></span>
                        <span class="like-count">66</span>
                    </div>
                    ${article.content}
                </article>
            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">
                <section class="widget">
                    <h3 class="title">最新文章</h3>
                    <ul class="articles">
                        <c:forEach items="${newestArticle}" var="article">
                            <li class="article-entry image">
                                <h4><a href="<c:url value='/ArticleController/findArticleByAid.action?aid=${article.aid}'/>">${article.title}</a></h4>
                                <span class="article-meta"><fmt:formatDate value='${article.update_time}' pattern='yyyy-MM-dd'/>
                                    <a href="#" title="View all posts in Advanced Techniques">Advanced Techniques</a></span>
                                <span class="like-count">6</span>
                            </li>
                        </c:forEach>
                    </ul>
                </section>


                <!--<section class="widget">
                    <h3 class="title">Recent Comments</h3>
                    <ul id="recentcomments">
                        <li class="recentcomments"><a href="#" rel="external nofollow" class="url">John Doe</a> on <a href="#">Integrating WordPress with Your Website</a></li>
                        <li class="recentcomments">saqib sarwar on <a href="#">Integrating WordPress with Your Website</a></li>
                        <li class="recentcomments"><a href="#" rel="external nofollow" class="url">John Doe</a> on <a href="#">Integrating WordPress with Your Website</a></li>
                        <li class="recentcomments"><a href="#" rel="external nofollow" class="url">Mr WordPress</a> on <a href="#">Installing WordPress</a></li>
                    </ul>
                </section>-->
            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>


<a href="#top" id="scroll-top"></a>

</body>
</html>

