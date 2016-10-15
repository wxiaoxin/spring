<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${path}/resources/bootstrap.css">
    <link rel="stylesheet" href="${path}/resources/plugins/nprogress/nprogress.css"/>
    <link rel="stylesheet" href="${path}/resources/plugins/toastr/toastr.css"/>
    <link rel="stylesheet" href="${path}/resources/plugins/jPages/jPages.css"/>
</head>
<body>

<div class="container">

    <h1>用户管理</h1>

    <table id="table" class="table table-hover">

        <thead>
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        </thead>

        <tbody id="tbody">
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.pwd}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <div class="row">
        <div class="holder"></div>
    </div>

</div>

<script src="${path}/resources/jquery-3.1.1.js"></script>
<script src="${path}/resources/plugins/nprogress/nprogress.js"></script>
<script src="${path}/resources/plugins/toastr/toastr.js"></script>
<script src="${path}/resources/plugins/jPages/jPages.js"></script>

<script>

    NProgress.start();

    /**
     * 所有数据由服务器取出传到前台后，完全交由前台进行分页
     */
    $(function () {
        $("div.holder").jPages({
            perPage: 6,
            callback: function(pages, items) {
                NProgress.start();
                NProgress.done();
            }
        });
    });

    NProgress.done();

</script>


</body>
</html>
