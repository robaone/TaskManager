package com.robaone.taskmanager.impl;

import com.robaone.taskmanager.Storage;
import com.robaone.taskmanager.project.Project;
import com.robaone.taskmanager.project.Task;

public class ProjectImpl implements Project {
	private Storage storage;
	private int projectid;
	public ProjectImpl(Storage s){
		this.setStorage(s);
	}
	@Override
	public void addTask(Task t) {
		this.getStorage().addTask(this,t);
	}

	@Override
	public Task[] getTasks() {
		Task[] tasks = this.getStorage().getTasks(this);
		return tasks;
	}

	@Override
	public Task getTask(int taskid) {
		Task task = this.getStorage().getTask(this,taskid);
		return task;
	}

	@Override
	public double getRemainingHours() throws Exception {
		Task[] tasks = this.getTasks();
		double totalHoursSpent = 0;
		for(Task task : tasks){
			totalHoursSpent += task.getTotalHours();
		}
		return totalHoursSpent;
	}

	@Override
	public int getProjectid() {
		return this.projectid;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
