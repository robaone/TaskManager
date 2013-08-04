package com.robaone.taskmanager.project;


public interface Task {
	public static enum COMPLETION {CANCELLED, DONE};
	public void setProject(Project p);
	
	public Project getProject();

	public double getRemainingHours() throws Exception;
	
	public void delete() throws Exception;
	
	public void cancel() throws Exception;
	
	public void complete() throws Exception;
	
	public void setStatus(String status) throws Exception;
	
	public void setName(String name) throws Exception;
	
	public void setEstimatedHours(double hours) throws Exception;
	
	public void addProjectNote(ProjectNote note) throws Exception;
	
	public double getEstimatedHours();
	
	public ProjectNote[] getNotes() throws Exception;
	
	public int getTaskid();

	public double getTotalHours() throws Exception;

	String getName();
	
}
