package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ShortLongNamesConverter {

	private static final String FILENAME = "D:\\test.txt";

	private static final String EXCEL_FILE_NAME = "D:\\LongNameReferences.xlsx";

	public static void main(String[] args) {

		ShortLongNamesConverter t = new ShortLongNamesConverter();

		List<String> shortNameList = new ArrayList<String>();
		List<String> longNameList = new ArrayList<String>();
		List<String> prefixList = new ArrayList<String>();
		List<String> suffixList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine + " value ");
				shortNameList.add(t.searchShortNameInString(sCurrentLine));
				prefixList.add(t.prefix(sCurrentLine));
			}
			Iterator<String> itr = shortNameList.iterator();
			while (itr.hasNext()) {
				String next = itr.next();
				longNameList.add(t.searchLongNameInExcel(next));
			}
			Iterator<String> itrLongName = longNameList.iterator();
			while(itrLongName.hasNext()){
				String next = itrLongName.next();
				suffixList.add(t.getMethodCreator(next, "systemDistrictParameterFileSyscnsdpList"));
			}
			//prefixList.addAll(suffixList);
			int l = prefixList.size();
			/*ArrayList<String> newList = new ArrayList<String>(l); 
			for (int i = 0; i < l; i++) { 
				newList.add(prefixList.get(i) + "" + suffixList.get(i)); 
			}*/
			/*Iterator<String> stmtItr = newList.iterator();
			while(stmtItr.hasNext()){
				System.out.println(stmtItr.next());
			}*/
			ArrayList<String> serviceList = new ArrayList<String>();
			for(int j=0;j<l;j++){
				serviceList.add("dto.set"+shortNameList.get(j)+"(service.get"+longNameList.get(j)+"());");
				System.out.println("dto.set"+shortNameList.get(j)+"(systemCompanyParameterFileSyscnscpList.read().get"+longNameList.get(j)+"());");
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String searchShortNameInString(String str) {
		int l = str.length();
		StringBuffer sb = new StringBuffer();
		char[] strtoChar = str.toCharArray();
		for (int i = 0; i < l; i++) {
			if (strtoChar[i] == 'g' && strtoChar[i + 1] == 'e' && strtoChar[i + 2] == 't') {
				for (int j = i + 3; j < l; j++) {
					if (strtoChar[j] == '(') {
						break;
					}
					sb.append(strtoChar[j]);
				}
				System.out.println("");
			}
		}
		return sb.toString();
	}
	
	public String searchLongNameInExcel(String str) {

		Workbook workbook;
		String longName = null;

		try {
			FileInputStream excelFile = new FileInputStream(new File(EXCEL_FILE_NAME));
			workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();

					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						if (currentCell.getStringCellValue().equals(str.toUpperCase())) {
							longName = currentRow.getCell(3).toString();
						}
					} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						System.out.println("Numeric Cell found, please remove all numeric cell from fill. Thanks !!");
					}
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return longName;
	}
	
	public String getMethodCreator(String longName, String ListService){
		StringBuffer sb = new StringBuffer();
		return sb.append("("+ListService+".read().get"+longName+"());").toString();
	}
	
	public String prefix(String str){
		char[] strarr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<strarr.length;i++){
			if(strarr[i] == '('){
				break;
			}
			sb.append(strarr[i]);
		}
		return sb.toString();
	}

}
