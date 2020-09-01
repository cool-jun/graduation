//分页
function page_nav(frm, num) {
    frm.pageNum.value = num;
    frm.submit();
}

//表格内容居中显示
$('th,td').addClass("text-center");