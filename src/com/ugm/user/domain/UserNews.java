package com.ugm.user.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserNews implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int newsId;
	private String newsTitle;
	private String newsContent;
	private String newsWriter;
	private Timestamp newsDate;
	private Boolean newsIsdeleted;
	

	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsWriter() {
		return newsWriter;
	}
	public void setNewsWriter(String newsWriter) {
		this.newsWriter = newsWriter;
	}
	public Timestamp getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Timestamp newsDate) {
		this.newsDate = newsDate;
	}
	public Boolean getNewsIsdeleted() {
		return newsIsdeleted;
	}
	public void setNewsIsdeleted(Boolean newsIsdeleted) {
		this.newsIsdeleted = newsIsdeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserNews() {
		super();
	}		
}
