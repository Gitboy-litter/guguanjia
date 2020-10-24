package com.chen.service;

import com.chen.dao.QualificationMapper;
import com.chen.entity.Qualification;
import com.chen.entity.QualificationCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 15:56
 * @Version: 1.0
 */
@Service
@Transactional
public class QualificationServiceImp extends BaseServiceImp<Qualification, Long>
        implements QualificationService<Qualification, Long> {

    @Autowired
    private QualificationMapper qualificationMapper;


    @Override
    public PageInfo<Qualification> selectAllPage(Integer pageNum, Integer pageSize, QualificationCondition qualificationCondition) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qualification> qualificationAndSysUser = qualificationMapper.getQualificationAndSysUser(qualificationCondition);
        PageInfo<Qualification> appVersionPageInfo = new PageInfo<>(qualificationAndSysUser);
        return appVersionPageInfo;
    }
}
