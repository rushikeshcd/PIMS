package com.springboot.model;

public class PaymentData {

	private String creditcardno;
	private Integer cvvcode;
	private String cardholdername;
	private String exirydate;

	public String getCreditcardno() {
		return creditcardno;
	}

	public void setCreditcardno(String creditcardno) {
		this.creditcardno = creditcardno;
	}

	public Integer getCvvcode() {
		return cvvcode;
	}

	public void setCvvcode(Integer cvvcode) {
		this.cvvcode = cvvcode;
	}

	public String getCardholdername() {
		return cardholdername;
	}

	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}

	public String getExirydate() {
		return exirydate;
	}

	public void setExirydate(String exirydate) {
		this.exirydate = exirydate;
	}

	@Override
	public String toString() {
		return "PaymentData{" + "creditcardno='" + creditcardno + '\'' + ", cvvcode=" + cvvcode + ", cardholdername='"
				+ cardholdername + '\'' + ", exirydate='" + exirydate + '\'' + '}';
	}
}
