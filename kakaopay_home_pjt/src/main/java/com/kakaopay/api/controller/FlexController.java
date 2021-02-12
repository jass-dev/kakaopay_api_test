package com.kakaopay.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.api.common.KPConstants;
import com.kakaopay.api.common.Response;
import com.kakaopay.api.service.FlexService;
import com.kakaopay.api.vo.Flex;
import com.kakaopay.api.vo.FlexDetail;

@RestController
public class FlexController {
	@Autowired
	FlexService flexService;

	@GetMapping(path = "/searchFlex")
	public ResponseEntity<Response> searchFlex(HttpServletRequest req, Flex flex) throws Exception {
		Map<String, Object> respMap = new HashMap<>();
		flex.setRequestUserId(Long.parseLong(req.getHeader(KPConstants.REQUEST_HEADER_USER)));
		flex.setRoomId(req.getHeader(KPConstants.REQUEST_HEADER_ROOM));
		respMap.put(KPConstants.FLEX_C, flexService.searchFlex(flex));
		respMap.put(KPConstants.FLEX_DETAIL_C, flexService.searchFlexDetail(flex));
		return new ResponseEntity<Response>(new Response(respMap), HttpStatus.OK);
	}

	@PostMapping(path = "/doFlex")
	public ResponseEntity<Response> doFlex(HttpServletRequest req, @RequestBody Flex flex) throws Exception {
		flex.setRequestUserId(Long.parseLong(req.getHeader(KPConstants.REQUEST_HEADER_USER)));
		flex.setRoomId(req.getHeader(KPConstants.REQUEST_HEADER_ROOM));
		Map<String, Object> respMap = new HashMap<>();
		respMap.put(KPConstants.TOKEN_C, flexService.insertFlex(flex));
		return new ResponseEntity<Response>(new Response(respMap), HttpStatus.OK);
	}

	@PostMapping(path = "/claimFlex")
	public ResponseEntity<Response> claimFlex(HttpServletRequest req, @RequestBody FlexDetail flexDetail) throws Exception {
		flexDetail.setClaimUserId(Long.parseLong(req.getHeader(KPConstants.REQUEST_HEADER_USER)));
		flexDetail.setRoomId(req.getHeader(KPConstants.REQUEST_HEADER_ROOM));
		Map<String, Object> respMap = new HashMap<>();
		respMap.put(KPConstants.AMOUNT_C, flexService.updateFlexDetail(flexDetail));
		return new ResponseEntity<Response>(new Response(respMap), HttpStatus.OK);
	}
}
