package com.robaone.taskmanager.impl;

import com.robaone.taskmanager.Storage;
import com.robaone.taskmanager.project.Project;
import com.robaone.taskmanager.project.ProjectNote;
import com.robaone.taskmanager.project.Task;

public class TaskImpl implements Task {
	private Storage source;
	private Project project;
	private double estimatedHours;
	private int id;
	private String name;
	public TaskImpl(Storage source){
		this.setStorage(source);
	}
	@Override
	public void setProject(Project p) {
		this.project = p;
	}

	@Override
	public Project getProject() {
		return this.project;
	}

	@Override
	public double getRemainingHours() throws Exception {
		double estimatedHours = this.getEstimatedHours();
		double usedHours = this.getTotalHours();
		return Math.abs(estimatedHours - usedHours);
	}

	@Override
	public void delete() throws Exception {
		this.getStorage().delete(this);
	}

	@Override
	public void cancel() throws Exception {
		this.getStorage().cancel(this);
	}

	@Override
	public void complete() throws Exception {
		this.getStorage().complete(this);
	}

	@Override
	public void setStatus(String status) throws Exception {
		this.getStorage().setStatus(this,status);
	}

	@Override
	public void setEstimatedHours(double hours) throws Exception {
		this.estimatedHours = hours;
		this.getStorage().save(this);
	}

	@Override
	public void addProjectNote(ProjectNote note) throws Exception {
		this.getStorage().addTaskNode(this,note);
	}

	@Override
	public double getEstimatedHours() {
		return this.estimatedHours;
	}

	@Override
	public ProjectNote[] getNotes() throws Exception {
		return this.getStorage().getTaskNotes(this);
	}

	@Override
	public int getTaskid() {
		return this.id;
	}

	@Override
	public double getTotalHours() throws Exception {
		return this.getStorage().getTaskHoursSpent(this);
	}
	public Storage getStorage() {
		return source;
	}
	public void setStorage(Storage source) {
		this.source = source;
	}
	@Override
	public void setName(String name) throws Exception {
		this.name = name;
		this.getStorage().save(this);
	}
	@Override
	public String getName(){
		return this.name;
	}

}
