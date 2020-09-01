//删除入库记录
$('.deleteInbound').on("click", function () {
    let obj = $(this);
    if (confirm("你确定要删除入库记录吗?")) {
        $.ajax({
            type:"GET",
            url:"deleteinbound",
            data:{
                inbound_id: obj.attr("data-delete")
            },
            dataType:"json",
            success:function (data) {
                if (data.inboundDeleteResult === "deleteSuccess") {
                    alert("删除成功！");
                    obj.parents("tr").remove();
                    window.location.href = "inboundinfolist";
                } else if (data.inboundDeleteResult === "deleteFailure") {
                    alert("对不起，删除失败");
                } else if (data.inboundDeleteResult === "notExist") {
                    alert("对不起，销售记录不存在");
                }
            },
            error:function (data) {
                alert("删除失败！" + data);
            }
        })
    }
});

//修改入库记录
$('.modifyInbound').on("click", function () {
    let obj = $(this);
    window.location.href = "toinboundmodify?inbound_id=" + obj.attr("data-modify");
});