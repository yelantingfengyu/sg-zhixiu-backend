package com.zhixiu.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhixiu.app.model.SysLoginLog;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);

    List<SysLoginLog> findPage();

    List<SysLoginLog> findPageByUserName(
            @Param(value = "userName") String userName);

    List<SysLoginLog> findPageByStatus(@Param(value = "status") String status);
}