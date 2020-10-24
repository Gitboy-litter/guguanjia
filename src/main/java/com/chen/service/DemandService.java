package com.chen.service;

import com.chen.entity.Demand;
import com.github.pagehelper.PageInfo;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/23 17:34
 * @Version: 1.0
 */
public interface DemandService<T,D> extends BaseService<T,D> {
    PageInfo<Demand> selectAllPage(Integer pageNum, Integer pageSize);
}
