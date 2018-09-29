package jdbc_postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest3 {

	public static void main(String[] args) {
		//社員名の「あいまい検索」

		if (args.length!=1) {
			System.out.println("名前の一部を入力してください");
			System.exit(1);

		}

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
				String sql = "SELECT * FROM emp WHERE name LIKE ?";
			//PreparedStatementの取得
				st = con.prepareStatement(sql);
			//プレースホルダーの穴埋め
				String part = "%" + args[0] + "%";
				st.setString(1, part);
			//SQLの実行
				ResultSet rs = st.executeQuery();
			//結果の取得および表示
				while (rs.next()) {
					System.out.print(rs.getInt("code") + ":");
					System.out.print(rs.getString("name") + ":");
					System.out.print(rs.getInt("age") + ":");
					System.out.println(rs.getString("tel"));
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//リソースの解放
				if (con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (st!=null) {
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
