package com.tw.work.core;


import com.tw.work.core.route.RouteFilter;
import com.tw.work.core.view.RouteView;
import com.tw.work.model.RouteFactory;
import com.tw.work.model.Town;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public class QueryCommandBuilder {

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


    public QueryCommandBuilder witwFilter(RouteFilter routeFilter){
        this.routeFilter = routeFilter;
        return this;
    }

    public QueryCommandBuilder witwView(RouteView routeView){
        this.routeView = routeView;
        return this;
    }

    public QueryCommandBuilder witwFactory(RouteFactory routeFactory){
        this.routeFactory = routeFactory;
        return this;
    }

    public QueryCommandBuilder witwStart(Town town){
        this.start = town;
        return this;
    }

    public QueryCommandBuilder witwDestination(Town town){
        this.end = town;
        return this;
    }

    public QueryCommand build(){
        if (routeFilter == null){
            throw new IllegalStateException("routeFilter may not be null");
        }
        if (routeView == null){
            throw new IllegalStateException("routeView may not be null");
        }
        if (routeFactory == null){
            throw new IllegalStateException("routeFactory may not be null");
        }
        if (start == null){
            throw new IllegalStateException("start may not be null");
        }
        if (end == null){
            throw new IllegalStateException("end may not be null");
        }

        return new QueryCommand(this.routeFilter,this.routeView,this.routeFactory,this.start,this.end);
    }
}
