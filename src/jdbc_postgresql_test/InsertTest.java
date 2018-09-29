package jdbc_postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

		public static void main(String[] arg) {

			try {
				//JDBCドライバの登録
				Class.forName("org.postgresql.Driver");
				// URL、ユーザ名、パスワードの設定
				String url = "jdbc:postgresql:sample";
				String user = "student";
				String pass = "himitu";
				// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// SQL 文の作成
				String sql=

					"INSERT INTO emp(code,name,age,tel)VALUES(6,'広瀬',33,'090-1212-3333')";

				//PreparedStatementの取得
				PreparedStatement st = con.prepareStatement(sql);
				//SQLの実行
				int rows = st.executeUpdate();
				System.out.println(rows + "件、データベースに追加しました。");
				//リソースの解放
				st.close();
				con.close();

			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}
