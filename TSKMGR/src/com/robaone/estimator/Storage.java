package com.robaone.estimator;

import java.util.Date;

public interface Storage {

	void save(Project p) throws Exception;

	void delete(Project p) throws Exception;

	Project[] getProjectList() throws Exception;

	Project[] getProjectsBefore(Project p) throws Exception;

	double getAvailableHours(Date time);

}
