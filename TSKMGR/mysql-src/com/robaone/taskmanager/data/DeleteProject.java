package com.robaone.taskmanager.data;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;

import com.robaone.dbase.XMLConnectionBlock;
import com.robaone.taskmanager.project.Project;

public class DeleteProject extends XMLConnectionBlock<Project> {

	public DeleteProject(MysqlProject p)
			throws ParserConfigurationException, JSONException {
		super("delete",0, 1);
		this.setParameter("id", p.getId());
		this.setAsUpdate();
	}

	@Override
	protected Project bindRecord() throws Exception {
		return null;
	}

}
