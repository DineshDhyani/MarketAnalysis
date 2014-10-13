package com.shareAnalysis;

/**
 * POJO for company detail
 * @author Dinesh Dhyani
 *
 */
public class CompanyDetail {

	private String companyName;
	private String year;
	private String month;
	private Double shareWorth;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Double getShareWorth() {
		return shareWorth;
	}
	public void setShareWorth(Double shareWorth) {
		this.shareWorth = shareWorth;
	}
	
	
	@Override
	public String toString() {
		return "For " + companyName +  "  maximum share value was " + shareWorth + " in " + month
				+ ", " + year ;
	}
	
	
}