package utils;

import crud.Reports;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.*;

/**
 * Created by Андрей on 09.12.2016.
 */
public class CreateFileReport {

    public HSSFWorkbook WriteFileReport(String[][] result){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet");

        for (int i = 0; i < result[0].length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < result.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(result[j][i]);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("Report.xls"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
}
