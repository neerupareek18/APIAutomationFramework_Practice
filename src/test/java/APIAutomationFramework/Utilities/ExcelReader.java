package APIAutomationFramework.Utilities;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    String filename;
    Workbook book;
    Sheet sheet;

    public Object[][] getCellValue(String sheetName) throws IOException {
filename= "src/test/java/APIAutomationFramework/Resourses/TokenDataSheet.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filename);

        book = WorkbookFactory.create(fileInputStream);
        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0; i<sheet.getLastRowNum();i++){

            for(int j=0; j<sheet.getRow(0).getLastCellNum();j++){

                data[i][j]= sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return getCellValue("Sheet1");
    }
}
