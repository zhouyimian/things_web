<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css"/>
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
                        <span>资源下载</span>
                    </h1>
                </article>

                <form id="contact-form" class="row" action="<c:url value='/ResourceController/download.action'/>" method="post" enctype="multipart/form-data">

                    <div class="span2">
                        <label for="resource_title">资源名</label>
                    </div>
                    <div class="span6">
                        <input type="text" name="resource_title" id="resource_title" readonly  value="${resource.resource_title}">
                    </div>
                    <div class="span2">
                        <label>资源描述</label>
                    </div>
                    <div class="span6">
                        ${resource.resource_article}
                    </div>
                    <input type="hidden" name="filename" value="${resource.url}">
                    <input type="hidden" name="filedownloadname" value="${resource.resource_title}">
                    <div class="span6 offset2 bm30">
                        <input type="submit" name="submit" value="下载" class="btn btn-inverse">
                        <img src="../../images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>

                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>
                    <div style="color: red">${msg}</div>
                </form>
            </div>
            <!-- end of page content -->
        </div>
    </div>
</div>
<!-- End of Page Container -->
</body>
</html>

