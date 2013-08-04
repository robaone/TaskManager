package com.robaone.taskmanager.data;

import com.robaone.dbase.XMLConnectionBlock;
import com.robaone.taskmanager.impl.ProjectImpl;
import com.robaone.taskmanager.project.Project;

public class StoreProject extends XMLConnectionBlock<Project> {

	public StoreProject(MysqlProject p)
			throws Exception {
		super("store_new", 0, 1);
		if(p.getId() != null){
			this.setQueryName("save");
			this.setParameter("id", p.getId());
		}else{
		}
		this.setParameter("name", p.getName());
		this.setAsUpdate();
	}

	@Override
	protected Project bindRecord() throws Exception {
		ProjectImpl project = new MysqlProject(this.getConnectionManager());
		return project;
	}

}
