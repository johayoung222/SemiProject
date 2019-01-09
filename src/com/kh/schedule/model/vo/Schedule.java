package com.kh.schedule.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Schedule implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int scheduleNo;
	private String scheduleTitle;
	private String scheduleContent;
	private String scheduleOriginalfilename;
	private String scheduleRenamefilename;
	private Date scheduleDate;
	private String scheduleDdaycheck;
	private String scheduleRepeatcheck;
	private int scheduleTimeline;
	private Date scheduleStartday;
	private Date scheduleEndday;
	private String memberId;
	private Date scheduleDday;
	private String scheduleIcon;
	
	
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
		return scheduleRepeatcheck;
	}

	public void setScheduleRepeatcheck(String scheduleRepeatcheck) {
		this.scheduleRepeatcheck = scheduleRepeatcheck;
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

	public Date getScheduleDday() {
		return scheduleDday;
	}

	public void setScheduleDday(Date scheduleDday) {
		this.scheduleDday = scheduleDday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getScheduleRepeatcheck() {
		return scheduleRepeatcheck;
	}
	
	public String getScheduleIcon() {
		return scheduleIcon;
	}

	public void setScheduleIcon(String scheduleIcon) {
		this.scheduleIcon = scheduleIcon;
	}



	public Schedule(int scheduleNo, String scheduleTitle, String scheduleContent, String scheduleOriginalfilename,
			String scheduleRenamefilename, Date scheduleDate, String scheduleDdaycheck, String scheduleRepeatcheck,
			int scheduleTimeline, Date scheduleStartday, Date scheduleEndday, String memberId, Date scheduleDday,
			String scheduleIcon) {
		super();
		this.scheduleNo = scheduleNo;
		this.scheduleTitle = scheduleTitle;
		this.scheduleContent = scheduleContent;
		this.scheduleOriginalfilename = scheduleOriginalfilename;
		this.scheduleRenamefilename = scheduleRenamefilename;
		this.scheduleDate = scheduleDate;
		this.scheduleDdaycheck = scheduleDdaycheck;
		this.scheduleRepeatcheck = scheduleRepeatcheck;
		this.scheduleTimeline = scheduleTimeline;
		this.scheduleStartday = scheduleStartday;
		this.scheduleEndday = scheduleEndday;
		this.memberId = memberId;
		this.scheduleDday = scheduleDday;
		this.scheduleIcon = scheduleIcon;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", scheduleTitle=" + scheduleTitle + ", scheduleContent="
				+ scheduleContent + ", scheduleOriginalfilename=" + scheduleOriginalfilename
				+ ", scheduleRenamefilename=" + scheduleRenamefilename + ", scheduleDate=" + scheduleDate
				+ ", scheduleDdaycheck=" + scheduleDdaycheck + ", scheduleRepeatcheck=" + scheduleRepeatcheck
				+ ", scheduleTimeline=" + scheduleTimeline + ", scheduleStartday=" + scheduleStartday
				+ ", scheduleEndday=" + scheduleEndday + ", memberId=" + memberId + ", scheduleDday=" + scheduleDday
				+ ", scheduleIcon=" + scheduleIcon + "]";
	}
}
