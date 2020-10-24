package com.chen.service;

import com.chen.entity.AppVersion;
import com.chen.entity.Qualification;
import com.chen.entity.SysUser;
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
public class SysUserServiceImp extends BaseServiceImp<SysUser,Long>
        implements SysUserService<SysUser,Long>{

}
