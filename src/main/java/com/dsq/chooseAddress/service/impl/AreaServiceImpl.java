package com.dsq.chooseAddress.service.impl;

import com.dsq.chooseAddress.mapper.AreaMapper;
import com.dsq.chooseAddress.pojo.Area;
import com.dsq.chooseAddress.service.AreaService;
import com.dsq.chooseAddress.utils.JedisClient;
import com.dsq.chooseAddress.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaMapper areaMapper;
    @Autowired
    JsonUtils jsonUtils;
    @Autowired
    JedisClient jedisClient;

    @Override
    public List<Area> provinceServlet() {
        // 从redis中获取数据
        String areaJson = jedisClient.get("LEVEL:" + 1);
        List<Area> areaList = null;
        // 判断数据是否为空
        if (null == areaJson || areaJson.equals("")) {
            // 从mysql中查询
            areaList = areaMapper.provinceServlet();
            // 转为json
            String areaData = jsonUtils.objectToJson(areaList);
            // 存入redis中
            jedisClient.set("LEVEL:" + 1,areaData);
            System.out.println("从数据库中获取");
        } else {
            // 将redis中获取的数据转为json
            areaList = jsonUtils.jsonToList(areaJson, Area.class);
            System.out.println("从redis中获取");
        }
        return areaList;
    }

    @Override
    public List<Area> cityServlet(int id) {
        // 从redis中获取数据
        String cityJson = jedisClient.get("PARENT_ID:" + id);
        List<Area> cityList = null;
        if (null == cityJson || cityJson.equals("")) {
            // 从mysql中获取
            cityList = areaMapper.cityServlet(id);
            // 存入redis中
            jedisClient.set("PARENT_ID:" + id,jsonUtils.objectToJson(cityList));
            System.out.println("从数据库中获取");
        } else {
            // 将redis中获取的数据转为json
            cityList = jsonUtils.jsonToList(cityJson,Area.class);
            System.out.println("从redis中获取");
        }
        return cityList;
    }

    @Override
    public List<Area> countyServlet(int id) {
        // 从redis中获取数据
        String countyJson = jedisClient.get("PARENT_ID:" + id);
        List<Area> countyList = null;
        if (null == countyJson || countyJson.equals("")) {
            // 从mysql中获取数据
            countyList = areaMapper.countyServlet(id);
            // 将数据转为json并存入redis中
            jedisClient.set("PARENT_ID:" + id,jsonUtils.objectToJson(countyList));
            System.out.println("从数据库中获取");
        } else {
            // 将redis中获取的数据转为json
            countyList = jsonUtils.jsonToList(countyJson, Area.class);
            System.out.println("从redis中获取");
        }
        return countyList;
    }
}
