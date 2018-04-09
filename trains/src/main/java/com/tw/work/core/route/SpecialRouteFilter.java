package com.tw.work.core.route;



import com.tw.work.model.Edge;
import com.tw.work.model.Route;
import com.tw.work.model.Town;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 仅仅返回指定的路线
 * Created by Lichao.Wang on 2018/4/8.
 */
public class SpecialRouteFilter implements RouteFilter{
    List<Town> townsSeq;

    public SpecialRouteFilter(List<Town> townsSeq){
        this.townsSeq = townsSeq;

    }

    public List<Route> filter(List<Route> routes) {
        for (Route route :routes){
            if (route.getRouteNode().size() != townsSeq.size() -1){
                continue;
            }
            int index = 1;
            for (Edge edge :route.getRouteNode()){
                if (!edge.getTarget().equals(townsSeq.get(index))){
                    break;
                }
                index++;
            }
            if (index == townsSeq.size()){
                return Arrays.asList(route);
            }
        }
        return Collections.EMPTY_LIST;
    }
}
