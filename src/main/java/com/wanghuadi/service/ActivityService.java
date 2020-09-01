package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Activity;
import com.wanghuadi.beans.Server;
import com.wanghuadi.beans.Type;

public interface ActivityService {
	//列表
	public List<Activity> queryAll(Map<String,Object> map);
	//下拉
	public List<Type> queryTypeAll();
	//服务
	public List<Server> queryServerAll();
	
	public void addActivity(Activity activity);
	
	public void addAS(Map<String,Object> map);
	
	//活动回显
	public Activity queryById(Integer id);
	
	//根据活动id 查询服务信息
	public List<Server> queryServerByAid(Integer aid);
	
	//修改活动
	public void updateActivity(Activity activity);
	
	//删除中间表信息  根据活动id
	public void delAS(Integer id);
	
	//删除活动信息
	public void deleteActivity(Integer id);
}
