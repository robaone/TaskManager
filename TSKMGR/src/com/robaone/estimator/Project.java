package com.robaone.estimator;

public interface Project {
	public void addTask(Task t);

	public Task[] getTasks();

	public double getRemainingHours();
}
