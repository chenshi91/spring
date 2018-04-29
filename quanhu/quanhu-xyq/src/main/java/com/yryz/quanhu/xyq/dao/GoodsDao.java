package com.yryz.quanhu.xyq.dao;

import com.quanhu.base.dao.BaseDao;
import com.yryz.quanhu.xyq.entity.Goods;
import org.springframework.stereotype.Repository;

@Repository(value = "goodDao")
public interface GoodsDao extends BaseDao<Goods> {

}
