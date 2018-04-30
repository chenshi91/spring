/* created by chenshi at 2018-04-30 */
package com.yryz.quanhu.demo.service.impl;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.service.impl.BaseServiceImpl;
import com.yryz.quanhu.demo.dao.DemoDao;
import com.yryz.quanhu.demo.entity.Demo;
import com.yryz.quanhu.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation =Isolation.READ_COMMITTED,readOnly = true,rollbackFor = Exception.class)
public class DemoServiceImpl    extends BaseServiceImpl<Demo> implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public BaseDao<Demo> getDao() {
        return demoDao;
    }
}
