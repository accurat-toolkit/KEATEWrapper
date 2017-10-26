package com.shef.ac.uk.wrapper;

import com.shef.ac.uk.util.Util;


public class KEAWrapperTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		KEAWrapper wrapper = new KEAWrapper();
		
        String englishContent = Util.getFileContentAsBuffer("test.txt").toString();
        String taggedEnglishContent = wrapper.wrapTE(englishContent);
       // System.out.println(taggedEnglishContent);
        Util.doSave("test-out.xt", taggedEnglishContent);        		
        
	}

}
