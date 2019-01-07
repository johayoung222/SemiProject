package com.kh.schedule.model.vo;

import java.io.Serializable;

public class UploadedFile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int scheduleNo;
	private String OriginalFilename;
	private String RenameFilename;
	private String FileExtender;
	
	public UploadedFile() {}

	public UploadedFile(int scheduleNo, String originalFilename, String renameFilename, String fileExtender) {
		super();
		this.scheduleNo = scheduleNo;
		OriginalFilename = originalFilename;
		RenameFilename = renameFilename;
		FileExtender = fileExtender;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public String getOriginalFilename() {
		return OriginalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		OriginalFilename = originalFilename;
	}

	public String getRenameFilename() {
		return RenameFilename;
	}

	public void setRenameFilename(String renameFilename) {
		RenameFilename = renameFilename;
	}

	public String getFileExtender() {
		return FileExtender;
	}

	public void setFileExtender(String fileExtender) {
		FileExtender = fileExtender;
	}

	@Override
	public String toString() {
		return scheduleNo + ", " + OriginalFilename + ", "
				+ RenameFilename + ", " + FileExtender;
	}
	
	
	
	
}
