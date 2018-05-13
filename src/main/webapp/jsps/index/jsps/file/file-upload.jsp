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
                textarea: $('#resource_article'),
                //工具条都包含哪些内容
                toolbar:['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', 'ol', 'ul', 'code', 'table',  'link', 'image', 'hr', 'indent', 'outdent', 'alignment'],
                //若需要上传功能，上传的参数设置。
                upload : {
                    url : 'things_web/ResourceController/uploadresource.action', //文件上传的接口地址
                    params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                    fileKey: 'fileDataFileName', //服务器端获取文件数据的参数名
                    connectionCount: 3,
                    leaveConfirm: '正在上传文件'
                }
            });
        });
    </script>

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
                        <span>资源上传</span>
                    </h1>
                    <hr>
                    <p>上传的资源只允许是压缩包并且大小不能超过10M，而且请写上关于该资源的详细使用环境或使用过程</p>
                </article>

                <form id="contact-form" class="row" action="<c:url value='/ResourceController/uploadresource.action?a=5 6'/>" method="post" enctype="multipart/form-data">

                    <div class="span2">
                        <label for="resource_title">资源名</label>
                    </div>
                    <div class="span6">
                        <input type="text" name="resource_title" id="resource_title">
                    </div>

                    <div class="span2">
                        <label for="category">资源类别</label>
                    </div>
                    <div class="span6">
                        <select id="category" name="categoryid">
                            <c:forEach items="${categoryList}" var="category">
                                <option value ="${category.cid}">${category.cname}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="span2">
                        <label for="file">文件上传</label>
                    </div>
                    <div class="span6">
                        <input type="file" name="file" id="file">
                    </div>


                    <div class="span2">
                        <label for="resource_article">资源描述</label>
                    </div>
                    <div class="span6">
                        <textarea name="resource_article" id="resource_article" class="required span6" rows="6" title="* Please enter your message"></textarea>
                    </div>
                    <div class="span6 offset2 bm30">
                        <input type="submit" name="submit" value="上传" class="btn btn-inverse">
                        <img src="../../images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>

                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>
                    <c:if test="${msg!=null}">
                        <div style="color: red;font-size:large;text-align: center">${msg}</div>
                        <c:remove var="msg"/>
                    </c:if>
                </form>
            </div>
            <!-- end of page content -->
        </div>
    </div>
</div>
<!-- End of Page Container -->
</body>
</html>

