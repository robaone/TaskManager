package com.robaone.taskmanager.estimator;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.robaone.taskmanager.Storage;
import com.robaone.taskmanager.estimator.Estimate;
import com.robaone.taskmanager.project.Project;
import com.robaone.taskmanager.project.ProjectNote;
import com.robaone.taskmanager.project.Task;

public class EstimateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void test() throws Exception {
		Estimate est = new Estimate(getStorage());
		Date estimatedDate = est.getEstimatedCompletionDate(getProject());
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Estimated Completion Date = "+df.format(estimatedDate));
		assertTrue(new java.util.Date().before(estimatedDate));
	}
	
	@Test
	public void testProject() {
		Project project = this.getProject();
		Task[] tasks = project.getTasks();
		assertTrue(tasks != null);
	}

	protected Project getProject() {
		return new Project(){

			@Override
			public void addTask(Task t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Task[] getTasks() {
				Task[] tasks = new Task[0];
				return tasks;
			}

			@Override
			public double getRemainingHours() {
				return 4;
			}

			@Override
			public int getProjectid() {
				return 0;
			}

			@Override
			public Task getTask(int taskid) {
				return EstimateTest.this.getTask();
			}
			
		};
	}

	protected Task getTask() {
		return new Task(){
			Project p;
			@Override
			public void setProject(Project p) {
				p = EstimateTest.this.getProject();
			}

			@Override
			public double getRemainingHours() {
				return 5;
			}

			@Override
			public void delete() throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void cancel() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void complete() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setStatus(String status) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setEstimatedHours(double hours) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void addProjectNote(ProjectNote note) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public double getEstimatedHours() {
				return 5;
			}

			@Override
			public ProjectNote[] getNotes() {
				ProjectNote[] notes = new ProjectNote[0];
				return notes;
			}

			@Override
			public int getTaskid() {
				return 0;
			}

			@Override
			public Project getProject() {
				return p;
			}
			
		};
	}

	private Storage getStorage() {
		return new Storage(){

			@Override
			public void save(Project p) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(Project p) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Project[] getProjectList() throws Exception {
				Project[] list = new Project[2];
				list[0] = EstimateTest.this.getProject();
				list[1] = EstimateTest.this.getProject();
				return list;
			}

			@Override
			public Project[] getProjectsBefore(Project p) throws Exception {
				return getProjectList();
			}

			@Override
			public double getAvailableHours(Date time) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(time);
				if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
					return 0;
				}else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
					return 1.5;
				}else{
					return 4;
				}
			}

			@Override
			public Project getProject(int projectid) throws Exception {
				return EstimateTest.this.getProject();
			}
			
		};
	}

}
