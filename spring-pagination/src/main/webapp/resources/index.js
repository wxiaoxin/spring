/**
 * Created by wxiao on 2016.10.14.
 */

$(".pageBtn").click(function () {
    var number = $(this).data("number");
    $(".btn-primary").removeClass("btn-primary");
    $(this).addClass("btn-primary now");
    getData(number, 3);
});

$("#firstBtn").click(function () {
    $(".now").removeClass("btn-primary now");
    $(".pageBtn:first").addClass("btn-primary now");
    getData(1, 3);
});

$("#preBtn").click(function () {
    if (pageNumber == 1) {
        alert("已经在第一页");
    } else {
        // 改变样式
        var $now = $(".now");
        $now.removeClass("btn-primary now");
        $now.prev().addClass("btn-primary now");
        // 获取数据
        getData(pageNumber - 1, 3);
    }
});

$("#nextBtn").click(function () {
    if (pageNumber == totalPage) {
        alert("已经在最后一页");
    } else {
        // 改变样式
        var $now = $(".now");
        $now.removeClass("btn-primary now");
        $now.next().addClass("btn-primary now");
        // 获取数据
        getData(pageNumber + 1, 3);
    }
});

$("#lastBtn").click(function () {
    console.log("最后一页");
    $(".now").removeClass("btn-primary");
    $(".now").removeClass("now");
    $(".pageBtn:last").addClass("btn-primary");
    $(".pageBtn:last").addClass("now");
    getData(totalPage, 3);
});

function getData(i, n) {
    $.ajax({
        url: path + "/data.htm",
        data: {
            "pageNumber": i,
            "pageSize": n
        },
        dataType: "json",
        success: function (resp) {
            pageNumber = resp.pageNumber;
            pageSize = resp.pageSize;
            totalPage = resp.totalPage;
            totalRecord = resp.totalRecord;
            $("#pnSpan").text(pageNumber);
            $("#tpSpan").text(totalPage);
            $("#trSpan").text(totalRecord);
            // 更新表格
            refresh(resp.dataList);
            console.log(resp);
        },
        error: function (e) {
            alert("网络错误，稍后重试!");
        }
    });
}


function refresh(data) {
    var $userTableBody = $("#userTable + tbody");
    $userTableBody.empty();

    // jQuery遍历数组
    $.each(data, function(index, value){
        var $tr = $("<tr></tr>");
        var id = value.id;
        var name = value.name;
        var pwd = value.pwd;
        var $td = $("<td></td>");
        $td.text(id);
        $td.appendTo($tr);
        $td.text(name);
        $td.appendTo($tr);
        $td.text(pwd);
        $td.appendTo($tr);
        $tr.appendTo($userTableBody);
    });

    // 原生js遍历数组
    /*data.forEach(function (index) {
        var id = data[index].id;
        var name = data[index].name;
        var pwd = data[index].pwd;

    });*/
}
