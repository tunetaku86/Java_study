package jdbc_postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

	public static void main(String[] args) {

		try {
			//JDBCドライバの登録
				Class.forName("org.postgresql.Driver");
			//URL,ユーザー名,パスワードの設定
				String url = "jdbc:postgresql:sample";
				String user = "student";
				String pass = "himitu";
			//データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
			//SQL文の作成
				String sql = "DELETE FROM emp WHERE code = 1";
			//PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
			//SQLの実行
				int rows = st.executeUpdate();
				System.out.println(rows + "件、レコードを削除しました");
			//接続の解放
				st.close();
				con.close();
			//例外処理
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
