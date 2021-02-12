package com.kakaopay.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopay.api.common.KPConstants;
import com.kakaopay.api.common.FlexShare;
import com.kakaopay.api.common.TokenGenerater;
import com.kakaopay.api.dao.FlexDao;
import com.kakaopay.api.exceptions.GeneralException;
import com.kakaopay.api.vo.Flex;
import com.kakaopay.api.vo.FlexDateAmount;
import com.kakaopay.api.vo.FlexDateAmountWithFlag;
import com.kakaopay.api.vo.FlexDetail;
import com.kakaopay.api.vo.FlexDetailUserAmount;

@Service
@Transactional(rollbackFor = GeneralException.class)
public class FlexService {
	@Autowired
	FlexDao flexDao;

	public FlexService() {
		super();
	}

	public FlexDateAmount searchFlex(Flex flex) throws GeneralException  {
		FlexDateAmountWithFlag flexData = flexDao.selectFlex(flex);
		if (flexData == null ) {
			throw new GeneralException(KPConstants.ERR_01_1, KPConstants.EX_FLEX_FIND_TOKEN_FAIL_MSG);
		} else if (flexData.getRequestUserFlag().equals(KPConstants.N)) {
			throw new GeneralException(KPConstants.ERR_01_2, KPConstants.EX_FLEX_FIND_USER_FAIL_MSG);
		} else if (flexData.getCreateDateFlag().equals(KPConstants.N)) {
			throw new GeneralException(KPConstants.ERR_01_3, KPConstants.EX_FLEX_FIND_DATE_FAIL_MSG);
		}

		return new FlexDateAmount(flexData.getCreateDate(), flexData.getTotalClaimedAmount(), flexData.getTotalAmount());
	}

	public List<FlexDetailUserAmount> searchFlexDetail(Flex flex) {
		return flexDao.selectFlexDetail(flex);
	}

	@Transactional(rollbackFor = GeneralException.class, propagation = Propagation.REQUIRED)
	public String insertFlex(Flex flex) throws GeneralException {
		if (flex.getShareCounts() < 1) {
			throw new GeneralException(KPConstants.ERR_02_1, KPConstants.EX_FLEX_CREATE_SMALL_COUNTS_FAIL_MSG);
		}
		flex.setToken(TokenGenerater.generateToken());

		int returnRows = 0;
		try {
			returnRows = flexDao.insertFlex(flex);
			insertFlexDetail(flex);
		} catch (Exception e) {
			throw new GeneralException(KPConstants.ERR_00_1, KPConstants.EX_UNEXPECTED_FAIL_MSG);
		}
		if (returnRows == 0) {
			throw new GeneralException(KPConstants.ERR_02_2, KPConstants.EX_FLEX_CREATE_FAIL_MSG);
		}

		return flex.getToken();
	}

	@Transactional(rollbackFor = GeneralException.class, propagation = Propagation.REQUIRED)
	public int insertFlexDetail(Flex flex) throws GeneralException {
		List<Long> shareAmounts = FlexShare.flexShareDivide(flex.getTotalAmount(), flex.getShareCounts());
		int returnRows = 0;
		List<FlexDetail> flexDetailList = new ArrayList<FlexDetail>();
		try {
			for (int i = 0; i < shareAmounts.size(); i++) {
				FlexDetail flexDetail = new FlexDetail();
				flexDetail.setClaimId(i);
				flexDetail.setClaimUserId(-1);
				flexDetail.setClaimAmount(shareAmounts.get(i));
				flexDetail.setRequstUserId(flex.getRequestUserId());
				flexDetail.setRoomId(flex.getRoomId());
				flexDetail.setIsClaimed(KPConstants.N);
				flexDetail.setToken(flex.getToken());
				flexDetailList.add(flexDetail);
			}
			returnRows += flexDao.insertFlexDetail(flexDetailList);
		} catch (Exception e) {
			throw new GeneralException(KPConstants.ERR_00_1, KPConstants.EX_UNEXPECTED_FAIL_MSG);
		}
		return returnRows;
	}

	public long updateFlexDetail(FlexDetail flexDetail) throws GeneralException {
		int returnRows = 0;
		try {
			returnRows = flexDao.updateFlexDetail(flexDetail);
		} catch (Exception e) {
			throw new GeneralException(KPConstants.ERR_00_1, KPConstants.EX_UNEXPECTED_FAIL_MSG);
		}
		if (returnRows == 0) {
			throw new GeneralException(KPConstants.ERR_03_1, KPConstants.EX_FLEX_CLAIM_FAIL_MSG);
		}
		return flexDetail.getClaimAmount();
	}
}
