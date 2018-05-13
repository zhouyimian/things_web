<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/7
  Time: 11:05
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
    <link rel='stylesheet' id='custom-css-css'  href='${pageContext.request.contextPath}/jsps/index/css/custom5152.jsp?ver=1.0' type='text/css' media='all' />


    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script></script>

    <![endif]-->
    <script>
        window.onload=function () {
            var divlist=document.getElementsByClassName("content");
            for(var i=0;i<divlist.length;i++){
                divlist[i].innerHTML=divlist[i].innerHTML.replace(/<[^>]+>/g, "");
            }
        }
    </script>

</head>

<body>

<jsp:include page="../index/navigation.jsp" />

<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">
            <div class="tagcloud" style="margin-left: 28px;font-size: 20px">
                我的文章
            </div>
            <!-- start of page content -->
            <div class="span8 main-listing">
                <c:forEach items="${ArticlepageQuery.items}" var="item">
                    <article class=" type-post  format-standard hentry clearfix">
                        <header class="clearfix">
                            <h3 class="post-title">
                                <a href="<c:url value='/ArticleController/findArticleByAid.action?aid=${item.aid}'/> ">${item.title}</a>
                            </h3>
                            <div class="post-meta clearfix">
                                <span class="date"><fmt:formatDate value='${item.update_time}' pattern='yyyy-MM-dd'/></span>
                            </div>
                        </header>
                        <p>
                            <div style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden" class="content">${item.content}</div>
                            <a style="color: #13cfd1;" class="readmore-link" href="<c:url value='/ArticleController/editarticle.action?aid=${item.aid}'/>">编辑&nbsp;</a>
                        <a style="color:red;" class="readmore-link" href="<c:url value='/ArticleController/deleteArticleByAid.action?aid=${item.aid}'/>">删除</a>
                        </p>
                    </article>
                </c:forEach>
                <div id="pagination">
                    <c:if test="${ArticlepageQuery.currentPage!=1}">
                        <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=1&uid=${user.uid}'/>" class="btn active">首页</a>
                        <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=${ArticlepageQuery.currentPage-1}&uid=${user.uid}'/>" class="btn active">上一页</a>
                    </c:if>
                    <c:choose>
                        <c:when test="${ArticlepageQuery.totalPage<=6}">
                            <c:set var="begin" value="1" />
                            <c:set var="end" value="${ArticlepageQuery.totalPage}" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="${ArticlepageQuery.currentPage-2 }"/>
                            <c:set var="end" value="${ArticlepageQuery.currentPage + 3}"/>
                            <c:if test="${begin < 1 }">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="6"/>
                            </c:if>
                            <c:if test="${end > ArticlepageQuery.totalPage }">
                                <c:set var="begin" value="${ArticlepageQuery.totalPage-5 }"/>
                                <c:set var="end" value="${ArticlepageQuery.totalPage}"/>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${begin >1 }">
                        <a href="#" class="btn active">...</a>
                    </c:if>
                    <c:forEach var="i" begin="${begin}" end="${end}">
                        <c:choose>
                            <c:when test="${i==ArticlepageQuery.currentPage}">
                                <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=${i}&uid=${user.uid}'/>" style="background: #575bd1" class="btn active">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=${i}&uid=${user.uid}'/>" class="btn active">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${end < ArticlepageQuery.totalPage }">
                        <a href="#" class="btn active">...</a>
                    </c:if>
                    <c:if test="${ArticlepageQuery.currentPage!=ArticlepageQuery.totalPage}">
                        <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=${ArticlepageQuery.currentPage+1}&uid=${user.uid}'/>" class="btn active">下一页</a>
                        <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=${ArticlepageQuery.totalPage}&uid=${user.uid}'/>" class="btn active">尾页</a>
                    </c:if>
                </div>

            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">

                <section class="widget">
                    <h3 class="title">最新资源</h3>
                    <ul class="articles">
                        <c:forEach items="${newestResource}" var="resource">
                            <h4><a href="${pageContext.request.contextPath}/ResourceController/findResourceByRid.action?rid=${resource.rid}">${resource.resource_title}</a></h4>
                            <span class="article-meta"><fmt:formatDate value='${resource.update_time}' pattern='yyyy-MM-dd'/></span>
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
