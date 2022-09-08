package util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    public String getExcelData(String sheetname, int rowNum, int cellNum) {
        String retValue = null;
        try {
            FileInputStream file = new FileInputStream("D:\\Framework\\UI_v1\\data\\UI_DataBuilder.xlsx");
            Workbook wb = WorkbookFactory.create(file);
            Sheet sheet = wb.getSheet(sheetname);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);
            if(cell.getCellType().equals(CellType.STRING)) {
                retValue=cell.getStringCellValue();
            }
            else if(cell.getCellType().equals(CellType.NUMERIC)) {
                retValue= String.valueOf(cell.getNumericCellValue());
            }
            else if(cell.getCellType().equals(CellType.BLANK)) {
                retValue=String.valueOf(cell.getStringCellValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return retValue;
    }

    public static int getRowNum(String sheetname) {
        int rowCount=0;
        try {
            FileInputStream file = new FileInputStream("D:\\Framework\\UI_v1\\data\\UI_DataBuilder.xlsx");
            Workbook wb= WorkbookFactory.create(file);
            Sheet sheet = wb.getSheet(sheetname);
            rowCount=sheet.getLastRowNum();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rowCount;
    }
}
