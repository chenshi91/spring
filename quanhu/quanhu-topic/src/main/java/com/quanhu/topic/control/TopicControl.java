
package com.quanhu.topic.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quanhu.base.resource.BaseResource;
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
public class TopicControl extends BaseResource<Topic> {

	private static final long serialVersionUID = -2930691891893312591L;
	
	@Autowired
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
	@RequestMapping(value="selectById" )
	public	String	selectById(Model	model,@RequestParam("id")Long	id){
		Topic topic = topicService.selectById(id);
		model.addAttribute("entity", topic);
		return	"topic/topicList";
	}
	
	@RequestMapping(value="list/all")
	public String list(Model model){
		List<Topic> list = topicService.selectAll();
		model.addAttribute("list", list);
		/*String aaa="sdsds";
		aaa.substring(beginIndex, endIndex)
		aaa.length()*/
		return	"topic/topicList";
	}
	

}
