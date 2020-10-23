package com.chen.service;

import com.chen.entity.AppVersion;
import com.chen.entity.Demand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/23 17:34
 * @Version: 1.0
 */
@Service
@Transactional
public class DemandServiceImp  extends BaseServiceImp<Demand,Long> implements DemandService {
    @Override
    public PageInfo<Demand> selectAllPage(Integer pageNum, Integer pageSize){
        Demand demand=new Demand();
        demand.setDelFlag("0");
        PageHelper.startPage(pageNum,pageSize);
        List<Demand> list = select(demand);
        PageInfo<Demand> demandPageInfo = new PageInfo<>(list);
        return demandPageInfo;
    }
}
