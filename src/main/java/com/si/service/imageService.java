package com.si.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.si.dao.appImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/3/9.
 */
@Service
public class imageService {

    public static final Integer pageSize = 20;

    @Autowired
    appImageMapper appImageMapper;

    public Map imageList(Integer page) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page, pageSize);
        ArrayList list = appImageMapper.selectAll(pageBounds);
        PageList pageList = (PageList) list;
        map.put("code", 0);
        map.put("list", list);
        map.put("count", pageList.getPaginator().getTotalCount());
        map.put("pagesize", pageSize);
        map.put("page", page);
        return map;
    }
}
