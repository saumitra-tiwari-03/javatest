package test;

import java.io.BufferedReader;
import java.io.FileReader;


public class ToCharAttach {
	
	private static final String FILENAME = "D:\\tocharInput.txt";

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			
			String s = "LONE STAR                       TX75668       USA";
			System.out.println(s.replaceAll("\\s+"," "));
			String currentLine,str;
			while((currentLine = br.readLine()) != null){
				if(currentLine.contains("replace")){
					str = currentLine;
					System.out.println(str.trim());
					System.out.println(str.indexOf(")"));
					
					int i = str.indexOf(")");
					String str2 = str.replace("s", "StringUtils.toChar(s, 4)");
					System.out.println(str2.trim());
				}
			}
			
		}catch(Exception e){
			
		}

	}

}
