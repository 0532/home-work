package com.tw.work.core.view;

import com.tw.work.model.Edge;
import com.tw.work.model.Route;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public class DistanceView implements RouteView {

    public Object routeViewer(List<Route> route) {
        if (route==null || route.isEmpty()){
            return DEFAULT_NO_ROUTE;
        }
        BigDecimal sum = new BigDecimal("0");
        for(Route r :route){
            for (Edge edge :r.getRouteNode()){
                sum = edge.getDistance().add(sum);
            }
        }
        return sum;
    }
}
