package utils;

import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import reuseable.BaseClass;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel extends BaseClass {

    public static String readExcelData(String sheetName,int row, int column){

        String value = null;

        try {
            String path = System.getProperty("user.dir");

            File file = new File(path + "//src//main//resources//dataSheet//Test_Data.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            value = sheet.getRow(row).getCell(column).getStringCellValue();

        }catch (FileNotFoundException e){

            throw new RuntimeException();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return value;
    }


}
