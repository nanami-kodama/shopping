package bean;

public class Sales {

	//売上番号
	private int salesId;
	
	//売上日付
	private String salesDate;
	
	//商品のISBN
	private String isbn;
	
	//発送状況
	private String shippingStatus;
	
	//入金状況
	private String paymentStatus;
	
	
	//売上情報の初期設定
	public Sales() {
		this.salesId = 0;
		this.salesDate = "null";
		this.isbn = null;
		this.shippingStatus = null;
		this.paymentStatus = null;
	}
	
	
	//売上番号の取得と設定
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	
	
	//売上日付の取得と設定
	public String getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(String salesId) {
		this.salesDate = salesDate;
	}
	
	
	//商品ISBNの取得と設定
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	//発送状況の取得と設定
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippinStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	
	
	//入金状況の取得と設定
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}