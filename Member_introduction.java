import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Member_introduction {

	final static String USERNAME = "";

	public static void main(String[] args){

		ArrayList<Member>members = new ArrayList<Member>();

		String ROOTPATH = "C:" + "/" + "Users" + "/" + "Desktop";
		String wk_folder_name = "member_data";
		String wk_folder_path = ROOTPATH + "/" + wk_folder_name;

		String in_folder_name = "in";
		String in_file_name = "input.csv";
		String in_folder_path = wk_folder_path +"/" + in_folder_name;
		String in_file_path= in_folder_path + "/" + in_file_name;

		String ot_folder_name = "out";
		String ot_file_name = "test.html";
		String ot_folder_path = wk_folder_path +"/" + ot_folder_name;
		String ot_file_path= ot_folder_path + "/" + ot_file_name;

		File f1 = new File(in_file_path);
		File f2 = new File(ot_file_path);

		if(f1.exists()){
			try{
				CSV.fileread(f1, members);
			}catch (IOException e){
				System.out.println("");
			}
		}

		if (f2.exists()){
			System.out.println("file_rewrite");
			HTMLmaker.makeHTML(f2, members);
		}else{

		}

		System.out.println("end");
	}

	public static void setMemberinfo(String temp_line[],ArrayList<Member> members){

		Member m=new Member();

		String full_name;
		String first_name;
		String last_name;
		String sex_info;
		String sex_flg;
		String address;
		int age;

		full_name = temp_line[1];
		address = temp_line[4];
		sex_info = temp_line[3];
		age = Integer.parseInt(temp_line[2]);

		first_name = getFirstname(full_name);
		last_name = getLastname(full_name);

		if (sex_info == "íj"){
			sex_flg = "1";
		}else if(sex_info =="èó"){
			sex_flg ="2";
		}else{
			sex_flg="0";
		}

		m.setFirst_name(first_name);
		m.setLast_name(last_name);
		m.setSex_flg(sex_flg);
		m.setAddress(address);
		m.setAge(age);

		members.add(m);
	}

	public static String getFirstname(String full_name){
		String first_name;
		first_name = full_name.substring(0, full_name.indexOf(" ")); 
		return first_name;
	}

	public static String getLastname(String full_name){
		String last_name;
		last_name = full_name.substring(full_name.indexOf(" ")+1,full_name.length()); 
		return last_name;
	}

}
