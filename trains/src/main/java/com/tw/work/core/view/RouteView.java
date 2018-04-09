package com.tw.work.core.view;

import com.tw.work.model.Route;

import java.util.List;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public interface RouteView {

    String DEFAULT_NO_ROUTE = "NO SUCH ROUTE";

    /**
     * 根据不同的路径进行选择性的打印
     * @param routes
     * @return 视图对象
     */
    Object routeViewer(List<Route> routes);


}
