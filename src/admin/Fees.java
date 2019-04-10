package admin;

public class Fees {
	int feesid;
	int studentid;
	String date;
	String typeofpayment;
	int amount;
	int standard;
	public int getFeesid() {
		return feesid;
	}
	public void setFeesid(int feesid) {
		this.feesid = feesid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTypeofpayment() {
		return typeofpayment;
	}
	public void setTypeofpayment(String typeofpayment) {
		this.typeofpayment = typeofpayment;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
}
