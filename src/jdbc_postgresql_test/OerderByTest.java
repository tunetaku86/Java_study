package jdbc_postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OerderByTest {

	public static void main(String[] args) {
	// 年齢の低い順に表示するプログラム

		//変数の定義
			Connection con = null;
			PreparedStatement st = null;
		try {
		//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		//URL,ユーザー名,パスワードの設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
		//データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		//SQL文の作成
			String sql = "SELECT * FROM emp ORDER BY age DESC;";
		//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
		//SQLの実行
			st.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//リソースの解放
			if(con!= null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (st!= null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			}
		}

	}

}
