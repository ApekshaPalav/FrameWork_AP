package com.learnAutomation.utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider
{
    XSSFWorkbook wb;
    public ExcelDataProvider() throws IOException
    {

        File src=new File("./TestData/Data.xlsx");
        FileInputStream fis=new FileInputStream(src);
        wb=new XSSFWorkbook(fis);

    }
    public String getStringData(int SheetIndex, int row, int cell)
    {
        return wb.getSheetAt(SheetIndex).getRow(row).getCell(cell).getStringCellValue();
    }
    public String getStringData(String Sheetname, int row, int cell)
    {
        return wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
    }
    public double getIntData(String Sheetname, int row, int cell)
    {
       return wb.getSheet(Sheetname).getRow(row).getCell(cell).getNumericCellValue();
    }
}
