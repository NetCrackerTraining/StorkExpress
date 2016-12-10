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

    public static void main(String[] args) throws IOException {
        Reports reports = new Reports();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

//        System.out.println(writeBestUsers(reports.bestUsers(),sheet));
        System.out.println(writeYearReport(reports.yearReport(),sheet));
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("new.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean writeBestUsers(String[][] result, HSSFSheet sheet){
        for (int i = 0; i < 21; i++) {
            Row row = sheet.createRow(i);
            for (int j=0; j < 2; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(result[j][i]);
            }
        }
        return true;
    }

    public static boolean writeYearReport(String[][] result, HSSFSheet sheet) {
        for (int i = 0; i < 13; i++) {
            Row row = sheet.createRow(i);
            for (int j=0; j < 3; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(result[j][i]);
            }
        }
        return true;
    }

}
