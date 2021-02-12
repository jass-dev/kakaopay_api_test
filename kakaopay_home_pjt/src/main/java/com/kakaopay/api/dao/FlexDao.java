package com.kakaopay.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopay.api.vo.Flex;
import com.kakaopay.api.vo.FlexDateAmountWithFlag;
import com.kakaopay.api.vo.FlexDetail;
import com.kakaopay.api.vo.FlexDetailUserAmount;


@Transactional
@Repository(value = "FlexDao")
@Mapper
public interface FlexDao {

	FlexDateAmountWithFlag selectFlex(Flex flex);

	List<FlexDetailUserAmount> selectFlexDetail(Flex flex);

	int insertFlex(Flex flex);

	int insertFlexDetail(List<FlexDetail> flexDetailList);

	int updateFlexDetail(FlexDetail flexDetail);

}