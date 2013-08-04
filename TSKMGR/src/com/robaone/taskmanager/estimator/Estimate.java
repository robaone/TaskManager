package com.robaone.taskmanager.estimator;

import java.util.Calendar;
import java.util.Date;

import com.robaone.taskmanager.Storage;
import com.robaone.taskmanager.project.Project;

public class Estimate {
	private Storage storage;
	public Estimate(Storage store){
		this.setStorage(store);
	}
	public void addProject(Project p) throws Exception{
		this.getStorage().save(p);
	}
	public void removeProject(Project p) throws Exception{
		this.getStorage().delete(p);
	}
	public Date getEstimatedCompletionDate(Project p) throws Exception{
		Date retVal = null;
		Project[] projects = this.getStorage().getProjectsBefore(p);
		double remaining_hours = 0;
		for(Project project : projects){
			remaining_hours += project.getRemainingHours();
		}
		remaining_hours += p.getRemainingHours();
		int days = getDaysForHours(remaining_hours);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		cal.add(Calendar.DATE, days);
		retVal = cal.getTime();
		return retVal;
	}
	private int getDaysForHours(double remaining_hours) {
		double hours = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int days = 0;
		for(int i = 0; hours < remaining_hours;i++){
			hours += getAvailableHoursForDate(cal.getTime());
			days = i;
			cal.add(Calendar.DATE, 1);
		}
		return days;
	}
	private double getAvailableHoursForDate(Date time) {
		double hours = this.getStorage().getAvailableHours(time);
		return hours;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
