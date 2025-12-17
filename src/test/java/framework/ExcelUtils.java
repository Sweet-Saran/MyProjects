package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Map<String, String> readHotelData(String filePath) throws IOException {
        Map<String, String> data = new LinkedHashMap<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter formatter = new DataFormatter(); // converts any cell type to string

        // 1. Get the starting row index.
        // If the sheet is completely empty, getFirstRowNum() returns 0.
        int firstRow = sheet.getFirstRowNum(); 
        
        // 2. Start the iteration from the row *after* the header row (firstRow + 1).
        // This is the key change to skip the header.
        for (int i = firstRow + 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            
            // Check to ensure the row is not null (e.g., if there are blank rows)
            if (row != null) { 
                Cell fieldCell = row.getCell(0); // Field Name column
                Cell valueCell = row.getCell(1); // Value column

                if (fieldCell != null && valueCell != null) {
                    String field = formatter.formatCellValue(fieldCell);
                    String value = formatter.formatCellValue(valueCell);
                    data.put(field, value);
                }
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
}