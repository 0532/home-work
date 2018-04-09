package com.tw.work.core.route;


import com.tw.work.model.Route;

import java.util.List;

/**
 * 根据特殊条件过滤
 * Created by Lichao.Wang on 2018/4/8.
 */
public interface RouteFilter {

    /**
     * 路线过滤器
     * @param routes
     * @return
     */
    List<Route> filter(List<Route> routes);

}
