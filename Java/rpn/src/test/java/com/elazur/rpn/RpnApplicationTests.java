package com.elazur.rpn;

import com.elazur.rpn.service.RpnService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class RpnApplicationTests {

	private RpnService rpnService;

	@BeforeEach
	void setUp() {
		rpnService = new RpnService();

	}

	@Test
	void contextLoads() {
		String errorMessage = "Expression invalide. Doit contenir au moins deux nombres et un opérateur, ou un nombre et un opérateur sqrt.";

		//test case 1: expressionToTransform is null
		//expected output: errorMessage
		assertEquals(errorMessage, rpnService.transformToRpn(null), "expressionToTransform is null");

		//test case 2: expressionToTransform is empty
		//expected output: errorMessage
		assertEquals(errorMessage, rpnService.transformToRpn(""), "expressionToTransform is empty");

		//test case 3: expressionToTransform contains only one number
		//expected output: errorMessage

		assertEquals(errorMessage, rpnService.transformToRpn("5"), "expressionToTransform contains only one number");

		//test case 4: expressionToTransform contains only one sqrt operator
		//expected output: errorMessage
		assertEquals(errorMessage, rpnService.transformToRpn("sqrt"), "expressionToTransform contains only one sqrt operator");

		//test case 5: expressionToTransform contains 4 sqrt
		//expected output: 2.0
		assertEquals("2.0", rpnService.transformToRpn("4 sqrt"), "expressionToTransform contains 4 sqrt");

		//test case 6: expressionToTransform contains one number and one operator
		//expected output: errorMessage
		assertEquals(errorMessage, rpnService.transformToRpn("5 +"), "expressionToTransform contains one number and one operator");

		//test case 7: expressionToTransform contains 5 2 +
		//expected output: result of the operation 7.0
		assertEquals("7.0", rpnService.transformToRpn("5 2 +"), "expressionToTransform contains 5 2 +");

		//test case 8: expressionToTransform contains 5 2 - 2 +
		//expected output: result of the operation -1
		assertEquals("5.0", rpnService.transformToRpn("5 2 - 2 +"), "expressionToTransform contains 2 numbers, one operator, one number and one operator");

		// test case 9: expressionToTransform contains 2 9 sqrt -,
		//expected output: result of the operation -1
		assertEquals("-1.0", rpnService.transformToRpn("2 9 sqrt -"), "expressionToTransform contains 2 9 sqrt -");
	}

	@Test
	void testTransformToRpnMockito(){

		RpnService mockService = mock(RpnService.class);

		// test case 7 with mock
		when(mockService.transformToRpn("5 2 +")).thenReturn("7.0");
		String result = mockService.transformToRpn("5 2 +");
		assertEquals("7.0", result);
		verify(mockService).transformToRpn("5 2 +");

		// test case 9 with mock
		when(mockService.transformToRpn("2 9 sqrt -")).thenReturn("-1.0");
		String result2 = mockService.transformToRpn("2 9 sqrt -");
		assertEquals("-1.0", result2);
	}
}
