package com.mudassirshahzad.retail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mudassirshahzad.services.MessageBuilder;

import org.junit.jupiter.api.Test;

public class TestMessageBuilder {

	@Test
	public void testNameMkyong() {

		MessageBuilder obj = new MessageBuilder();
		assertEquals("Hello mudassir", obj.getMessage("mudassir"));

	}

}