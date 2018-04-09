package com.tw.work.train;

import com.tw.work.core.QueryCommandBuilder;
import com.tw.work.core.route.*;
import com.tw.work.core.util.Reader;
import com.tw.work.core.view.DistanceView;
import com.tw.work.core.view.TripNumbersView;
import com.tw.work.model.RouteFactory;
import com.tw.work.model.Town;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Lichao.Wang on 2018/4/8.
 */
public class RouteTest {
    static RouteFactory routeFactory;

    @BeforeClass
    public static void testBefore(){
        Reader reader = new Reader();
        try {
            routeFactory = reader.init("/graph");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase1(){
        new QueryCommandBuilder().witwDestination(new Town("C"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("B"),new Town("C"))))
                .witwView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase2(){
        new QueryCommandBuilder().witwDestination(new Town("D"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("D"))))
                .witwView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase3(){
        new QueryCommandBuilder().witwDestination(new Town("C"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("D"),new Town("C"))))
                .witwView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase4(){
        new QueryCommandBuilder().witwDestination(new Town("D"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("E"),new Town("B"),new Town("C"),new Town("D"))))
                .witwView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase5(){
        new QueryCommandBuilder().witwDestination(new Town("D"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("E"),new Town("D"))))
                .witwView(new DistanceView()).build().execute();
    }


    @Test
    public void testCase6(){
        new QueryCommandBuilder().witwDestination(new Town("C"))
                .witwStart(new Town("C"))
                .witwFactory(routeFactory)
                .witwFilter(new MaxStopsFilter(3))
                .witwView(new TripNumbersView()).build().execute();
    }

    @Test
    public void testCase7(){//
        new QueryCommandBuilder().witwDestination(new Town("C"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new ExactlyStopFilter(4))
                .witwView(new TripNumbersView()).build().execute();
    }

    @Test
    public void testCase8(){
        new QueryCommandBuilder().witwDestination(new Town("C"))
                .witwStart(new Town("A"))
                .witwFactory(routeFactory)
                .witwFilter(new ShortestRoute())
                .witwView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase9(){//
        new QueryCommandBuilder().witwDestination(new Town("B"))
                .witwStart(new Town("B"))
                .witwFactory(routeFactory)
                .witwFilter(new ShortestRoute())
                .witwView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase10(){//
        new QueryCommandBuilder().witwDestination(new Town("C"))
                .witwStart(new Town("C"))
                .witwFactory(routeFactory)
                .witwFilter(new DistanceFilter())
                .witwView(new TripNumbersView()).build().execute();
    }
}
