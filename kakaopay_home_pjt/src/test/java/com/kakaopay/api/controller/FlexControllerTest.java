package com.kakaopay.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.kakaopay.api.common.KPConstants;
import com.kakaopay.api.common.Response;
import com.kakaopay.api.vo.Flex;
import com.kakaopay.api.vo.FlexDateAmount;
import com.kakaopay.api.vo.FlexDetail;


@SpringBootTest
class FlexControllerTest {

	@Autowired
	FlexController flexController;

	@Test
	void search_flex_test() throws Exception {
		Flex flex = new Flex();
		flex.setToken("aaa");
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.addHeader(KPConstants.REQUEST_HEADER_USER, 1);
		req.addHeader(KPConstants.REQUEST_HEADER_ROOM, "r1");
		ResponseEntity respEntity = flexController.searchFlex(req, flex);
		Response resp = (Response) respEntity.getBody();
		HashMap<String, Object> map = (HashMap<String, Object>) resp.getData();
		FlexDateAmount flexData = (FlexDateAmount) map.get(KPConstants.FLEX_C);
		assertEquals(respEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(flexData.getTotalAmount(), 100);
	}

	@Test
	void do_flex_test() throws Exception {
		Flex flex = new Flex();
		flex.setTotalAmount(100);
		flex.setShareCounts(7);
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.addHeader(KPConstants.REQUEST_HEADER_USER, 1);
		req.addHeader(KPConstants.REQUEST_HEADER_ROOM, "r1");

		ResponseEntity respEntity = flexController.doFlex(req, flex);
		Response resp = (Response) respEntity.getBody();
		HashMap<String, Object> map = (HashMap<String, Object>) resp.getData();
		String token = (String) map.get(KPConstants.TOKEN_C);
		assertEquals(respEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(token.length(), 3);
	}

	@Test
	void claim_flex_test() throws Exception {
		FlexDetail flexDetail = new FlexDetail();
		flexDetail.setToken("aaa");
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.addHeader(KPConstants.REQUEST_HEADER_USER, 4);
		req.addHeader(KPConstants.REQUEST_HEADER_ROOM, "r1");
		
		ResponseEntity respEntity = flexController.claimFlex(req, flexDetail);
		Response resp = (Response) respEntity.getBody();
		HashMap<String, Object> map = (HashMap<String, Object>) resp.getData();
		long amount = (long) map.get(KPConstants.AMOUNT_C);
		assertEquals(respEntity.getStatusCode(), HttpStatus.OK);
	}
}
