package com.shareAnalysis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ShareAnalysisTestRunner {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		ShareAnalysisRunner testRunner = new ShareAnalysisRunner();
		testRunner.main(null);
		fail("Not yet implemented");
	}

}
