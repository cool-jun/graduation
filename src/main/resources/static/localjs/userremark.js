//查看报修信息
$('.userRemark').on("click", function () {
    let obj = $(this);
    window.location.href = "torepairremark?repair_id=" + obj.attr("data-remark");
});