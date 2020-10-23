package com.chen.service;

import com.chen.entity.AppVersion;
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
 * @Date: 2020/10/22 15:56
 * @Version: 1.0
 */
@Service
@Transactional
public class AppVersionServiceImp extends BaseServiceImp<AppVersion,Long>
        implements AppVersionService<AppVersion,Long>{

    @Override
    public PageInfo<AppVersion> selectAllPage(Integer pageNum, Integer pageSize){
        AppVersion appVersion=new AppVersion();
        appVersion.setDelFlag("0");
        PageHelper.startPage(pageNum,pageSize);
        List<AppVersion> list = select(appVersion);
        PageInfo<AppVersion> appVersionPageInfo = new PageInfo<>(list);
        return appVersionPageInfo;
    }
}
