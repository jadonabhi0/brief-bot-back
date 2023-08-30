package com.abhi.briefbot.preprocessing;

/**
 * The DataCleaning class provides methods for cleaning and preprocessing data.
 *
 * Usage:
 * - Use this class to apply common data cleaning tasks such as removing
 *   duplicates, handling missing values, and formatting data.
 * - Integrate this class into your data processing pipeline to ensure data
 *   is cleaned and ready for subsequent operations.
 *
 * Example:
 * ```
 * DataCleaning dataCleaning = new DataCleaning();
 * String cleanedData = dataCleaning.clean(rawData);
 * // Proceed with analysis or processing using the cleanedData
 * ```
 */

/**
 * 
 @author Abhishek jadon
 @Date 25-Aug-2023
 @Time 11:01:10 pm
 @Year 2023
 */
public class DataCleaning {
	
	
	

    /**
     * Removes duplicate values, special characters and muntiple spaces from the provided data.
     *
     * @param data The string of data containing potential duplicates.
     * @return A new string with duplicate values removed.
     */
	
	public String cleanData(String data) {
		
        String cleaned = data.replaceAll("[^\\w\\s@'$]+", "")
                .replaceAll("\\s+", " ")
                .replaceAll(":", "")
                .trim();
		
     
		
		return cleaned;
	}
	
	

}
