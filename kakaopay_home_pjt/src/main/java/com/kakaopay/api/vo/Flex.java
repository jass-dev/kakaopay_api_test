package com.kakaopay.api.vo;

public class Flex {
	private String token;
	private long requestUserId;
	private String roomId;
	private long shareCounts;
	private long totalAmount;
	private String createDate;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public long getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(long requestUserId) {
		this.requestUserId = requestUserId;
	}
	public long getShareCounts() {
		return shareCounts;
	}
	public void setShareCounts(long shareCounts) {
		this.shareCounts = shareCounts;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Flex [token=" + token + ", roomId=" + roomId + ", requestUserId=" + requestUserId + ", shareCounts="
				+ shareCounts + ", totalAmount=" + totalAmount + ", createDate=" + createDate + "]";
	}
	
	
	

}
