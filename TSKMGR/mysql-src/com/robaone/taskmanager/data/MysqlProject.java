package com.robaone.taskmanager.data;

import com.robaone.dbase.HDBConnectionManager;
import com.robaone.taskmanager.impl.ProjectImpl;

public class MysqlProject extends ProjectImpl {
	private Integer id;
	public MysqlProject(HDBConnectionManager cman) {
		super(new MysqlStorage(cman));
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
