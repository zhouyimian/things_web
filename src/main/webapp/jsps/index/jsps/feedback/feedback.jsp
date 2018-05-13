<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/7
  Time: 11:07
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

                <article class="type-page hentry clearfix">
                    <h1 class="post-title">
                        <a href="#">联系方式</a>
                    </h1>
                    <hr>
                    <p>请留下您的姓名，电子邮箱和遇到的问题，我们会在解决问题后第一时间与您联系</p>
                </article>


                <form id="contact-form" class="row" action="<c:url value='/FeedBackController/receive.action'/> " method="post">
                    <input type="hidden" name="uid" value="${user.uid}" />
                    <div class="span2">
                        <label for="name">姓名</label>
                    </div>
                    <div class="span6">
                        <input type="text" name="name" id="name" class="required input-xlarge" title="* Please provide your name">
                    </div>

                    <div class="span2">
                        <label for="email">电子邮箱</label>
                    </div>
                    <div class="span6">
                        <input type="text" name="email" id="email" class="email required input-xlarge" value="" title="* Please provide a valid email address">
                    </div>

                    <div class="span2">
                        <label for="message">问题描述</label>
                    </div>
                    <div class="span6">
                        <textarea name="message" id="message" class="required span6" rows="6" title="* Please enter your message"></textarea>
                    </div>

                    <div class="span6 offset2 bm30">
                        <input type="submit" name="submit" value="点击发送" class="btn btn-inverse">
                        <img src="../../images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>

                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>

                </form>
                <c:if test="${received!=null}">
                    <h3 style="color: red">${received}</h3>
                    <c:remove var="received"></c:remove>
                </c:if>
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


            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->
</body>
</html>


