package com.robaone.taskmanager.data;

import javax.xml.parsers.ParserConfigurationException;

import com.robaone.dbase.XMLConnectionBlock;
import com.robaone.taskmanager.project.Project;

public class GetProjects extends XMLConnectionBlock<Project> {

	private static final String NAME = "name";
	private static final String ID = "id";

	public GetProjects(int page, int limit)
			throws ParserConfigurationException {
		super("get", page, limit);
	}

	@Override
	protected Project bindRecord() throws Exception {
		MysqlProject p = new MysqlProject(this.getConnectionManager());
		p.setName(this.getResultSet().getString(NAME));
		p.setId(this.getResultSet().getInt(ID));
		return null;
	}

}
