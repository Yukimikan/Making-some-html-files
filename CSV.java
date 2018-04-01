import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {

	final static String BEFORE_CHAR = "\",\"";
	final static String AFTER_CHAR = "\"!\"";
	final static int CSV_HEADER_ROW = 1;

	public static void fileread(File in_file, ArrayList<Member> members)
			throws IOException{

		FileReader fr = new FileReader(in_file.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fr);

		String line = null;
		String temp = null;
		String temp_line[]= new String[Member.item_num];
		int cnt = 1;

		while((line=br.readLine())!=null){
			if (cnt > CSV_HEADER_ROW){

				//ãÊêÿÇËï∂éöïœä∑
				temp = line.replace(BEFORE_CHAR, AFTER_CHAR);
				temp_line = temp.split(AFTER_CHAR);
				Member_introduction.setMemberinfo(temp_line,members);
			}
			cnt++;
		}
		br.close();
		fr.close();
	}
}
