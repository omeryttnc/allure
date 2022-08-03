package utilities;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtil {
    static DataFormatter df = new DataFormatter();
    public static String TESTDATA_SHEET_PATH ="src/main/java/urbanicfarm_testdata/urbanicfarm_testdata.xlsx";
    //book
    public static Workbook book;
    //sheet
    public static Sheet sheet;
    //create method
    public static Object[][] getTestData(String sheetName){
        try {
            FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);
            Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for(int i=0; i<sheet.getLastRowNum(); i++){
                for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
                    data[i][k] = sheet.getRow(i+1).getCell(k).toString();
                }
            }
            return data;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * test datanizin icinde en az 1 adet numerik deger varsa ve string olarak
     * kullanilacaksa bu method kullnailmali
     * excelden gelen numerik degerler text formatinda dahi olsa ondalik deger olarak geliyor (0.0 gibi)
     * bunu dataformatter class ile bu sekilde cozduk
     * (Dataformatter class levelda static olrak tanimlandi line12)
     * line 51 deki kod excelden gelen numarayi string formatina ceviriyor
     * @param sheetName
     * @return
     */
    public static Object[][] getNumericDataAsString(String sheetName){
        try {
            FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);
            Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for(int i=0; i<sheet.getLastRowNum(); i++){
                for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
                    String value = df.formatCellValue(sheet.getRow(i+1).getCell(k));
                    data[i][k] = value;
                }
            }
            return data;
        } catch (Exception e) {
        }
        return null;
    }
}