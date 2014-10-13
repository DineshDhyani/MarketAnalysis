/**
 * 
 */
package com.shareAnalysis.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.shareAnalysis.CompanyDetail;
import com.shareDelegate.*;
import com.dataAccessLayer.*;
import com.exception.CsvFileException;
import com.exception.FileProcessorException;

/**
 * @author Dinesh Dhyani
 * 
 */
public class SharePriceProcessorImpl  implements SharePriceProcessor{
	final static Logger logger = Logger.getLogger(SharePriceProcessorImpl.class);
	
	/* (non-Javadoc)
	 * @see com.shareDelegate.SharePriceProcessor#process(java.lang.String)
	 */
	@Override
    public ArrayList<CompanyDetail> process(String fileName) {

		CsvAccessDAO csvAccessDao= new CsvAccessDAO();
		ArrayList<CompanyDetail> companyList = null;
		try {
			companyList = csvAccessDao.processCSV(fileName);
		} catch (CsvFileException e) {
			logger.error("Caught CsvFileException while processing the file: " + fileName);
		} catch (FileProcessorException e) {
			logger.error("Caught FileProcessorException while processing the file: " + fileName);
		}
		
		return companyList;

	}

	
	}
	
	


