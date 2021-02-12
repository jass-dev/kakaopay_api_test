package com.kakaopay.api.vo;

public class FlexDateAmountWithFlag extends FlexDateAmount{
	
	private String requestUserFlag;
	private String createDateFlag;

	public FlexDateAmountWithFlag() {
		super();
	}

	public FlexDateAmountWithFlag(String createDate, long totalClaimedAmount, long totalAmount, String requestUserFlag,
			String createDateFlag) {
		super(createDate, totalClaimedAmount, totalAmount);
		this.requestUserFlag = requestUserFlag;
		this.createDateFlag = createDateFlag;
	}

	public String getRequestUserFlag() {
		return requestUserFlag;
	}

	public void setRequestUserFlag(String requestUserFlag) {
		this.requestUserFlag = requestUserFlag;
	}

	public String getCreateDateFlag() {
		return createDateFlag;
	}

	public void setCreateDateFlag(String createDateFlag) {
		this.createDateFlag = createDateFlag;
	}
	
	
	
	
}
