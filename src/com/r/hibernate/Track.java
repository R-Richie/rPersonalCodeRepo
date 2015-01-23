package com.r.hibernate;

import java.io.Serializable;
import java.util.Date;

public class Track implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5781004668000107522L;

	private int id;
	private String title;
	private String filePath;
	private Date playTime;
	private Date added;
	private short volume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public short getVolume() {
		return volume;
	}

	public void setVolume(short volume) {
		this.volume = volume;
	}

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Track(String title, String filePath, short volume) {
		super();
		this.title = title;
		this.filePath = filePath;
		this.volume = volume;
	}

	public Track(String title, String filePath, Date playTime, Date added,
			short volume) {
		super();
		this.title = title;
		this.filePath = filePath;
		this.playTime = playTime;
		this.added = added;
		this.volume = volume;
	}

}
