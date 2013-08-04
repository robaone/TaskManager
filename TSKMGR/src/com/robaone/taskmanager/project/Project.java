package com.robaone.taskmanager.project;


public interface Project {
	public void addTask(Task t);

	public Task[] getTasks();
	
	public Task getTask(int taskid);

	public double getRemainingHours() throws Exception;
	
	public int getProjectid();
	
	public void setName(String name) throws Exception;
	
	public String getName() throws Exception;
}
