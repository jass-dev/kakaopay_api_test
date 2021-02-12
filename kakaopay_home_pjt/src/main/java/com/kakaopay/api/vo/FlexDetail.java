package com.kakaopay.api.vo;

public class FlexDetail {
	private String token;
	private long claimId;
	private long claimUserId;
	private long claimAmount;
	private long requestUserId;
	private String roomId;
	private String isClaimed;
	private String claimDate;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
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

	public void setClaimAmount(long long1) {
		this.claimAmount = long1;
	}

	public String getIsClaimed() {
		return isClaimed;
	}

	public void setIsClaimed(String isClaimed) {
		this.isClaimed = isClaimed;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public long getRequstUserId() {
		return requestUserId;
	}

	public void setRequstUserId(long requstUserId) {
		this.requestUserId = requstUserId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "FlexDetail [token=" + token + ", claimId=" + claimId + ", claimUserId=" + claimUserId + ", claimAmount="
				+ claimAmount + ", requstUserId=" + requestUserId + ", roomId=" + roomId + ", isClaimed=" + isClaimed
				+ ", claimDate=" + claimDate + "]";
	}

}
