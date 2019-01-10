package com.kh.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oFile) {
		File rFile = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		int rndNum = (int)(Math.random()*1000);
		
		String oFileName = oFile.getName();
		String ext = "";
		int dot = oFileName.lastIndexOf('.');
		if(dot > -1) {
			ext = oFileName.substring(dot);
		}
		
		String rFileName = sdf.format(new Date())+"_"+rndNum+ext;
		
		rFile = new File(oFile.getParent(), rFileName);
		
		try {
			rFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rFile;
	}

}






