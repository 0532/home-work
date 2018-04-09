package com.tw.work.core.view;

import com.tw.work.model.Route;

import java.util.List;

/**
 * 返回路线条数
 * Created by Lichao.Wang on 2018/4/8.
 */
public class TripNumbersView  implements RouteView{


    public Object routeViewer(List<Route> route) {
        if (route==null || route.isEmpty()){
            return DEFAULT_NO_ROUTE;
        }

        return route.size();
    }
}
