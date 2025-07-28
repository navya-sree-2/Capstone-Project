package com.SnapDeals.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] readExcelData(String filePath, int sheetIndex) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount - 1][1];

        for (int i = 1; i < rowCount; i++) {
            Cell cell = sheet.getRow(i).getCell(0);
            cell.setCellType(CellType.STRING);
            data[i - 1][0] = cell.getStringCellValue();
        }

        workbook.close();
        return data;
    }
}
