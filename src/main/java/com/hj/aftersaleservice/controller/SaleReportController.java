package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.SaleReport;
import com.hj.aftersaleservice.service.SaleService;
import com.hj.aftersaleservice.utils.Constants;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SaleReportController {
    @Resource
    private SaleService saleService;

    @RequestMapping(value = "/listsalereport")
    public String listAllSaleReport(@RequestParam(value = "saleReportWords", required = false) String saleReportWords,
                                    @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                                    Model model) {

        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<SaleReport> saleReportList = saleService.getAllSaleReportList(saleReportWords);
        PageInfo<SaleReport> saleReportPageInfo = new PageInfo<>(saleReportList);

        model.addAttribute("saleReportList", saleReportPageInfo);
        model.addAttribute("saleReportWords", saleReportWords);

        return "report/salereport";
    }

    @RequestMapping(value = "/salereportexcel")
    public void excel(@RequestParam(value = "saleReportExcel", required = false) String saleReportExcel,
                      HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<SaleReport> saleReports = saleService.getAllSaleReportExcel(saleReportExcel);

        //创建excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet("销售报表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);

        titleRow.createCell(0).setCellValue("客户");
        titleRow.createCell(1).setCellValue("电话");
        titleRow.createCell(2).setCellValue("小区");
        titleRow.createCell(3).setCellValue("产品");
        titleRow.createCell(4).setCellValue("规格型号");
        titleRow.createCell(5).setCellValue("数量");
        titleRow.createCell(6).setCellValue("单价");
        titleRow.createCell(7).setCellValue("小计");
        titleRow.createCell(8).setCellValue("销售类型");
        titleRow.createCell(9).setCellValue("销售员");
        titleRow.createCell(10).setCellValue("销售日期");

        //将数据放入excel表中
        for (SaleReport s : saleReports) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(s.getC());
            dataRow.createCell(1).setCellValue(s.getTel());
            dataRow.createCell(2).setCellValue(s.getArea());
            dataRow.createCell(3).setCellValue(s.getP_name());
            dataRow.createCell(4).setCellValue(s.getP_spec());
            dataRow.createCell(5).setCellValue(s.getAmount());
            dataRow.createCell(6).setCellValue(s.getPrice().toString());
            dataRow.createCell(7).setCellValue(s.getTotal().toString());
            dataRow.createCell(8).setCellValue(s.getS_type());
            dataRow.createCell(9).setCellValue(s.getS_person());
            dataRow.createCell(10).setCellValue(s.getS_date());
        }

        //设置下载时excel的名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String excelName = sdf.format(new Date());
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + excelName + ".xls");

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
