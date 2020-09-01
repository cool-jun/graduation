// 动态获取产品名称列表
$('#counterpart').change(function () {
    $.ajax({
        type:"GET",
        url:"getproductnamelist",
        dataType:"json",
        success:function (data) {
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                $(option).val(data[i].product_name);
                $(option).text(data[i].product_name);
                $('#product_name').append(option);
            }
        },
        error:function (data) {
            alert("加载产品名称列表失败！" + data);
        }
    })
});

// 根据产品名称动态获取规格/型号列表
$('#product_name').change(function () {
    let product_name = $('#product_name').val();
    let product_spec = $('#product_spec');
    $.ajax({
        type:"GET",
        url:"getproductspeclist",
        data:{
            product_name:product_name
        },
        dataType:"json",
        success:function (data) {
            product_spec.html();
            let options = "<option value=''>--请选择--</option>";
            for (let i = 0; i < data.length; i++) {
                options += "<option value='"+data[i].product_spec+"'>"+data[i].product_spec+"</option>";
            }
            product_spec.html(options);
        },
        error:function (data) {
            alert("加载规格/型号列表失败！" + data);
        }
    })
});

// 根据产品名称动态获得价格
$('#product_spec').change(function () {
    let product_name = $('#product_name').val();
    let product_spec = $('#product_spec').val();
    $.ajax({
        type:"GET",
        url:"getpricebyproduct",
        data:{
            product_name:product_name,
            product_spec:product_spec
        },
        dataType:"json",
        success:function (data) {
            document.getElementById("unit_price").value = data;
        },
        error:function (data) {
            alert("获取价格失败！" + data);
        }
    })
});

// 动态生成金额
$('#amount').change(function () {
    let amount = $('#amount').val();
    let unit_price = $('#unit_price').val();
    document.getElementById("cargo_value").value = amount * unit_price;
});