package com.tw.work.core.route;

import com.tw.work.model.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据最大停站数过滤
 * Created by Lichao.Wang on 2018/4/8.
 */
public class MaxStopsFilter implements RouteFilter{

    private int maxStop;

    public MaxStopsFilter(int maxStop){
        this.maxStop = maxStop;
    }

    public List<Route> filter(List<Route> routes) {
        List<Route> result = new ArrayList<Route>();

         for (Route route :routes){
            if (route.getRouteNode().size() <= maxStop){
                result.add(route);
            }
        }
        return result;
    }
}
