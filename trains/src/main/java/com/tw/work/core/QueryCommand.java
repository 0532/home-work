package com.tw.work.core;
;

import com.tw.work.model.RouteFactory;
import com.tw.work.model.Town;
import com.tw.work.core.route.RouteFilter;
import com.tw.work.core.view.RouteView;
import com.tw.work.model.Route;
import com.tw.work.model.RouteFactory;
import com.tw.work.model.Town;

import java.util.List;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public class QueryCommand {
    /**
     * 需要执行过滤器u
     */
    private RouteFilter routeFilter;

    /**
     * 视图解析器
     */
    private RouteView routeView;

    private RouteFactory routeFactory;

    private Town start;

    private Town end;

    public QueryCommand(RouteFilter routeFilter, RouteView routeView, RouteFactory routeFactory, Town start, Town end) {
        this.routeFilter = routeFilter;
        this.routeView = routeView;
        this.routeFactory = routeFactory;
        this.start = start;
        this.end = end;
    }

    public void execute(){
        List<Route> allRoutes = routeFactory.getAllRoutes(start,end);
        allRoutes = this.routeFilter.filter(allRoutes);
        System.out.println(routeView.routeViewer(allRoutes));
    }

}
