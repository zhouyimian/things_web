<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/4/24
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-wrapper">
    <header>
        <div class="container">
            <div class="logo-container">
                <!-- Website Logo -->
                <span title="Knowledge Base Theme">
                    <img src="${pageContext.request.contextPath}/jsps/index/images/logo.png" alt="Knowledge Base Theme">
                </span>
                <span class="tag-line">东西网</span>
            </div>
            <!-- Start of Main Navigation -->
            <nav class="main-nav">
                <div class="menu-top-menu-container">
                    <ul id="menu-top-menu" class="clearfix">
                        <li><a href="<c:url value='/jsps/index/jsps/index/index.jsp'/>">主页</a></li>
                        <li><a href="<c:url value='/PageQueryController/loadArticlepage.action?ArticlepageQuery=1'/>">文章列表</a></li>
                        <li><a href="<c:url value='/PageQueryController/loadResourcepage.action?ResourcepageQuery=1'/>">资源列表</a></li>
                        <c:choose>
                            <c:when test="${user!=null}">
                                <li><a href="#">${user.username}</a>
                                    <ul class="sub-menu">
                                        <li><a href="<c:url value='/jsps/index/jsps/file/file-upload.jsp'/>">资源上传</a></li>
                                        <li><a href="<c:url value='/jsps/index/jsps/article/article-publish.jsp'/>">文章发表</a></li>
                                        <li>
                                            <a href="<c:url value='/PageQueryController/getResourceListByUid.action?ResourcepageQuery=1&uid=${user.uid}'/>">我的资源</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value='/PageQueryController/getArticleListByUid.action?ArticlepageQuery=1&uid=${user.uid}'/>">我的文章</a>
                                        </li>
                                        <li><a href="<c:url value='/UserController/SignOut.action'/>">退出</a></li>
                                    </ul>
                                </li>
                                <li><a href="<c:url value='/jsps/index/jsps/feedback/feedback.jsp' />">联系我们</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value='/jsps/user/SignIn/SignIn.jsp'/>">登录</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </nav>
            <!-- End of Main Navigation -->

        </div>
    </header>
</div>
<!-- End of Header -->

<!-- Start of Search Wrapper -->
<div class="search-area-wrapper">
    <div class="search-area container">
        <form id="search-form" class="search-form clearfix" method="get" autocomplete="off">
            <input class="search-term required" type="text" id="s" name="searchmessage" placeholder="输入想要查询的资源或文章" />
            <input type="hidden" name="page" value="1">
            <div id="search-error-container"></div>
            <input class="search-btn" type="submit" name="searchArticle" value="相关文章" onclick="is_submit(searchArticle)"/>
            <input class="search-btn" type="submit" name="searchResource" value="相关资源" onclick="is_submit(searchResource)"/>
        </form>
    </div>
</div>
<!-- End of Search Wrapper -->
<script>
    function is_submit(method){
        var methodname=method.value;
        if(methodname=="相关文章"){
            document.getElementById("search-form").action="${pageContext.request.contextPath }/SolrController/solrSearchArticle.action";
        }
        else{
            document.getElementById("search-form").action="${pageContext.request.contextPath }/SolrController/solrSearchResource.action";
        }
        document.getElementById("search-form").submit();
    }
</script>
<script type='text/javascript' src='<c:url value='../../js/jquery-1.8.3.min.js' />'></script>
<script type='text/javascript' src='<c:url value='../../js/jquery.easing.1.3.js' />'></script>
<script type='text/javascript' src='<c:url value='../../js/prettyphoto/jquery.prettyPhoto.js' />'></script>
<script type='text/javascript' src='<c:url value='../../js/jflickrfeed.js' />'></script>
<script type='text/javascript' src='<c:url value='../../js/jquery.liveSearch.js' />'></script>
<script type='text/javascript' src='<c:url value='../../js/jquery.form.js' />'></script>
<!--<script type='text/javascript' src='<c:url value='../../js/jquery.validate.min.js' />'></script>-->
<script type='text/javascript' src='<c:url value='../../js/custom.js' />'></script>