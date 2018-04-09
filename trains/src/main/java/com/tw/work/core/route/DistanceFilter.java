package com.tw.work.core.route;

import com.tw.work.model.Route;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public class DistanceFilter implements RouteFilter {

    public List<Route> filter(List<Route> routes) {
        ArrayList<Route> re = new ArrayList<Route>();
        for (Route route :routes){
            if (route.sumDistance().compareTo(new BigDecimal("30")) <0){
                re.add(route);
            }
        }
        return re;
    }
}
