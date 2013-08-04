package com.robaone.taskmanager.data;

import com.robaone.taskmanager.Storage;
import com.robaone.taskmanager.impl.TaskImpl;

public class MysqlTask extends TaskImpl {
	private Integer id;
	public MysqlTask(Storage source) {
		super(source);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
