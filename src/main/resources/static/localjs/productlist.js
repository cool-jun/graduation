//查看产品信息
$('.showProduct').on("click", function () {
    let obj = $(this);
    $.ajax({
        type:"GET",
        url:"showproduct",
        data:{
            product_id: obj.attr("data-show")
        },
        dataType:"json",
        success:function (data) {
            document.getElementById("product_id_show").value = data.show_product.product_id;
            document.getElementById("product_type_show").value = data.show_product.product_type;
            document.getElementById("product_brand_show").value = data.show_product.product_brand;
            document.getElementById("product_name_show").value = data.show_product.product_name;
            document.getElementById("product_spec_show").value = data.show_product.product_spec;
            document.getElementById("product_factory_show").value = data.show_product.product_factory;
            document.getElementById("purchase_price_show").value = data.show_product.purchase_price;
            document.getElementById("sale_price_show").value = data.show_product.sale_price;
            document.getElementById("product_detail_show").value = data.show_product.product_detail;
        },
        error:function (data) {
            alert("查看失败" + data);
        }
    });
    $('#product_show').modal('show');
});

//删除产品信息
$('.deleteProduct').on("click", function () {
    let obj = $(this);
    if (confirm("你确定要删除产品【" + obj.attr("data-productName") + "】的相关信息")) {
        $.ajax({
            type:"GET",
            url:"deleteproduct",
            data:{
                product_id: obj.attr("data-delete")
            },
            dataType:"json",
            success:function (data) {
                if (data.productDeleteResult === "deleteSuccess") {
                    alert("删除成功！");
                    obj.parents("tr").remove();
                    window.location.href = "productinfolist";
                } else if (data.productDeleteResult === "deleteFailure") {
                    alert("对不起，删除失败");
                } else if (data.productDeleteResult === "notExist") {
                    alert("对不起，产品不存在");
                }
            },
            error:function (data) {
                alert("删除失败！" + data);
            }
        })
    }
});

//修改产品信息
$('.modifyProduct').on("click", function () {
    let obj = $(this);
    window.location.href = "toproductmodify?product_id=" + obj.attr("data-modify");
});