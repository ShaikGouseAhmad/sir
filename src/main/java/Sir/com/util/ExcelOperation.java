package Sir.com.util;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation {
	Workbook w1;
	Sheet sheet;
	int row;
	public ExcelOperation(String excelpath) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		File srs=new File(excelpath);
		FileInputStream  fis=new FileInputStream(srs);
		w1 = WorkbookFactory.create(fis);
	}



	@SuppressWarnings({ "deprecation", "static-access" })
	public String readData(int Sheetname,int Row,int Cell) throws EncryptedDocumentException, InvalidFormatException, IOException
		{	
			  sheet = w1.getSheetAt(Sheetname);
					Cell cell = sheet.getRow(Row).getCell(Cell);
					String data = null;
					if(cell.getCellType()==cell.CELL_TYPE_STRING)
					{
						data = cell.getStringCellValue();
					}
					else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
					{
						data =String.valueOf(cell.getNumericCellValue());
					}
					else if (cell.getCellType()==cell.CELL_TYPE_BLANK)
					{
						data="";
					}
		return data;
			
		}
	  public int getRowCount(int sheetIndex)
	  {
      row= w1.getSheetAt(sheetIndex).getLastRowNum();
	row = row+1;
		return row;
		  
	  }
	  
	  
  }
