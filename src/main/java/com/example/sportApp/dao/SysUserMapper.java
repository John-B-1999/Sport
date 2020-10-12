package com.example.sportApp.dao;

import com.example.sportApp.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywm
 */
@Repository
@Mapper
public interface SysUserMapper {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(SysUser record);
//
//    int insertSelective(SysUser record);
//
//    SysUser selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(SysUser record);
//
//    int updateByPrimaryKey(SysUser record);

    /**
     * 查询全部用户
     * @return
     */
    List<User> selectAll();

    /**
     * 分页查询用户
     * @return
     */
    List<User> selectPage();

    /**
     * 根据id查询
     */
     User selectByPrimaryKey(Long userId);
}