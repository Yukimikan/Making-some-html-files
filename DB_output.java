package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_output {

	final static String CST_SELECT="1";
	final static String CST_INSERT="2";
	final static String CST_DELETE="3";
	final static String CST_UPDATE="4";

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try {

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			String password = "";
			String table_name = "members";
			String SQL_FLG=CST_SELECT;

			//パスワードを入力
			System.out.println("パスワード入力してください");
			password = br.readLine();

			if (table_name.equals("members")){

				// 先程インストールしたMySQLのドライバを指定
				Class.forName("com.mysql.jdbc.Driver");

				// MySQLデータベースに接続 (DB名,ID,パスワードを指定)
				Connection conn =
						DriverManager.getConnection("jdbc:mysql://localhost/test?"+
								"user=root&password=" + password);
				// ステートメントを作成
				Statement stmt = conn.createStatement();

				if (SQL_FLG.equals(CST_INSERT)) {
					//				// INSERT
					//				stmt.executeUpdate("INSERT INTO users (id, email) VALUES (1001,'someone01@example.com')");
					//				stmt.executeUpdate("INSERT INTO users (id, email) VALUES (1002,'someone02@example.com')");
				}else if (SQL_FLG.equals(CST_DELETE)) {
					// DELETE
					stmt.executeUpdate("DELETE FROM" + table_name + "where first_name='first_name'");
				}else if (SQL_FLG.equals(CST_UPDATE)) {
					// UPDATE
					//				stmt.executeUpdate("UPDATE users SET email='updated@example.com' where id=1002");
				}else if (SQL_FLG.equals(CST_SELECT)) {
					// SELECT
					ResultSet rset;
					String sql_str;

					sql_str = "SELECT * FROM " + table_name;
					rset = stmt.executeQuery(sql_str);

					while ( rset.next() ) {
						System.out.println(
								rset.getString(1) + "\t" +
										rset.getString(2) + "\t" +
										rset.getString(3) + "\t" +
										rset.getString(4) + "\t" +
										rset.getInt(5) + "\t" +
										rset.getString(6) + "\t" +
										rset.getString(7) + "\t" +
										rset.getString(8) ); // ()内は列番号です
					}
					// 結果セットをクローズ
					rset.close();
				}else {
					;
				}
				//	 ステートメントをクローズ
				stmt.close();
				// 接続をクローズ
				conn.close();
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
