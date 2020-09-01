package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanghuadi.beans.Activity;
import com.wanghuadi.beans.Server;
import com.wanghuadi.beans.Type;
import com.wanghuadi.mapper.ActivityMapper;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityMapper activityMapper;
	
	public List<Activity> queryAll(Map<String, Object> map) {
		return activityMapper.queryAll(map);
	}

	public List<Type> queryTypeAll() {
		return activityMapper.queryTypeAll();
	}

	public List<Server> queryServerAll() {
		return activityMapper.queryServerAll();
	}

	public void addActivity(Activity activity) {
		activityMapper.addActivity(activity);
	}

	public void addAS(Map<String, Object> map) {
		activityMapper.addAS(map);
	}

	public Activity queryById(Integer id) {
		return activityMapper.queryById(id);
	}

	public List<Server> queryServerByAid(Integer aid) {
		return activityMapper.queryServerByAid(aid);
	}

	public void updateActivity(Activity activity) {
		activityMapper.updateActivity(activity);
	}

	public void delAS(Integer id) {
		activityMapper.delAS(id);
	}

	public void deleteActivity(Integer id) {
		activityMapper.deleteActivity(id);
	}

}
