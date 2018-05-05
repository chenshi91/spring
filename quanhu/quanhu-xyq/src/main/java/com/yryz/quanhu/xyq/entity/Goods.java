/* created by chenshi at 2018-04-28 */
package com.yryz.quanhu.xyq.entity;

import com.quanhu.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Goods extends BaseEntity {

    @NotNull
    @Max(value = 5,message = "最长不能超过5个字节")
    private String  name;

    @NotNull
    @Min(value = 0,message = "价格不能小于0")
    private Double  prize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public Goods() {
    }

    public Goods(String name, Double prize) {

        this.name = name;
        this.prize = prize;
    }
}
