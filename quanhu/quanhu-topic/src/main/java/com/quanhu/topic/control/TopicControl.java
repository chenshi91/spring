
package com.quanhu.topic.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.quanhu.base.controller.BaseController;
import com.quanhu.base.service.BaseService;
import com.quanhu.topic.entity.Topic;
import com.quanhu.topic.service.TopicService;

/**
 * 
 * @description:	TopicControl.java
 * @packageName:	com.quanhu.topic.control
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@RequestMapping(value="v1/admin/topic")
@Controller
public class TopicControl extends BaseController<Topic> {

	private static final long serialVersionUID = -2930691891893312591L;
	
	@Resource(name="topicService")
	TopicService	topicService;

	@Override
	public BaseService<Topic> getService() {
		return topicService;
	}
	
	/**
	 * @description:selectById(详情)
	 * @param model
	 * @param id
	 * @return String
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public	String	selectById(Model	model,@PathVariable(value="id")Long	id){
		Topic topic = topicService.selectById(id);
		model.addAttribute("entity", topic);
		return	"topic/topic";
	}
	
	@RequestMapping(value="/{pageNo}/{pageSize}",method=RequestMethod.GET)
	public String list(Model model,@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
		List<Topic> list = topicService.listByPage(pageNo, pageSize);
		model.addAttribute("list", list);
		return	"topic/topicList";
	}
	
	@RequestMapping(value="/json",method=RequestMethod.GET)
	public void list2(HttpServletResponse response, int page, int rows) throws IOException{
		if(page==0&&rows==0){
			page=1;
			rows=10;
		}
		List<Topic> list = topicService.listByPage(page, rows);
		Map<String,Object> map = new HashedMap();
		map.put("total", 625);
		map.put("rows", list);
		response.setCharacterEncoding("utf-8");
		String string = JSONObject.toJSON(map).toString();
		response.getWriter().write(string);
	}

}
