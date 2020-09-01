$('#sale_report').on("click", function () {
    let saleReportExcel = $('#saleExcel').val();
    window.location.href = "salereportexcel?saleReportExcel=" + saleReportExcel;
});