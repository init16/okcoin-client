package org.oxerr.okcoin.rest.dto;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Test for parsing the result of /api/trades.do or /api/cancelorder.do.
 */
public class TradesTest extends UnmarshalTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException {
		Trade[] trades = readValue("trades.json", Trade[].class);
		assertEquals(4, trades.length);

		assertEquals(1367130137000L, trades[0].getDate().toEpochMilli());
		assertEquals(new BigDecimal("787.71"), trades[0].getPrice());
		assertEquals(new BigDecimal("0.003"), trades[0].getAmount());
		assertEquals(230433, trades[0].getTid());
		assertEquals(Type.SELL, trades[0].getType());

		assertEquals(1367130137000L, trades[1].getDate().toEpochMilli());
		assertEquals(new BigDecimal("787.65"), trades[1].getPrice());
		assertEquals(new BigDecimal("0.001"), trades[1].getAmount());
		assertEquals(230434, trades[1].getTid());
		assertEquals(Type.SELL, trades[1].getType());

		assertEquals(1367130137000L, trades[2].getDate().toEpochMilli());
		assertEquals(new BigDecimal("787.5"), trades[2].getPrice());
		assertEquals(new BigDecimal("0.091"), trades[2].getAmount());
		assertEquals(230435, trades[2].getTid());
		assertEquals(Type.SELL, trades[2].getType());

		assertEquals(1367131526000L, trades[3].getDate().toEpochMilli());
		assertEquals(new BigDecimal("787.27"), trades[3].getPrice());
		assertEquals(new BigDecimal("0.03"), trades[3].getAmount());
		assertEquals(230512, trades[3].getTid());
		assertEquals(Type.BUY, trades[3].getType());
	}

}
