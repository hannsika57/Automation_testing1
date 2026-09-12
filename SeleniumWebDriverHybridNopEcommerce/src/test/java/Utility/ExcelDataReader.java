package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

    XSSFWorkbook wb;
    DataFormatter formatter;

    public ExcelDataReader() {

        File src = new File(
                "./TestData/TestData2.xlsx"
        );

        try {

            FileInputStream fis = new FileInputStream(src);

            wb = new XSSFWorkbook(fis);

            formatter = new DataFormatter();

            fis.close();

        } catch (Exception e) {

            System.out.println(
                    "Unable to load Excel file: "
                    + e.getMessage()
            );
        }
    }

    public String getStringData(
            int sheetIndex,
            int row,
            int column) {

        return formatter.formatCellValue(
                wb.getSheetAt(sheetIndex)
                        .getRow(row)
                        .getCell(column)
        );
    }

    public String getStringData(
            String sheetName,
            int row,
            int column) {

        return formatter.formatCellValue(
                wb.getSheet(sheetName)
                        .getRow(row)
                        .getCell(column)
        );
    }

    public String getNumericData(
            String sheetName,
            int row,
            int column) {

        return formatter.formatCellValue(
                wb.getSheet(sheetName)
                        .getRow(row)
                        .getCell(column)
        );
    }
}