package com.robaone.taskmanager.project;


public interface Task {
	public void setProject(Project p);
	
	public Project getProject();

	public double getRemainingHours();
	
	public void delete() throws Exception;
	
	public void cancel();
	
	public void complete();
	
	public void setStatus(String status);
	
	public void setEstimatedHours(double hours);
	
	public void addProjectNote(ProjectNote note);
	
	public double getEstimatedHours();
	
	public ProjectNote[] getNotes();
	
	public int getTaskid();
	
}
