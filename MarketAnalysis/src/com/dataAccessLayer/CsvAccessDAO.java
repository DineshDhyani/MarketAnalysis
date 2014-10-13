package com.dataAccessLayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.exception.CsvFileException;
import com.exception.FileProcessorException;
import com.shareAnalysis.CompanyDetail;

public class CsvAccessDAO {
	final static Logger logger = Logger.getLogger(CsvAccessDAO.class);
	ArrayList<CompanyDetail> companyList = null;

	/**
	 * processes the CSV file to find 
	 * the year and month with maximum 
	 * share price
	 * 
	 * @param fileName
	 * @return ArrayList<CompanyDetail>
	 * @throws CsvFileException 
	 * @throws FileProcessorException 
	 */
	public ArrayList<CompanyDetail> processCSV(String fileName) throws CsvFileException, FileProcessorException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					fileName)));
			String firstLine = null;
			int numberOfParams;
			
			if (null != (firstLine = br.readLine())) {
				numberOfParams = initializeCompanyList(firstLine);
			} else {
				String errorMsg = "Blank CSV file";
				logger.error(errorMsg);
				throw new CsvFileException(errorMsg);
			}
			
			while (null != (firstLine = br.readLine())) {
				String[] attr = firstLine.split(",");
				
				//compare if a row has all the fields
				if(attr.length != numberOfParams) {
					String errorMsg = "Wrong formatted CSV file";
					logger.error(errorMsg);
					throw new CsvFileException(errorMsg);
				}
				
				int count = 2;
				for (CompanyDetail companyDetail : companyList) {
					if (null == companyDetail.getShareWorth()) {
						companyDetail.setYear(attr[0]);
						companyDetail.setMonth(attr[1]);
						companyDetail.setShareWorth(Double
								.parseDouble(attr[count]));
					} else {
						Double currentShare = companyDetail.getShareWorth();
						if (currentShare < Double.parseDouble(attr[count])) {
							companyDetail.setYear(attr[0]);
							companyDetail.setMonth(attr[1]);
							companyDetail.setShareWorth(Double
									.parseDouble(attr[count]));
						}
					}
					count++;
				}
			}
			br.close();
			logger.info("CSV file processing completed.");
		}  catch (NumberFormatException e) {
			String errorMsg = "One of the share value is not in correct Number Format- This will lead to Invalid Output";
			logger.error(errorMsg);
			throw new CsvFileException(errorMsg);
		}  catch (FileNotFoundException e) {
			String errorMsg = "Cannot locate given File";
			logger.error(errorMsg);
			throw new FileProcessorException(errorMsg,e);
		} catch (IOException e) {
			String errorMsg = "Error occured while processing file: " + fileName;
			logger.error(errorMsg);
			throw new FileProcessorException(errorMsg,e);			
		}
		return companyList;
	}

	/**
	 * initializes a list of CompanyDetails
	 * with name of the company only
	 * 
	 * @param firstLine of the file
	 * @return int to determine number of companies
	 */
	private int initializeCompanyList(String firstLine) {

		if (null == companyList) {
			companyList = new ArrayList<CompanyDetail>();
		}

		String[] attributes = firstLine.split(",");

		//start loop from third attribute as first and second
		//attribute contains the string "year" and "month"
		for (int i = 2; i < attributes.length; i++) {
			CompanyDetail detail = new CompanyDetail();
			detail.setCompanyName(attributes[i]);
			companyList.add(detail);
		}
		
		return attributes.length;
	}

}