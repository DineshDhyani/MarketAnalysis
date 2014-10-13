package com.dataAccessLayer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.exception.CsvFileException;
import com.exception.FileProcessorException;

public class CsvTestAccessDAO {

	@Test
	public void testMissingField() {
		try {
			CsvAccessDAO testAccess = new CsvAccessDAO();
			testAccess.processCSV("resource/share_data_missingfield.csv");
			fail("should throw exception");
		} catch (CsvFileException e) {
			assertTrue(e.getMessage().equals("Wrong formatted CSV file"));
		} catch (FileProcessorException e) {
			fail("should not reach here");			
		}
	}

	@Test
	public void testWrongField() {
		try {
			CsvAccessDAO testAccess = new CsvAccessDAO();
			testAccess.processCSV("resource/share_data_stringfield.csv");
			fail("should throw exception");
		} catch (CsvFileException e) {
			assertTrue(e.getMessage().equals("One of the share value is not in correct " +
					"Number Format- This will lead to Invalid Output"));
		} catch (FileProcessorException e) {
			fail("should not reach here");
		}
	}

	@Test
	public void testBlankFile() {
		try {
			CsvAccessDAO testAccess = new CsvAccessDAO();
			testAccess.processCSV("resource/share_data_blankfile.csv");
			fail("should throw exception");
		} catch (CsvFileException e) {
			assertTrue(e.getMessage().equals("Blank CSV file"));
		} catch (FileProcessorException e) {
			fail("should not reach here");
		}
	}

	@Test
	public void testWrongFile() {
		try {
			CsvAccessDAO testAccess = new CsvAccessDAO();
			testAccess.processCSV("resource/share_data_fileDoesntExist.csv");
			fail("should throw exception");
		} catch (CsvFileException e) {
			fail("should not reach here");
		} catch (FileProcessorException e) {
			assertTrue(e.getMessage().equals("Cannot locate given File"));			
		}
	}

}
