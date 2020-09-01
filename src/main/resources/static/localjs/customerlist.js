//查看客户信息
$('.showCustomer').on("click", function () {
    let obj = $(this);
    $.ajax({
        type:"GET",
        url:"showcustomer",
        data:{
            customer_id: obj.attr("data-show")
        },
        dataType:"json",
        success:function (data) {
            document.getElementById("show_customer_id").value = data.show_customer.customer_id;
            document.getElementById("show_customer_name").value = data.show_customer.customer_name;
            document.getElementById("show_telephone").value = data.show_customer.telephone;
            document.getElementById("show_address").value = data.show_customer.address;
            document.getElementById("show_area").value = data.show_customer.area;
            document.getElementById("show_sale_type").value = data.show_customer.sale_type;
            document.getElementById("show_service_status").value = data.show_customer.service_status;
            document.getElementById("show_sponsor").value = data.show_customer.sponsor;
        },
        error:function (data) {
            alert("查看失败" + data);
        }
    });
    $('#customer_show').modal('show');
});

//删除客户信息
$('.deleteCustomer').on("click", function () {
    let obj = $(this);
    if (confirm("你确定要删除客户【" + obj.attr("data-customerName") + "】的相关信息")) {
        $.ajax({
            type:"GET",
            url:"deletecustomer",
            data:{
                customer_id: obj.attr("data-delete")
            },
            dataType:"json",
            success:function (data) {
                if (data.deleteResult === "deleteSuccess") {
                    alert("删除成功！");
                    obj.parents("tr").remove();
                    window.location.href = "customerinfolist";
                } else if (data.deleteResult === "deleteFailure") {
                    alert("对不起，删除失败");
                } else if (data.deleteResult === "notExist") {
                    alert("对不起，客户不存在");
                }
            },
            error:function (data) {
                alert("删除失败！" + data);
            }
        })
    }
});

//修改客户信息
$('.modifyCustomer').on("click", function () {
   let obj = $(this);
   window.location.href = "tocustomermodify?customer_id=" + obj.attr("data-modify");
});