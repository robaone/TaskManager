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

	private Project getProject() {
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
				list[0] = getProject();
				list[1] = getProject();
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
			
		};
	}

}
