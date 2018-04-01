import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLmaker implements HTML {

	public HTMLmaker(){};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static void makeHTML(File out_file,ArrayList<Member> members){

		String textstream;
		String table_content;
		ArrayList<String> text_line = new ArrayList<String>();
		textstream = "";
		table_content="";

		try{

			FileWriter fr = new FileWriter(out_file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fr);

			textstream = textstream + tagStart(tag_HTML)+ "\n";
			textstream = textstream + tagStart(tag_HEAD)+ "\n";
			textstream = textstream + tagEnd(tag_HEAD)+ "\n";
			textstream = textstream + tagStart(tag_BODY)+ "\n";
			textstream = textstream + tagStart(tag_TABLE)+ "\n";

			for (Member m :members){
				//メンバー情報のセット
				Object[] elm = new Object [Member.item_num];
				elm[0] = m.getFirst_name() + " " + m.getLast_name();
				elm[1] = m.getSex_flg();
				elm[2] = m.getAge();
				elm[3] = m.getAddress();

				for(int i = 0 ; i < elm.length ; i++){
					table_content = table_content + tagStart(tag_TR);
					table_content = table_content + tagStart(tag_TD);
					table_content = table_content + elm[i];
					table_content = table_content + tagEnd(tag_TD) + "\n";
					table_content = table_content + tagStart(tag_TR) + "\n";
				}
			}

			textstream = textstream + table_content;
			textstream = textstream + tagEnd(tag_TABLE)+ "\n";
			textstream = textstream + tagEnd(tag_TABLE)+ "\n";
			textstream = textstream + tagEnd(tag_HTML)+ "\n";

			bw.write(textstream);

			bw.close();
			fr.close();

		}catch(IOException e){
			System.out.println(e);
		}

	}

	public static String tagStart(String tagname){
		tagname = "<" + tagname + ">";
		return tagname;
	}

	public static String tagEnd(String tagname){
		tagname = "<" + tagname + ">";
		return tagname;
	}

}
