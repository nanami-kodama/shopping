package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MailsDAO {
	
	//DB接続用の情報をフィールドに定数として定義
	
	//JDBCドライバ内部のDriverクラスパス
    private static final String RDB_DRIVE = "org.mariadb.jdbc.Driver";
    
    //接続するMySQLデータベースパス
    private static final String URL = "jdbc:mariadb://localhost/mybookdb";
    
    //データベースのユーザー名
	private static final String USER = "root";
	
	//データベースのパスワード
	private static final String PASSWD = "root123";

	/*
	 *フィールド変数の情報を基に、DB接続を行うメソッド
	 * 
	 *@return データベース接続情報
	 *@throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	

}
