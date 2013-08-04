package com.robaone.taskmanager.data;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;

import com.robaone.dbase.XMLConnectionBlock;
import com.robaone.taskmanager.project.Project;

public class GetProject extends XMLConnectionBlock<Project> {

	private static final String ID = "id";
	private static final String NAME = "name";

	public GetProject(int projectID)
			throws ParserConfigurationException, JSONException {
		super("get", 0, 1);
		this.setParameter(ID, projectID);
	}

	@Override
	protected Project bindRecord() throws Exception {
		MysqlProject project = new MysqlProject(this.getConnectionManager());
		project.setId(getResultSet().getInt(ID));
		project.setName(getResultSet().getString(NAME));
		return project;
	}

}
