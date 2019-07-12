package com.dsq.chooseAddress.controller;

import com.dsq.chooseAddress.pojo.Area;
import com.dsq.chooseAddress.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AreaController {

    @Autowired
    AreaService areaService;

    @RequestMapping("/provinceServlet")
    @ResponseBody
    public List<Area> provinceServlet() {
        List<Area> areaList = areaService.provinceServlet();
        return areaList;
    }

    @RequestMapping("/cityServlet")
    @ResponseBody
    public List<Area> cityServlet(int id) {
        List<Area> areaCityList = areaService.cityServlet(id);
        return areaCityList;
    }

    @RequestMapping("/countyServlet")
    @ResponseBody
    public List<Area> countyServlet(int id) {
        List<Area> areaCountyList = areaService.countyServlet(id);
        return areaCountyList;
    }
}
