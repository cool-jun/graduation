//查看销售信息
$('.showSale').on("click", function () {
    let obj = $(this);
    $.ajax({
        type:"GET",
        url:"showsale",
        data:{
            sale_id: obj.attr("data-show")
        },
        dataType:"json",
        success:function (data) {
            document.getElementById("sale_id").value = data.sale_show.sale_id;
            document.getElementById("customer_name").value = data.sale_show.customer_name;
            document.getElementById("telephone").value = data.sale_show.telephone;
            document.getElementById("address").value = data.sale_show.address;
            document.getElementById("area").value = data.sale_show.area;
            document.getElementById("sale_type").value = data.sale_show.sale_type;
            document.getElementById("service_status").value = data.sale_show.service_status;
            document.getElementById("sponsor").value = data.sale_show.sponsor;
            document.getElementById("money").value = data.sale_show.money;
            document.getElementById("price").value = data.sale_show.price;
            document.getElementById("sale_number").value = data.sale_show.sale_number;
            document.getElementById("number").value = data.sale_show.number;
            document.getElementById("product_name").value = data.sale_show.product_name;
            document.getElementById("spec").value = data.sale_show.product_spec;
            document.getElementById("sale_person").value = data.sale_show.sale_person;
            document.getElementById("sale_date").value = data.sale_show.sale_date;
        },
        error:function (data) {
            alert("查看失败" + data);
        }
    });
    $('#sale_show').modal('show');
});

//删除销售信息
$('.deleteSale').on("click", function () {
    let obj = $(this);
    if (confirm("你确定要删除客户【" + obj.attr("data-saleName") + "】的销售记录吗")) {
        $.ajax({
            type:"GET",
            url:"deletesale",
            data:{
                sale_id: obj.attr("data-delete")
            },
            dataType:"json",
            success:function (data) {
                if (data.saleDeleteResult === "deleteSuccess") {
                    alert("删除成功！");
                    obj.parents("tr").remove();
                    window.location.href = "saleinfolist";
                } else if (data.saleDeleteResult === "deleteFailure") {
                    alert("对不起，删除失败");
                } else if (data.saleDeleteResult === "notExist") {
                    alert("对不起，销售记录不存在");
                }
            },
            error:function (data) {
                alert("删除失败！" + data);
            }
        })
    }
});

//修改销售信息
$('.modifySale').on("click", function () {
    let obj = $(this);
    window.location.href = "tosalemodify?sale_id=" + obj.attr("data-modify");
});