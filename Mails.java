/*
 *プログラム名：フリマシステム
 *プログラムの説明：
 *					
 *作成者：塩島はな
 *作成日：2024年6月20日
 */
package bean;

//DTO：データの入れ物としてのクラス(メールボックス情報)

public class Mails {
	
	//フィールド変数を定義
	
	private String user_id; 		//ユーザー名格納用変数
	
	private int sender;				//発送者かどうかの値格納用変数
	
	private String send_date;		//送信日時格納用変数
	
	private String received_date;	//受信日時格納用変数
	
	//初期設定
	
	public Mails() {
		this.user_id = null;
		this.sender = 0;
		this.send_date = null;
		this.received_date = null;
	}
	
	/*
	 *各フィールド変数のアクセサメソッドを定義
	 *
	 *Getメソッド
	 */
	public String getUser_id() {
		return user_id;
	}
		
	public int getSender() {
		return sender;
	}

	public String getSend_date() {
		return send_date;
	}
	
	public String getReeceived_date() {
		return received_date;
	
	}

	//Setメソッド
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public void setSender(int sender) {
		this.sender = sender;
	}
	
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	
	public void setReeceived_date(String received_date) {
		this.received_date = received_date;
	}

}
