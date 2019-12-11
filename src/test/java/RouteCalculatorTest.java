import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        Line line1 = new Line(1,"Первая");
        Line line2 = new Line(2,"Вторая");

        route.add(new Station("Пушкинская", line1));
        route.add(new Station("Московская", line1));
        route.add(new Station("Горьковская", line2));
        route.add(new Station("Пермская", line2));
        route.add(new Station("Екатерининская", line2));

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected,actual);
    }

    public void testGetShortestRoute() {
        Line line1 = new Line(1,"линия1");
        Line line2 = new Line(2,"линия2");
        Line line3 = new Line(3,"линия3");
        Station station11 = new Station("первая1",line1);
        Station station12 = new Station("первая2",line1);
        Station station13 = new Station("первая3",line1);
        Station station21 = new Station("вторая1",line2);
        Station station22 = new Station("вторая2",line2);
        Station station23 = new Station("вторая3",line2);
        Station station31 = new Station("третья1",line3);
        Station station32 = new Station("третья2",line3);
        Station station33 = new Station("третья3",line3);
        StationIndex stationIndex = new StationIndex();
        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        line2.addStation(station21);
        line2.addStation(station22);
        line2.addStation(station23);
        line3.addStation(station31);
        line3.addStation(station32);
        line3.addStation(station33);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        List<Station> conList1 = new ArrayList<>();
        conList1.add(station11);
        conList1.add(station21);
        stationIndex.addConnection(conList1);
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        List<Station> actual = new ArrayList<>();
        actual.addAll(routeCalculator.getShortestRoute(station12,station22));
        List<Station> expected = new ArrayList<>();
        expected.add(station12);
        expected.add(station11);
        expected.add(station21);
        expected.add(station22);

        assertEquals(expected,actual);
    }
    public void testGetShortestRouteTwo() {
        Line line1 = new Line(1, "линия1");
        Line line2 = new Line(2, "линия2");
        Line line3 = new Line(3, "линия3");
        Station station11 = new Station("первая1", line1);
        Station station12 = new Station("первая2", line1);
        Station station13 = new Station("первая3", line1);
        Station station21 = new Station("вторая1", line2);
        Station station22 = new Station("вторая2", line2);
        Station station23 = new Station("вторая3", line2);
        Station station31 = new Station("третья1", line3);
        Station station32 = new Station("третья2", line3);
        Station station33 = new Station("третья3", line3);
        StationIndex stationIndex = new StationIndex();
        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        line2.addStation(station21);
        line2.addStation(station22);
        line2.addStation(station23);
        line3.addStation(station31);
        line3.addStation(station32);
        line3.addStation(station33);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station21);
        stationIndex.addStation(station22);
        stationIndex.addStation(station23);
        stationIndex.addStation(station31);
        stationIndex.addStation(station32);
        stationIndex.addStation(station33);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        List<Station> conList1 = new ArrayList<>();
        conList1.add(station11);
        conList1.add(station21);
        stationIndex.addConnection(conList1);
        List<Station> conList2 = new ArrayList<>();
        conList2.add(station23);
        conList2.add(station32);
        stationIndex.addConnection(conList2);
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        List<Station> actual = new ArrayList<>();
        actual.addAll(routeCalculator.getShortestRoute(station12, station33));
        List<Station> expected = new ArrayList<>();
        expected.add(station12);
        expected.add(station11);
        expected.add(station21);
        expected.add(station22);
        expected.add(station23);
        expected.add(station32);
        expected.add(station33);

        assertEquals(expected, actual);
    }

    }
