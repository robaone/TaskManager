package com.robaone.taskmanager.project;


public interface Project {
	public void addTask(Task t);

	public Task[] getTasks();

	public double getRemainingHours();
}
