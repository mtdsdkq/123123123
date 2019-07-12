package com.dsq.chooseAddress.service;

import com.dsq.chooseAddress.pojo.Area;

import java.util.List;

public interface AreaService {
    List<Area> provinceServlet();

    List<Area> cityServlet(int id);

    List<Area> countyServlet(int id);
}
