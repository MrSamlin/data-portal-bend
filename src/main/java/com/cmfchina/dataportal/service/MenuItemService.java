package com.cmfchina.dataportal.service;

import com.cmfchina.dataportal.entity.DataMenuItem;
import com.cmfchina.dataportal.entity.IndustryMap;
import com.cmfchina.dataportal.entity.Metrics;
import com.cmfchina.dataportal.entity.QueryDao;

import java.util.List;

public interface MenuItemService {

    List<DataMenuItem> getTopMenuItem();

    List<DataMenuItem> getTopMenuItemList(QueryDao query);

    int countTopList(QueryDao dao);

    Integer  insertMenuItem(DataMenuItem dataMenuItem);

    Integer updateMenuItem(DataMenuItem dataMenuItem);

    void deleteTopMenuItem(Integer menuId);

    List<DataMenuItem> getChildMenuItem(QueryDao dao);

    List<DataMenuItem> getChildMenuItemList(QueryDao dao);

    int countChildList(QueryDao dao);

    List<DataMenuItem> getAllMenuItem();


    DataMenuItem getMenuItemById(Integer menuId);
}