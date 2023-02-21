package excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public Map<String, String> getRowDataByID(String fileName, String sheetName, String tc_id) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/test_data/" + fileName + ".xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        int lastColNum = sheet.getRow(1).getLastCellNum();
        int lastRowNum = sheet.getLastRowNum();

        Map<String, String> data = new HashMap<>();

        for (int i = 0; i <= lastRowNum; i++){
            if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(tc_id)){
                for(int j = 0; j < lastColNum; j++){
                    String key = sheet.getRow(1).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    data.put(key, value);
                }
            }
        }

        return data;
    }
}
