package executor;

import java.lang.reflect.Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import businesscomponents.Adactin;

public class Executor extends Adactin { 
	public static void main(String[] args) throws Exception {
		Adactin.invokeApp();
		Adactin.loginADC();
		Adactin.verifyHomepage();
		Adactin.dropDown();
		Adactin.checkInDate();
		Adactin.checkOutDate();
		Adactin.clickSubmit();
		Adactin.radioButton();
		Adactin.continueButton();
		Adactin.bookHotel();
		Adactin.creditCard();
		Adactin.bookNow();
		
//        // Path to Excel file
        String filePath = "C:\\Users\\cutem\\Downloads\\SeptemberProject2025\\SeptemberProject2025\\src\\test\\resources\\DataType\\Adacitin.xlsx";
//
//        // Open Excel
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheet("TestCases");
//
//        // Create object of your class containing methods
//        Adactin actions = new Adactin();
//
//        // Loop through rows
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            Row row = sheet.getRow(i);
//            if (row != null) {
//                Cell cell = row.getCell(0);
//                if (cell != null) {
//                    String methodName = cell.getStringCellValue().trim();
//                    System.out.println("🔹 Executing Method: " + methodName);
//
//                    try {
//                        // Use Reflection to get and invoke method
//                        Method method = actions.getClass().getMethod(methodName);
//                        method.invoke(actions);
//                    } catch (NoSuchMethodException e) {
//                        System.out.println("❌ Method not found: " + methodName);
//                    }
//                }
//            }
//        }
//
//        workbook.close();
//        fis.close();
//    }

	}
}
