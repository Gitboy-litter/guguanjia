package com.chen.dao;

import com.chen.entity.AppVersion;
import com.chen.entity.Qualification;
import com.chen.entity.QualificationCondition;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface QualificationMapper extends Mapper<Qualification> {

    List<Qualification> getQualificationAndSysUser(QualificationCondition qualificationCondition);

}