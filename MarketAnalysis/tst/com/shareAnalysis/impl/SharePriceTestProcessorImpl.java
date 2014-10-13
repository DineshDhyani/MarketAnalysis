package com.shareAnalysis.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.shareAnalysis.CompanyDetail;

public class SharePriceTestProcessorImpl {

	@Test
	public void test() {
		SharePriceProcessorImpl testProcessorImpl = new SharePriceProcessorImpl();
		ArrayList<CompanyDetail> list = testProcessorImpl.process("resource/test_shares_data.csv");

		assertEquals(5, list.size());
		assertEquals("For Company-A  maximum share value was 1000.0 in Mar, 2000", list.get(0).toString());
		assertEquals("For Company-B  maximum share value was 986.0 in Mar, 2007", list.get(1).toString());
		assertEquals("For Company-C  maximum share value was 995.0 in Jun, 1993", list.get(2).toString());
		assertEquals("For Company-D  maximum share value was 999.0 in Apr, 2002", list.get(3).toString());
		assertEquals("For Company-E  maximum share value was 997.0 in Oct, 2008", list.get(4).toString());

	}

}
