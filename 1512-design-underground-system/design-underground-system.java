import java.util.*;

class UndergroundSystem {

    // To store check-in details: id -> (station, time)
    private Map<Integer, Pair> checkInMap;

    // To store route data: "start-end" -> (totalTime, count)
    private Map<String, Stats> routeMap;

    // Pair class for check-in info
    static class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stats class for route info
    static class Stats {
        int totalTime;
        int count;

        Stats(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        checkInMap.remove(id);

        String routeKey = p.station + "-" + stationName;
        int travelTime = t - p.time;

        Stats stats = routeMap.getOrDefault(routeKey, new Stats(0, 0));
        stats.totalTime += travelTime;
        stats.count += 1;

        routeMap.put(routeKey, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "-" + endStation;
        Stats stats = routeMap.get(routeKey);

        return (double) stats.totalTime / stats.count;
    }
}