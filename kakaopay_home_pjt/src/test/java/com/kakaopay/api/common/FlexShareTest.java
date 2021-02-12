package com.kakaopay.api.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FlexShareTest {

	@Test
	void ShareDevideTest() {
		List<Long> list = FlexShare.flexShareDivide(2000000000, 20000);
		assertNotNull(list);
	}

}
