<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${path}/resources/bootstrap.css">
    <link rel="stylesheet" href="${path}/resources/plugins/nprogress/nprogress.css"/>
    <link rel="stylesheet" href="${path}/resources/plugins/toastr/toastr.css"/>
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

        <tbody>
        <c:forEach items="${page.dataList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.pwd}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <div class="row">

        <div class="col-md-2">
            <p>
                <span id="pnSpan">${page.pageNumber}</span> / <span id="tpSpan">${page.totalPage}</span> 页，
                总共 <span id="trSpan">${page.totalRecord}</span> 条
            </p>
        </div>

        <div style="float: right;">

            <%-- 首页按钮 --%>
            <button class="btn btn-sm btn-default" id="firstBtn"><<</button>

            <%-- 上一页按钮 --%>
            <button class="btn btn-sm btn-default" id="preBtn"><</button>

            <div id="pageBtnGroup" style="display: inline-block">
                <c:forEach begin="1" end="${page.totalPage}" var="number">
                    <c:if test="${number == page.pageNumber}">
                        <button class="btn btn-sm btn-default btn-primary pageBtn now"
                                data-number="${number}">${number}</button>
                    </c:if>
                    <c:if test="${number != page.pageNumber}">
                        <button class="btn btn-sm btn-default pageBtn" data-number="${number}">${number}</button>
                    </c:if>
                </c:forEach>
            </div>

            <%-- 下一页按钮 --%>
            <button class="btn btn-sm btn-default" id="nextBtn">></button>

            <%-- 最后一页按钮 --%>
            <button class="btn btn-sm btn-default" id="lastBtn">>></button>

        </div>

    </div>

</div>

<script src="${path}/resources/jquery-3.1.1.js"></script>
<script src="${path}/resources/plugins/nprogress/nprogress.js"></script>
<script src="${path}/resources/plugins/toastr/toastr.js"></script>

<script>

    var pageNumber = ${page.pageNumber};
    var pageSize = 3;
    var totalPage = ${page.totalPage};
    var totalRecord = ${page.totalRecord};

    /**
     * 页码点击事件
     */
    $(".pageBtn").click(function () {
        var number = $(this).data("number");
        $(".now").removeClass("btn-primary now");
        $(this).addClass("btn-primary now");
        getData(number, pageSize);
    });

    /**
     * 首页按钮点击事件
     */
    $("#firstBtn").click(function () {
        $(".now").removeClass("btn-primary now");
        $(".pageBtn:first").addClass("btn-primary now");
        getData(1, pageSize);
    });

    /**
     * 上一页按钮点击事件
     */
    $("#preBtn").click(function () {
        if (pageNumber == 1) {
            toastr.warning("已经在第一页");
        } else {
            // 改变样式
            var $now = $(".now");
            $now.removeClass("btn-primary now");
            $now.prev().addClass("btn-primary now");
            // 获取数据
            getData(pageNumber - 1, pageSize);
        }
    });

    /**
     * 下一页按钮点击事件
     */
    $("#nextBtn").click(function () {
        if (pageNumber == totalPage) {
            toastr.warning("已经在最后一页");
        } else {
            // 改变样式
            var $now = $(".now");
            $now.removeClass("btn-primary now");
            $now.next().addClass("btn-primary now");
            // 获取数据
            getData(pageNumber + 1, pageSize);
        }
    });

    /**
     * 最后一页按钮点击事件
     */
    $("#lastBtn").click(function () {
        $(".now").removeClass("btn-primary");
        $(".now").removeClass("now");
        $(".pageBtn:last").addClass("btn-primary");
        $(".pageBtn:last").addClass("now");
        getData(totalPage, pageSize);
    });

    /**
     * ajax请求表单数据
     * @param i 页码
     * @param n 页面记录条数
     */
    function getData(i, n) {
        $.ajax({
            url: "${path}/data.htm",
            data: {
                "pageNumber": i,
                "pageSize": n
            },
            dataType: "json",
            beforeSend: function () {
                NProgress.start();
            },
            success: function (resp) {
                pageNumber = resp.pageNumber;
                totalPage = resp.totalPage;
                totalRecord = resp.totalRecord;
                $("#pnSpan").text(pageNumber);
                $("#tpSpan").text(totalPage);
                $("#trSpan").text(totalRecord);
                // 更新表格
                refresh(resp.dataList);
                NProgress.done();
            },
            error: function (e) {
                alert("网络错误，稍后重试!");
                NProgress.done();
            }
        });
    }

    /**
     * 刷新表单数据
     * @param data 表单数据
     */
    function refresh(data) {
        var $userTableBody = $("#table tbody");
        $userTableBody.empty();

        // jQuery遍历数组
        $.each(data, function (index, value) {
            var $tr = $("<tr></tr>");
            var id = value.id;
            var name = value.name;
            var pwd = value.pwd;
            var $td1 = $("<td></td>");
            $td1.text(id);
            $td1.appendTo($tr);
            var $td2 = $("<td></td>");
            $td2.text(name);
            $td2.appendTo($tr);
            var $td3 = $("<td></td>");
            $td3.text(pwd);
            $td3.appendTo($tr);
            $tr.appendTo($userTableBody);
        });

    }

</script>


</body>
</html>
