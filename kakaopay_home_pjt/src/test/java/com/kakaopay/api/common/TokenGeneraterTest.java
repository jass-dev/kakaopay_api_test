package com.kakaopay.api.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenGeneraterTest {

	@Test
	void getToken() {
		String token = TokenGenerater.generateToken();
		assertNotNull(token);
		assertEquals(token.length(), 3);
	}

}
