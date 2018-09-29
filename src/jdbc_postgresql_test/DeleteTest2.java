package jdbc_postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest2 {

	public static void main(String[] args) {
		//con.st定義
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
			String sql = "DELETE FROM emp WHERE code=1";
		//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
		//SQLの実行
			int rows = st.executeUpdate();
			System.out.println(rows + "件、レコードを削除しました");

		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//リソースの解放
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
