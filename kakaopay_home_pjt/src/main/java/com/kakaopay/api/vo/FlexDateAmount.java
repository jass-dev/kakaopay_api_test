package com.kakaopay.api.vo;

public class FlexDateAmount {
	private String createDate;
	private long totalClaimedAmount;
	private long totalAmount;
	
	public FlexDateAmount() {
		super();
	}

	public FlexDateAmount(String createDate, long totalClaimedAmount, long totalAmount) {
		super();
		this.createDate = createDate;
		this.totalClaimedAmount = totalClaimedAmount;
		this.totalAmount = totalAmount;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public long getTotalClaimedAmount() {
		return totalClaimedAmount;
	}

	public void setTotalClaimedAmount(long totalClaimedAmount) {
		this.totalClaimedAmount = totalClaimedAmount;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
