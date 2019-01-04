package com.kh.schedule.model.vo;

import java.sql.Date;

public class Schedule {
	private int scheduleNo;
	private String scheduleTitle;
	private String scheduleContent;
	private String scheduleOriginalfilename;
	private String scheduleRenamefilename;
	private Date scheduleDate;
	private String scheduleDdaycheck;
	private String scheduleReqeatcheck;
	private int scheduleTimeline;
	private Date scheduleStartday;
	private Date scheduleEndday;
	private String memberId;
	
	public Schedule() {}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public String getScheduleOriginalfilename() {
		return scheduleOriginalfilename;
	}

	public void setScheduleOriginalfilename(String scheduleOriginalfilename) {
		this.scheduleOriginalfilename = scheduleOriginalfilename;
	}

	public String getScheduleRenamefilename() {
		return scheduleRenamefilename;
	}

	public void setScheduleRenamefilename(String scheduleRenamefilename) {
		this.scheduleRenamefilename = scheduleRenamefilename;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleDdaycheck() {
		return scheduleDdaycheck;
	}

	public void setScheduleDdaycheck(String scheduleDdaycheck) {
		this.scheduleDdaycheck = scheduleDdaycheck;
	}

	public String getScheduleReqeatcheck() {
		return scheduleReqeatcheck;
	}

	public void setScheduleReqeatcheck(String scheduleReqeatcheck) {
		this.scheduleReqeatcheck = scheduleReqeatcheck;
	}

	public int getScheduleTimeline() {
		return scheduleTimeline;
	}

	public void setScheduleTimeline(int scheduleTimeline) {
		this.scheduleTimeline = scheduleTimeline;
	}

	public Date getScheduleStartday() {
		return scheduleStartday;
	}

	public void setScheduleStartday(Date scheduleStartday) {
		this.scheduleStartday = scheduleStartday;
	}

	public Date getScheduleEndday() {
		return scheduleEndday;
	}

	public void setScheduleEndday(Date scheduleEndday) {
		this.scheduleEndday = scheduleEndday;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Schedule(int scheduleNo, String scheduleTitle, String scheduleContent, String scheduleOriginalfilename,
			String scheduleRenamefilename, Date scheduleDate, String scheduleDdaycheck, String scheduleReqeatcheck,
			int scheduleTimeline, Date scheduleStartday, Date scheduleEndday, String memberId) {
		super();
		this.scheduleNo = scheduleNo;
		this.scheduleTitle = scheduleTitle;
		this.scheduleContent = scheduleContent;
		this.scheduleOriginalfilename = scheduleOriginalfilename;
		this.scheduleRenamefilename = scheduleRenamefilename;
		this.scheduleDate = scheduleDate;
		this.scheduleDdaycheck = scheduleDdaycheck;
		this.scheduleReqeatcheck = scheduleReqeatcheck;
		this.scheduleTimeline = scheduleTimeline;
		this.scheduleStartday = scheduleStartday;
		this.scheduleEndday = scheduleEndday;
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return scheduleNo + ", " + scheduleTitle + ", "
				+ scheduleContent + ", " + scheduleOriginalfilename
				+ ", " + scheduleRenamefilename + ", " + scheduleDate
				+ ", " + scheduleDdaycheck + ", " + scheduleReqeatcheck
				+ ", " + scheduleTimeline + ", " + scheduleStartday
				+ ", " + scheduleEndday + ", " + memberId;
	}
	
	
	
}
