/* created by chenshi at 2018-04-30 */
package com.yryz.quanhu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.quanhu.base.entity.BaseEntity;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Demo extends BaseEntity {
    private String  name;
    private Byte    age;
    @JsonIgnore
    private String  content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
