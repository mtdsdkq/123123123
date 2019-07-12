package com.dsq.chooseAddress.mapper;

import com.dsq.chooseAddress.pojo.Area;

import java.util.List;

public interface AreaMapper {
    List<Area> provinceServlet();

    List<Area> cityServlet(int id);

    List<Area> countyServlet(int id);
}
