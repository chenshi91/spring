/* created by chenshi at 2018-04-28 */
package com.yryz.quanhu.xyq.entity;

import com.quanhu.base.entity.BaseEntity;

public class Goods extends BaseEntity {
    private String  name;
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
}
