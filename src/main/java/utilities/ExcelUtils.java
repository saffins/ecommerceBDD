package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    XSSFWorkbook workbook = null;
    FileInputStream fileInputStream = null;
    XSSFSheet sheet= null;
    XSSFRow row = null;
    XSSFCell cell = null;
    int colNum = 0;
    int rowCount = 0;

    List<String> columnData = new ArrayList<>();

    public ExcelUtils(String filePath){
        try{
            fileInputStream= new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String> readExcelData(String sheetName,String columnName){
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);
        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for(int j = 0; j<=rowCount; j++){
            row = sheet.getRow(j);
            for(int i =0;i<row.getLastCellNum();i++){
                if(row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
                    colNum = i;
                }
            }
            cell = row.getCell(colNum);
            String value = cell.getStringCellValue();
            columnData.add(value);
        }
        return columnData;
    }

}
