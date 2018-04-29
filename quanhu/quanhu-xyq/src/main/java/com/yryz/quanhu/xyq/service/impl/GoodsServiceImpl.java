/* created by chenshi at 2018-04-28 */
package com.yryz.quanhu.xyq.service.impl;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.service.impl.BaseServiceImpl;
import com.yryz.quanhu.xyq.dao.GoodsDao;
import com.yryz.quanhu.xyq.entity.Goods;
import com.yryz.quanhu.xyq.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(isolation =Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS,readOnly = true)
public class GoodsServiceImpl   extends BaseServiceImpl<Goods>  implements IGoodsService {
    @Resource(name = "goodDao")
    private GoodsDao goodsDao;

    @Override
    public BaseDao<Goods> getDao() {
        return goodsDao;
    }

}
