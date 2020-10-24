package com.chen.service;


import com.chen.entity.Qualification;
import com.chen.entity.QualificationCondition;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 15:49
 * @Version: 1.0
 */
public interface QualificationService<T,ID> extends BaseService<T,ID>  {
    PageInfo<Qualification> selectAllPage(Integer pageNum, Integer pageSize, QualificationCondition qualificationCondition);
}
