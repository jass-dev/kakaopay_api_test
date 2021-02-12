package com.kakaopay.api.vo;

public class FlexDetailUserAmount {
	private long claimUserId;
	private long claimAmount;

	public FlexDetailUserAmount() {
		super();
	}

	public FlexDetailUserAmount(long claimUserId, long claimAmount) {
		super();
		this.claimUserId = claimUserId;
		this.claimAmount = claimAmount;
	}

	public long getClaimUserId() {
		return claimUserId;
	}

	public void setClaimUserId(long claimUserId) {
		this.claimUserId = claimUserId;
	}

	public long getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(long claimAmount) {
		this.claimAmount = claimAmount;
	}

}
