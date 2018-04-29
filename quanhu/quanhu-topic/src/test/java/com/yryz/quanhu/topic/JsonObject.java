/*create by chens at 2018-04-21  */
package com.yryz.quanhu.topic;

import com.alibaba.fastjson.JSONObject;
import com.yryz.quanhu.topic.entity.Topic;
import org.junit.Test;

/**
 * description:
 */
public class JsonObject {

    @Test
    public void m1(){
        Topic topic = new Topic();
        topic.setTitle("幸运一条龙");
        topic.setContent("周星星+吴孟达");
        String jsonString = JSONObject.toJSONString(topic);
        Topic topic2 =  JSONObject.parseObject(jsonString,Topic.class);
        System.out.println(topic2.getTitle());
        System.out.println(topic2.getContent());
    }

}
