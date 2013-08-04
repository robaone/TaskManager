package com.robaone.taskmanager;

import java.util.Date;

import com.robaone.taskmanager.project.Project;
import com.robaone.taskmanager.project.Task;

public interface Storage {

	void save(Project p) throws Exception;

	void delete(Project p) throws Exception;

	Project[] getProjectList() throws Exception;

	Project[] getProjectsBefore(Project p) throws Exception;

	double getAvailableHours(Date time);
	
	Project getProject(int projectid) throws Exception;

	void addTask(Project projectImpl, Task t);

	Task[] getTasks(Project projectImpl);

	Task getTask(Project projectImpl, int taskid);

}
