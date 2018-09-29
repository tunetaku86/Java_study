package jdbc_postgresql_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {

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
			String sql = "SELECT * FROM emp";
			//PreparedStatementの取得
			PreparedStatement st = con.prepareStatement(sql);
			//SQL文の実行
			ResultSet rs = st.executeQuery();
			//結果の取得及び表示
			while (rs.next()) {
				System.out.print(rs.getInt("code") + " : ");
				System.out.print(rs.getString("name") + " : ");
				System.out.print(rs.getInt("age") + " : ");
				System.out.println(rs.getString("tel"));
				}
			//リソースの解放
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
