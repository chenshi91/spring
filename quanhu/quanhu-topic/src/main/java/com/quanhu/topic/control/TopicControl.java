
package com.quanhu.topic.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quanhu.base.controller.BaseController;
import com.quanhu.base.enums.CommonEnum;
import com.quanhu.base.exception.ServiceException;
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
	@RequestMapping(value="selectById/{id}" )
	public	String	selectById(Model	model,@PathVariable(value="id")Long	id){
		Topic topic=null;
		try {
			topic = topicService.selectById(id);
//			Object ot=(Object) topic;
		} catch (ServiceException e) {
			e.printStackTrace();
			logger.info("-------------service出现异常-------------");
			return	"dfdfdf";
		}
		model.addAttribute("entity", topic);
		return	"topic/postList";
	}
	
	@RequestMapping(value="list/all",method=RequestMethod.GET)
	public String list(Model model){
		List<Topic> list = topicService.listByPage((byte)1, (byte)10);
		if(CollectionUtils.isEmpty(list)){
			model.addAttribute("list", list);
			return	"topic/topicList";
		}
		for (Topic topic : list) {
			//设置枚举属性
			if(topic.getShelveFlag()!=null){
				if(topic.getShelveFlag()==CommonEnum.SHELVE_ON.getValue()){
					topic.setCommonEnum(CommonEnum.SHELVE_ON);
				}else if (topic.getShelveFlag()==CommonEnum.SHELVE_OFF.getValue()) {
					topic.setCommonEnum(CommonEnum.SHELVE_OFF);
				}else {
					topic.setCommonEnum(CommonEnum.UN_KNOW);
//					topic.setShelveFlag(CommonEnum.SHELVE_ON.getValue());
				}		
			}
		}
		model.addAttribute("list", list);
		/*String aaa="sdsds";
		aaa.substring(beginIndex, endIndex)
		aaa.length()*/
		return	"topic/topicList";
	}
	
	@RequestMapping(value="pagelist/{pageNo}/{pageSize}",method=RequestMethod.GET)
	public	String	listByPage(@PathVariable(value="pageNo")Byte pageNo,@PathVariable(value="pageSize")Byte pageSize,Model model){
		return	listByPage(pageNo, pageSize, model, "topic/topicList");
	}
	

}
