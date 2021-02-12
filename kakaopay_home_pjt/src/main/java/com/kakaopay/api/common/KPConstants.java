package com.kakaopay.api.common;

public class KPConstants {

	public static final String REQUEST_HEADER_USER = "X-USER-ID";
	public static final String REQUEST_HEADER_ROOM = "X-ROOM-ID";
	
	public final static int TOKEN_LENGTH = 3;
	
	public static final String FAIL = "FAIL";
	public static final String SUCCEES = "SUCCESS";
	public static final String OK = "OK";
	
	public static final String Y = "Y";
	public static final String N = "N";
	
	public static final String EX_UNEXPECTED_FAIL_MSG = "에러가 발생했습니다.";
	public static final String EX_FLEX_FIND_TOKEN_FAIL_MSG = "해당 TOKEN으로 조회가능한 뿌리기가 없습니다.";
	public static final String EX_FLEX_FIND_USER_FAIL_MSG = "자신이 뿌리지 않은 건은 조회할 수 없습니다.";
	public static final String EX_FLEX_FIND_DATE_FAIL_MSG = "뿌리기 시점으로부터 7일이 넘어 조회가 불가능합니다.";
	public static final String EX_FLEX_CREATE_SMALL_COUNTS_FAIL_MSG = "1명 이하의 인원으로 뿌리기를 실행할 수 없습니다.";
	public static final String EX_FLEX_CREATE_FAIL_MSG = "뿌리기가 실행되지 않았습니다.";
	public static final String EX_FLEX_CLAIM_FAIL_MSG = "뿌리기를 받을 수 없습니다.";
	
	public static final String ERR_00_1 = "ERR_00_1";
	public static final String ERR_01_1 = "ERR_01_1";
	public static final String ERR_01_2 = "ERR_01_2";
	public static final String ERR_01_3 = "ERR_01_3";
	public static final String ERR_02_1 = "ERR_02_1";
	public static final String ERR_02_2 = "ERR_02_2";
	public static final String ERR_03_1 = "ERR_03_1";
	
	public static final String AMOUNT_C = "amount";
	public static final String FLEX_C = "flex";
	public static final String FLEX_DETAIL_C = "flexDetail";
	public static final String TOKEN_C = "token";
	
	public static final String TOKEN_U = "TOKEN";
	
}
