package com.progressive.htmlescape.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MyExcel {
    public static ByteArrayInputStream myExcel() {
        String[] columns = {"name", "address", "age"};
        try {
            Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Users");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);

            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < columns.length; i++){
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(cellStyle);
            }

            int rowId = 1;
            for (int i = 0; i < 5; i++){
                Row row = sheet.createRow(rowId++);
                row.createCell(0).setCellValue("Ram"+i);
                row.createCell(1).setCellValue("Ktm"+i);
                row.createCell(2).setCellValue(i+20);
            }

            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ByteArrayInputStream myExcel2() throws Exception{

        Map<String, String[]> data = new HashMap<>();
        data.put("Countries",new String[]{"Nepal"});
        data.put("province", new String[]{"Province1","Province2","Province3"});
        data.put("districts", new String[]{"Ktm","Argh","Rupandehi","Bhkatapur"});


        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("ListSheet");
        Row row;
        Name namedRange;
        String colLetter;
        String reference;
         int c = 0;
        int r = 0;
         for (String key : data.keySet()){
             System.out.println("key = "+key);

             row = sheet.getRow(r);
             if (row == null){
                 row = sheet.createRow(r++);
             }
             row.createCell(c).setCellValue(key);
             String[] values = data.get(key);
             for (String val : values){
                 row = sheet.getRow(r);
                 if (row == null){
                     row = sheet.createRow(r++);
                 }
                 row.createCell(c).setCellValue(val);
             }
             colLetter = CellReference.convertNumToColString(c);
             namedRange = workbook.createName();
             namedRange.setNameName(key);
             reference = "ListSheet!$" + colLetter + "$2:$" + colLetter + "$" + r;
             System.out.println(reference);
             namedRange.setRefersToFormula(reference);
             c++;
         }

        colLetter = CellReference.convertNumToColString((c-1));
        namedRange = workbook.createName();
        namedRange.setNameName("Categories");
        reference = "ListSheet!$A$1:$" + colLetter + "$1";
        namedRange.setRefersToFormula(reference);

        sheet.setSelected(false);

        Sheet sheet1 = workbook.createSheet("Sheet1");

        sheet1.createRow(0).createCell(0).setCellValue("Select Category");
        sheet1.getRow(0).createCell(1).setCellValue("Select item from that category");


        sheet1.autoSizeColumn(0);
        sheet1.autoSizeColumn(1);

        DataValidationHelper dvHelper = sheet1.getDataValidationHelper();
        DataValidationConstraint dvConstraint = dvHelper.createFormulaListConstraint("Categories");
        CellRangeAddressList addressList = new CellRangeAddressList(1, 1, 0, 0);
        DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);
        sheet1.addValidationData(validation);

        dvConstraint = dvHelper.createFormulaListConstraint("INDIRECT($A$2)");
        addressList = new CellRangeAddressList(1, 1, 1, 1);
        validation = dvHelper.createValidation(dvConstraint, addressList);
        sheet1.addValidationData(validation);

        workbook.setSheetHidden(0, true);
        workbook.setActiveSheet(1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);

        return new ByteArrayInputStream(out.toByteArray());
    }
}
