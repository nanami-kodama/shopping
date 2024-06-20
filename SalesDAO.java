package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalesDAO{

	//JDBCドライバ内部のDriverクラスパス
	private static final String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	// 接続するMySQLデータベースパス
	private static final String URL = "jdbc:mariadb://localhost/mybookdb";
	// データベースのユーザー名
	private static final String USER = "root";
	// データベースのパスワード
	private static final String PASSWD = "root123";

	
	// フィールド変数の情報を基に、DB接続をおこなうメソッド
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
	
	
	//全売上情報のリスト
	public ArrayList<bean.Sales> selectAll(){
		Connection con = null;
		Statement smt = null;
		ArrayList<bean.Sales>salesList = new ArrayList<bean.Sales>();
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			String sql = "SELECT * FROM salesinfo ORDER BY salesId";
			ResultSet rs = smt.executeQuery(sql);
			
			while(rs.next()) {
				bean.Sales sales = new bean.Sales();
				sales.setSalesId(rs.getInt("salesId"));
				sales.setSalesDate(rs.getString("salesDate"));
				sales.setIsbn(rs.getString("isbn"));
				sales.setShippinStatus(rs.getString("shippingStatus"));
				sales.setPaymentStatus(rs.getString("paymentStatus"));
				salesList.add(sales);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return salesList;
	}
	
	//売上情報をsalesinfoテーブルへ格納する
	public void insert(bean.Sales sales) {
		String sql = "INSERT INTO salesinfo VALUES('" + sales.getSalesId() + "','" + sales.getSalesDate() +"','" + sales.getIsbn() + "','" + sales.getShippingStatus() + "',"
				+ sales.getPaymentStatus() + ")";
		Connection con = null;
		Statement smt = null;
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			smt.executeUpdate(sql);
		
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}
	
	//絞り込み検索処理
	public ArrayList<bean.Sales> search(int salesId,  String salesDate, String isbn, String shippingStatus, String paymentStatus){
		Connection con = null;
		Statement smt = null;
		ArrayList<bean.Sales> salesList = new ArrayList<bean.Sales>();
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			String sql = "SELECT * FROM salesinfo WHERE salesId LIKE '%" + salesId
					+ "%' AND salesDate LIKE '%" + salesDate + "%' AND isbn LIKE '%" + isbn + "%' AND shippingStatus LIKE '%"
					+ shippingStatus + "%'AND paymentStatus LIKE '%" + paymentStatus + "%";
			
			ResultSet rs = smt.executeQuery(sql);
			
			while(rs.next()) {
				bean.Sales sales = new bean.Sales();
				sales.setSalesId(rs.getInt(salesId));
				sales.setSalesDate(rs.getString("salesDate"));
				sales.setIsbn(rs.getString("isbn"));
				sales.setShippinStatus(rs.getString("shippingStatus"));
				sales.setPaymentStatus(rs.getString("paymentStatus"));
				salesList.add(sales);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return salesList;
	}

}
	
	
