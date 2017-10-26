package com.shef.ac.uk.wrapper;

import java.util.Vector;

import com.shef.ac.uk.util.TextProcessingUtilEnglish;
import com.shef.ac.uk.util.Util;


public class KEAWrapper {
	
	private TextProcessingUtilEnglish util = new TextProcessingUtilEnglish();
	
	public String wrapTE(String anEnglishText) throws Exception {
		Vector<String> tes = util.detectTE(anEnglishText);
		String text = " " + anEnglishText.trim();
		for (int i = 0; i < tes.size(); i++) {
			text = text.replaceAll(" " + tes.get(i) + " ", " <TENAME>" + tes.get(i)  + "</TENAME> ");
			text = text.replaceAll(" " + tes.get(i) + ",", " <TENAME>" + tes.get(i)  + "</TENAME>,");
			text = text.replaceAll(" " + tes.get(i) + "\\.", " <TENAME>" + tes.get(i)  + "</TENAME>,");
			text = text.replaceAll(" " + tes.get(i) + ";", " <TENAME>" + tes.get(i)  + "</TENAME>;");
			text = text.replaceAll(" " + tes.get(i) + "!", " <TENAME>" + tes.get(i)  + "</TENAME>!");
		}
		return text;

	}
	


	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		KEAWrapper wrapper = new KEAWrapper();
		
        String fileList = args[0].trim();
        Vector<String> lines = Util.getFileContentAsVector(fileList);
        
        for (int i = 0; i < lines.size(); i++) {
        	String values[] = lines.get(i).split("\t");
        	if (values.length == 2) {
                String englishContent = Util.getFileContentAsBuffer(values[0]).toString();
                String taggedEnglishContent = wrapper.wrapTE(englishContent);
                Util.doSave(values[1], taggedEnglishContent);        		
        	}
		}

	}

}
