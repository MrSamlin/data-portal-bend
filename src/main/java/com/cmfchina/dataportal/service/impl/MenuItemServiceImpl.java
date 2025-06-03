package com.cmfchina.dataportal.service.impl;

import com.cmfchina.dataportal.entity.DataMenuItem;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.mapper.DataMenuItemMapper;
import com.cmfchina.dataportal.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl  implements MenuItemService {

    @Autowired
    private DataMenuItemMapper dataMenuItemMapper;

    @Override
    public List<DataMenuItem> getTopMenuItem() {
        List<DataMenuItem> topMenuItem = dataMenuItemMapper.getTopMenuItem();
        return topMenuItem;
    }

    @Override
    public List<DataMenuItem> getTopMenuItemList(QueryDao query) {
        List<DataMenuItem> topMenuItemList = dataMenuItemMapper.getTopMenuItemList(query);
        return topMenuItemList;
    }

    @Override
    public int countTopList(QueryDao dao) {
        return dataMenuItemMapper.countTopList(dao);
    }

    @Override
    public Integer insertMenuItem(DataMenuItem dataMenuItem) {
        return   dataMenuItemMapper.insertMenuItem(dataMenuItem);
    }

    @Override
    public Integer updateMenuItem(DataMenuItem dataMenuItem) {

        return   dataMenuItemMapper.updateMenuItem(dataMenuItem);
    }

    @Override
    public void deleteTopMenuItem(Integer menuId) {
        dataMenuItemMapper.deleteMenuItem(menuId);
    }

    @Override
    public  List<DataMenuItem> getChildMenuItem(QueryDao dao) {
        List<DataMenuItem> topMenuItem = dataMenuItemMapper.getChildMenuItem(dao.getParentId());
        return topMenuItem;
    }

    @Override
    public List<DataMenuItem> getChildMenuItemList(QueryDao dao) {
        List<DataMenuItem> childMenuItemList = dataMenuItemMapper.getChildMenuItemList(dao);
        return childMenuItemList;
    }

    @Override
    public int countChildList(QueryDao dao) {
        return dataMenuItemMapper.countChildList(dao);
    }

    @Override
    public List<DataMenuItem> getAllMenuItem() {
        return dataMenuItemMapper.getAllMenuItem();
    }

    @Override
    public DataMenuItem getMenuItemById(Integer menuId) {
        DataMenuItem menuItemByVo = dataMenuItemMapper.getMenuItemById(menuId);
        return menuItemByVo;
    }

}
