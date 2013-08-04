package com.robaone.taskmanager.data;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;

import com.robaone.dbase.XMLConnectionBlock;
import com.robaone.taskmanager.project.Task;

public class DeleteTask extends XMLConnectionBlock<Task> {

	public DeleteTask(MysqlTask task)
			throws ParserConfigurationException, JSONException {
		super("delete", 0, 1);
		this.setParameter("id", task.getId());
		this.setAsUpdate();
	}

	@Override
	protected Task bindRecord() throws Exception {
		return null;
	}

}
