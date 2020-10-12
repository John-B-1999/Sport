package com.example.sportApp.service;

import com.example.sportApp.dao.SysUserMapper;
import com.example.sportApp.model.User;
import com.example.sportApp.utils.copyUtils.FileUtils;
import com.example.sportApp.utils.page.PageRequest;
import com.example.sportApp.utils.page.PageResult;
import com.example.sportApp.utils.page.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywm
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public User findByUserId(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) throws Exception {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest) throws Exception {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = sysUserMapper.selectPage();
        FileUtils.generateImage(sysMenus.get(0).getPic(),"C:\\Users\\ywm\\Desktop\\img.jpg");
        return new PageInfo<>(sysMenus);
    }
}