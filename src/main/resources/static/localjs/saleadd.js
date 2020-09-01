// 动态获取产品名称列表
$('#customer_name').change(function () {
    let product = $('#product_name');
    $.ajax({
        type:"GET",
        url:"getproductnamelist",
        dataType:"json",
        success:function (data) {
            product.html();
            let options = "<option value=''>--请选择--</option>";
            for (let i = 0; i < data.length; i++) {
                options += "<option value='"+data[i].product_name+"'>"+data[i].product_name+"</option>";
            }
            product.html(options);
        },
        error:function (data) {
            alert("加载产品列表失败！" + data);
        }
    })
});

// 根据产品名称动态获得规格/型号
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


// 根据产品动态获得价格
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
            document.getElementById("price").value = data;
        },
        error:function (data) {
            alert("获取价格失败！" + data);
        }
    })
});

// 动态生成金额
$('#number').change(function () {
    let number = $('#number').val();
    let price = $('#price').val();
    document.getElementById("money").value = number * price;
});