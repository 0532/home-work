package com.tw.work.core.route;

import com.tw.work.model.Route;

import java.util.List;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public class DefaultFilter implements RouteFilter {

    public List<Route> filter(List<Route> routes) {
        return routes;
    }
}
