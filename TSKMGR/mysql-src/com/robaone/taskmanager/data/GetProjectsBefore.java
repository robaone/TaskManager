package com.robaone.taskmanager.data;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;

import com.robaone.dbase.XMLConnectionBlock;
import com.robaone.taskmanager.project.Project;

public class GetProjectsBefore extends XMLConnectionBlock<Project> {

	private static final String ID = "id";
	private static final String NAME = "name";

	public GetProjectsBefore(MysqlProject p)
			throws ParserConfigurationException, JSONException {
		super("get", 0, 100);
		this.setParameter(ID, p.getId());
	}

	@Override
	protected Project bindRecord() throws Exception {
		MysqlProject project = new MysqlProject(this.getConnectionManager());
		project.setId(this.getResultSet().getInt(ID));
		project.setName(this.getResultSet().getString(NAME));
		return project;
	}

}
