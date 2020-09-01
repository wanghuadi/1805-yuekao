package com.wanghuadi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuadi.beans.Activity;
import com.wanghuadi.beans.Server;
import com.wanghuadi.beans.Type;
import com.wanghuadi.service.ActivityService;

@Controller
public class ActivityController {
	
	@Resource
	private ActivityService activityService;
	
	/**
	 * 活动列表
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model,@RequestParam(defaultValue="1")Integer pageNum,String aname,
			Integer tid,String startTime,String endTime){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aname", aname);
		map.put("tid", tid);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		
		
		PageHelper.startPage(pageNum, 2);
		//列表查询
		List<Activity> list = activityService.queryAll(map);
		
		PageInfo<Activity> page = new PageInfo<Activity>(list);
		
//		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "list";
	}

	@RequestMapping("queryTypeAndServer")
	@ResponseBody
	public Map<String, Object> queryTypeAndServer(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//1. 查询分类下拉
		List<Type> typeList = activityService.queryTypeAll();
		
		//2.查询所有 服务
		List<Server> serverList = activityService.queryServerAll();
		
		map.put("typeList", typeList);
		map.put("serverList", serverList);
		
		return map;
	}
	
	/**
	 * 添加活动
	 * @param activity  接受活动信息
	 * @param sid		活动服务拼接的id
	 * @return
	 */
	@RequestMapping("addActivity")
	@ResponseBody
	public boolean addActivity(Activity activity,String sid){
		
		try {
			//添加活动表	返回主键id
			activityService.addActivity(activity);
			
			//添加返回的主键
			Integer id = activity.getId();
			
			
			Map<String,Object> map = new HashMap<String, Object>();
			//添加中间表   活动与活动服务关联
			String[] split = sid.split(",");
			for (String string : split) {
				map.put("sid", string);
				map.put("aid", id);
				activityService.addAS(map);
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@RequestMapping("queryById")
	@ResponseBody
	public Map<String, Object> queryById(Integer id){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		//活动信息回显
		Activity activity = activityService.queryById(id);
		
		//查询下拉
		List<Type> typeList = activityService.queryTypeAll();
		
		//查询所有的复选框
		List<Server> serverList = activityService.queryServerAll();
		
		//查询当前活动选中的复选框
				List<Server> serverByAid = activityService.queryServerByAid(id);
		for (Server server : serverList) {
			for (Server server2 : serverByAid) {
				if(server.getId() == server2.getId()){
					//选中
					server.setFlg(true);
				}
				
			}
		}
		
		
		map.put("activity", activity);
		map.put("typeList", typeList);
		map.put("serverList", serverList);
		
		return map;
	}
	
	@RequestMapping("updateActivity")
	@ResponseBody
	public boolean updateActivity(Activity activity,String sid){
		
		try {
			//根据id 修改活动信息
			activityService.updateActivity(activity);
			
			//根据id 删除中间表信息
			activityService.delAS(activity.getId());
			
			//然后将活动与服务重新关联添加
			Map<String,Object> map = new HashMap<String, Object>();
			//添加中间表   活动与活动服务关联
			String[] split = sid.split(",");
			for (String string : split) {
				map.put("sid", string);
				map.put("aid", activity.getId());
				activityService.addAS(map);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@RequestMapping("deleteActivity")
	@ResponseBody
	public boolean deleteActivity(Integer aid){
		
		try {
			//删除1条活动数据，同时删除中间表数据
			activityService.deleteActivity(aid);
			activityService.delAS(aid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
