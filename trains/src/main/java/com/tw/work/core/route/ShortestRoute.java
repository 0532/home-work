package com.tw.work.core.route;

import com.tw.work.model.Route;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 过滤出最短的路径
 * Created by Lichao.Wang on 2018/4/8.
 */
public class ShortestRoute implements RouteFilter {

    public List<Route> filter(List<Route> routes) {
        Route last = null;
        BigDecimal lastDistance = new BigDecimal(Integer.MAX_VALUE);
        for (Route route :routes){
            if (lastDistance.compareTo(route.sumDistance())>=0){
                last = route;
                lastDistance = route.sumDistance();
            }
        }
        return Arrays.asList(last);
    }
}
