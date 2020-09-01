//查看处理信息
$('.repairHandle').on("click", function () {
    let obj = $(this);
    window.location.href = "torepairhandle?repair_id=" + obj.attr("data-handle");
});