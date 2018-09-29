package jdbc_postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest2 {

	public static void main(String[] args) {
		// 社員テーブルに任意の社員を追加するプログラム

			Connection con = null;
			PreparedStatement st = null;

		if (args.length!=4) {
			System.out.println("社員番号、名前、年齢、Tel を入力してください。");
			System.exit(1);
		}

		try {

			//入力データの取得
			int code = Integer.parseInt(args[0]);
			String name = args[1];
			int age = Integer.parseInt(args[2]);
			String tel = args[3];

			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL,ユーザー名,パスワードの設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			//データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
			//SQL文の作成
			String sql = "INSERT INTO emp VALUES(?,?,?,?)";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//プレースホルダの穴埋め
			st.setInt(1, code);
			st.setString(2, name);
			st.setInt(3, age);
			st.setString(4, tel);
			//SQLの実行
			int rows = st.executeUpdate();
			System.out.println(rows + "件、追加しました");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
