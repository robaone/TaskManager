package com.robaone.taskmanager.data;

import java.util.Date;

import com.robaone.dbase.HDBConnectionManager;
import com.robaone.taskmanager.Storage;
import com.robaone.taskmanager.project.Project;
import com.robaone.taskmanager.project.ProjectNote;
import com.robaone.taskmanager.project.Task;

public class MysqlStorage implements Storage {
	protected HDBConnectionManager cman;
	public MysqlStorage(HDBConnectionManager connectionManager){
		this.cman = connectionManager;
	}
	@Override
	public void save(Project p) throws Exception {
		StoreProject store = new StoreProject((MysqlProject)p);
		store.run(this.getConnectionManager());
	}

	private HDBConnectionManager getConnectionManager() {
		return cman;
	}
	@Override
	public void delete(Project p) throws Exception {
		DeleteProject delete = new DeleteProject((MysqlProject)p);
		delete.run(this.getConnectionManager());
	}

	@Override
	public void delete(Task t) throws Exception {
		DeleteTask delete = new DeleteTask((MysqlTask)t);
		delete.run(this.getConnectionManager());
	}

	@Override
	public Project[] getProjectList() throws Exception {
		GetProjects get = new GetProjects(0,100);
		get.run(this.getConnectionManager());
		return get.getRecords().toArray(new Project[0]);
	}

	@Override
	public Project[] getProjectsBefore(Project p) throws Exception {
		GetProjectsBefore getBefore = new GetProjectsBefore((MysqlProject)p);
		getBefore.run(getConnectionManager());
		return getBefore.getRecords().toArray(new Project[0]);
	}

	@Override
	public double getAvailableHours(Date time) {
		ProjectCalendar calendar = ProjectCalendarFactory.newInstance();
		double hours = calendar.getAvailableHours(time);
		return hours;
	}

	@Override
	public Project getProject(int projectid) throws Exception {
		GetProject get = new GetProject(projectid);
		get.run(this.getConnectionManager());
		return get.getRecordCount() > 0 ? get.getRecord(0) : null;
	}

	@Override
	public void addTask(Project projectImpl, Task t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Task[] getTasks(Project projectImpl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTask(Project projectImpl, int taskid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(Task taskImpl) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void complete(Task taskImpl) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatus(Task taskImpl, String status) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTaskNode(Task taskImpl, ProjectNote note) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ProjectNote[] getTaskNotes(Task taskImpl) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTaskHoursSpent(Task taskImpl) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(Task taskImpl) throws Exception {
		// TODO Auto-generated method stub

	}

}
