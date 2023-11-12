import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class Statistics {
    private long totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private final HashSet<String> hashSetRefer200 = new HashSet<>();
    private final HashSet<String> hashSetRefer404 = new HashSet<>();
    private final HashMap <String, Integer> hashMapTypeSystem = new HashMap<>();
    private final HashMap <String, Integer> hashMapBrowser = new HashMap<>();

    public Statistics() {
    }

    public long getTotalTraffic() {
        return totalTraffic;
    }

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    public HashSet<String> getHashSetRefer200() {
        return hashSetRefer200;
    }

    public HashSet<String> getHashSetRefer404() {
        return hashSetRefer404;
    }

    public void addEntry (LogEntry log) {
        this.totalTraffic =this.totalTraffic + log.responseSize;
        if (this.minTime==null||this.minTime.isBefore(log.time)) this.minTime=log.time;
        if (this.maxTime==null||this.maxTime.isAfter(log.time)) this.maxTime=log.time;
        if (!log.referer.equals("-")&&log.respronseCode==200) this.hashSetRefer200.add(log.referer);
        if (!log.referer.equals("-")&&log.respronseCode==404) this.hashSetRefer404.add(log.referer);
        UserAgent ua = new UserAgent(log.userAgent);
        if (!ua.typeSystem.equals("-")&&!hashMapTypeSystem.containsKey(ua.typeSystem)) this.hashMapTypeSystem.put(ua.typeSystem,1);
        if (!ua.typeSystem.equals("-")&&hashMapTypeSystem.containsKey(ua.typeSystem)) this.hashMapTypeSystem.put(ua.typeSystem,hashMapTypeSystem.get(ua.typeSystem)+1);
        if (!ua.browser.equals("-")&&!hashMapBrowser.containsKey(ua.browser)) this.hashMapBrowser.put(ua.browser,1);
        if (!ua.browser.equals("-")&&hashMapBrowser.containsKey(ua.browser)) this.hashMapBrowser.put(ua.browser,hashMapBrowser.get(ua.browser)+1);
    }

    public long getTrafficRate () {
        Duration duration = Duration.between(this.maxTime, this.minTime);
        return this.totalTraffic/duration.toHours();
    }
    public HashMap<String, Double> getTypeSystemStatistics () {
        Integer [] intTypeSystem = hashMapTypeSystem.values().toArray(new Integer [0]);
        String [] strTypeSystem =  hashMapTypeSystem.keySet().toArray(new String [0]);
        int totalIntTypeSystem =0;
        HashMap <String, Double> hashMapTypeSystemStatistics = new HashMap<>();
        for (Integer i : intTypeSystem) {
            totalIntTypeSystem += i;
        }
        for (String s : strTypeSystem) {
            double prosentTypeSystem = (double) hashMapTypeSystem.get(s) / totalIntTypeSystem;
            hashMapTypeSystemStatistics.put(s, prosentTypeSystem);
        }
    return hashMapTypeSystemStatistics;
    }
    public HashMap<String, Double> getBrowserStatistics () {
        Integer [] intBrowser =  hashMapBrowser.values().toArray(new Integer [0]);
        String [] strBrowser =  hashMapBrowser.keySet().toArray(new String [0]);
        int totalIntBrowser =0;
        HashMap <String, Double> hashMapBrowserStatistics = new HashMap<>();
        for (Integer i : intBrowser) {
            totalIntBrowser += i;
        }
        for (String s : strBrowser) {
            double prosentTypeSystem = (double) hashMapBrowser.get(s) / totalIntBrowser;
            hashMapBrowserStatistics.put(s, prosentTypeSystem);
        }
        return hashMapBrowserStatistics;
    }
}
