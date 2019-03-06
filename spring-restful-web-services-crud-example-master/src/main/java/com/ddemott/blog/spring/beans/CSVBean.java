package com.ddemott.blog.spring.beans;

import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CSVBean {
	@CsvBindByPosition(position=0)
	private String bankingCIFID;
	@CsvBindByPosition(position=1)
	private String accountNumber;
	@CsvBindByPosition(position=2)
	private String last4digitsofdebitcard;
	@CsvBindByPosition(position=3)
	private String mobileNumber;
	@CsvBindByPosition(position=4)
	private String emailID;
	public String getBankingCIFID() {
		return bankingCIFID;
	}
	public void setBankingCIFID(String bankingCIFID) {
		this.bankingCIFID = bankingCIFID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getLast4digitsofdebitcard() {
		return last4digitsofdebitcard;
	}
	public void setLast4digitsofdebitcard(String last4digitsofdebitcard) {
		this.last4digitsofdebitcard = last4digitsofdebitcard;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
}
