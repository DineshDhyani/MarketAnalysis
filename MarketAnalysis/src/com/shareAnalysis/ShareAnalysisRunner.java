package com.shareAnalysis;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.shareAnalysis.impl.SharePriceProcessorImpl;
import com.shareDelegate.SharePriceProcessor;

/**
 * @author Dinesh Dhyani
 * 
 */
public class ShareAnalysisRunner {
	final static Logger logger = Logger.getLogger(ShareAnalysisRunner.class);

	/**
	 * @param args name of the file
	 */
	public static void main(String[] args) {

		if (args.length != 1) {
			logger.error("Please provide Input File as input argument");
		} else {
			logger.info("Starting Processing file :" + args[0]);
			SharePriceProcessor sharePriceProcessor = new SharePriceProcessorImpl();
			ArrayList<CompanyDetail> companyList = sharePriceProcessor
					.process(args[0]);

			if (companyList != null)
				for (CompanyDetail companyDetail : companyList) {
					System.out.println(companyDetail.toString());
				}

			logger.info("Done Processing file :" + args[0]);
		}
	}

}