package com.robaone.taskmanager.project;


public interface Project {
	public void addTask(Task t);

	public Task[] getTasks();
	
	public Task getTask(int taskid);

	public double getRemainingHours() throws Exception;
	
	public int getProjectid();
}
