package com.si.controller;

import com.si.service.imageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/3/7.
 */
@Controller
@RequestMapping("/")
public class mainController {
    @Autowired
    imageService imageService;

    @RequestMapping(value = "/weather")
    @ResponseBody
    public Map weather() throws Exception {
        Map map = new HashMap();
        map.put("code", 0);
        map.put("weather", 1);
        map.put("temperature", 30.7);
        return map;
    }

    @RequestMapping(value = "/imagelist")
    @ResponseBody
    public Map imagelist(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page)
            throws Exception {
        Map map = imageService.imageList(page);
        return map;
    }
}
