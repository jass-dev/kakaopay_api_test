package com.kakaopay.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kakaopay.api.common.KPConstants;
import com.kakaopay.api.exceptions.GeneralException;
import com.kakaopay.api.vo.Flex;
import com.kakaopay.api.vo.FlexDateAmount;
import com.kakaopay.api.vo.FlexDetail;

@SpringBootTest
class FlexServicetest {

	@Autowired
	private FlexService flexService;

	// INSERT FLEX TEST
	@Test
	void insert_flex_normal_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setRoomId("rno1");
		flex.setRequestUserId(1);
		flex.setShareCounts(8);
		flex.setTotalAmount(2300);
		
		String newToken = flexService.insertFlex(flex);
		assertNotNull(newToken);
		assertEquals(newToken.length(), 3);

	}

	@Test
	void insert_flex_share_zero_people_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setRoomId("rno1");
		flex.setRequestUserId(1);
		flex.setShareCounts(0);
		flex.setTotalAmount(2300);
		
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.insertFlex(flex));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_CREATE_SMALL_COUNTS_FAIL_MSG);
	}
	
	@Test
	void insert_flex_detail_normal_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setToken("X0Z");
		flex.setRoomId("rno1");
		flex.setRequestUserId(1);
		flex.setShareCounts(10);
		flex.setTotalAmount(2300);

		int returnRows = flexService.insertFlexDetail(flex);
		assertEquals(returnRows, 10);
	}

	// SEARCH FLEX TEST

	@Test
	void search_flex_normal_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setToken("aaa");
		flex.setRoomId("r1");
		flex.setRequestUserId(1);
		FlexDateAmount flexData = flexService.searchFlex(flex);
		assertNotNull(flexData);
		assertEquals(flexData.getTotalAmount(), 100);// pre-inserted sample data
	}

	@Test
	void search_flex_not_mine_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setToken("aaa");
		flex.setRoomId("r1");
		flex.setRequestUserId(2);
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.searchFlex(flex));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_FIND_USER_FAIL_MSG);
	}

	@Test
	void search_flex_invalid_token_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setToken("+++");//'+' not used as token charset
		flex.setRoomId("r1");
		flex.setRequestUserId(1);
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.searchFlex(flex));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_FIND_TOKEN_FAIL_MSG);
	}
	
	@Test
	void search_flex_too_old_test() throws GeneralException {
		Flex flex = new Flex();
		flex.setToken("bbb");
		flex.setRoomId("r1");
		flex.setRequestUserId(1);
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.searchFlex(flex));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_FIND_DATE_FAIL_MSG);
	}

	
	// UPDATE FLEX TEST
	
	@Test
	void update_flex_detail_normal_test() throws GeneralException {
		FlexDetail flexDetail = new FlexDetail();		
		flexDetail.setClaimUserId(6);
		flexDetail.setRoomId("r1");
		flexDetail.setToken("aaa");
		
		long claimedAmount = flexService.updateFlexDetail(flexDetail);
		assertNotNull(claimedAmount);
	}
	
	@Test
	void update_flex_detail_claim_self_test() throws GeneralException {
		FlexDetail flexDetail = new FlexDetail();		
		flexDetail.setClaimUserId(1); // pre-inserted : 1 is request user
		flexDetail.setRoomId("r1");
		flexDetail.setToken("aaa");
		
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.updateFlexDetail(flexDetail));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_CLAIM_FAIL_MSG);
		
	}
	
	void update_flex_detail_claim_too_old_test() throws GeneralException {
		FlexDetail flexDetail = new FlexDetail();		
		flexDetail.setClaimUserId(2); 
		flexDetail.setRoomId("r1");
		flexDetail.setToken("bbb");
		// pre-inserted : 'bbb' data claim date is sysdate - 10 day
		
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.updateFlexDetail(flexDetail));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_CLAIM_FAIL_MSG);
	}
	
	void update_flex_detail_claim_again_test() throws GeneralException {
		FlexDetail flexDetail = new FlexDetail();		
		flexDetail.setClaimUserId(3); // pre-inserted : 3 already claimed for aaa token
		flexDetail.setRoomId("r1");
		flexDetail.setToken("aaa");
		
		
		GeneralException thrown = assertThrows(GeneralException.class, () -> flexService.updateFlexDetail(flexDetail));
		assertEquals(thrown.getMessage(), KPConstants.EX_FLEX_CLAIM_FAIL_MSG);
	}
}
