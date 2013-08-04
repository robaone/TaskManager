package com.robaone.taskmanager.impl;

import java.util.Date;

import com.robaone.taskmanager.project.ProjectNote;

public class ProjectNoteImpl implements ProjectNote {
	private Date time;
	private String note;
	private double hours;
	private int id;
	@Override
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public void setHours(double hours) {
		this.hours = hours;
	}

	public Date getTime(){
		return time;
	}
	
	public String getNote(){
		return note;
	}
	
	public double getHours(){
		return hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
