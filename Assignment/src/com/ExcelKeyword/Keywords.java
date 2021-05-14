package com.ExcelKeyword;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class Keywords {
	private String inputFile;
	public String id;
	public String pwd;
	
    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String credentials[] =new String [5];
        int num=0;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 1; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    credentials[num]=cell.getContents();
                    num++;
                    

                }
            }
           id=credentials[0];
           pwd=credentials[1];
           System.out.println(id +" " +pwd);
            
        } catch (BiffException e) {
           System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
//       Keywords test = new Keywords();
//        test.setInputFile("E:/KeywordDrivenCheck.xls");
//        test.read();
    }
}
    