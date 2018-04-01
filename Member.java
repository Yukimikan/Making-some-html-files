
public class Member {

	final static int item_num = 4;
	
	private String first_name;
	private String middle_name;
	private String last_name;
	private String sex_flg;
	private int age;
	private String company;
	private String career;
	private String address;
	
	public Member(){};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSex_flg() {
		return sex_flg;
	}

	public void setSex_flg(String sex_flg) {
		this.sex_flg = sex_flg;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static int getItemNum() {
		return item_num;
	}

}
