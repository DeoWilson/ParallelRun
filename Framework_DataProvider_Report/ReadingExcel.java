package Framework_DataProvider_Report;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingExcel {
    
	
	public static String[][] ReadExcelData() throws IOException {
	String fileLocation = "./Excel Files/Excel Practise.xlsx";
	XSSFWorkbook wb = new XSSFWorkbook(fileLocation);
	XSSFSheet ws = wb.getSheetAt(0);
	int Rownumber = ws.getLastRowNum();
	int Colnumber = ws.getRow(0).getLastCellNum();
	
	String data[][] = new String[Rownumber][Colnumber];
	
	for(int i=1; i<=Rownumber; i++) {
		for (int j=0; j <Colnumber; j++) {
			XSSFRow wr = ws.getRow(i);
			XSSFCell wc = wr.getCell(j);
			DataFormatter dft = new DataFormatter();
			data[i-1][j] = dft.formatCellValue(wc);
			System.out.println(data[i-1][j]);
		}
	}
	
	wb.close();
	return data;
	}
}
