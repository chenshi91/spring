/**Created	by	chenshi  at	2017年12月28日 下午7:04:59*/
package com.yryz.quanhu.topic.control;

import java.util.List;

import com.yryz.quanhu.topic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quanhu.base.controller.BaseController;
import com.quanhu.base.service.BaseService;
import com.yryz.quanhu.topic.entity.Post;

/**
 * @description:	PostControal.java
 * @packageName:	com.quanhu.topic.control
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@RequestMapping(value="v1/admin/post")
@Controller
public class PostControal extends BaseController<Post> {

	/***/
	private static final long serialVersionUID = 1377873264540106576L;
	
	@Autowired
    PostService postService;
	
	@Override
	public BaseService<Post> getService() {
		return postService;
	}
	
	@RequestMapping(value="list")
	public	String	list(Model model,Long topicId){
		List<Post> list = postService.postListByPage(topicId, (byte)1, (byte)10);
		model.addAttribute("list", list);
		return	"topic/postList";
	}
}
