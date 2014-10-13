package com.shareDelegate;

import java.util.ArrayList;

import com.shareAnalysis.CompanyDetail;



/**
 * interface to be overridden to process 
 * shares and find month year of each 
 * company with maximum share value
 * 
 * @param filename
 * 
 */
public interface SharePriceProcessor{
	public  ArrayList<CompanyDetail> process(String fileName);
}
