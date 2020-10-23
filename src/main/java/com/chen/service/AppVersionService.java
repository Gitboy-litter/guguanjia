package com.chen.service;


import com.chen.entity.AppVersion;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 15:49
 * @Version: 1.0
 */
public interface AppVersionService<T,ID> extends BaseService<T,ID>  {
    PageInfo<AppVersion> selectAllPage(Integer pageNum, Integer pageSize);
}
