import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Statistics {
    private long totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private final HashSet<String> hashSetRefer = new HashSet<>();
    private final HashMap <String, Integer> hashMapTypeSystem = new HashMap<>();

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

    public HashSet<String> getHashSetRefer() {
        return hashSetRefer;
    }

    public void addEntry (LogEntry log) {
        this.totalTraffic =this.totalTraffic + log.responseSize;
        if (this.minTime==null||this.minTime.isBefore(log.time)) this.minTime=log.time;
        if (this.maxTime==null||this.maxTime.isAfter(log.time)) this.maxTime=log.time;
        if (log.respronseCode==200) this.hashSetRefer.add(log.referer);
        UserAgent ua = new UserAgent(log.userAgent);
        if (!ua.browser.contains("-")&&!hashMapTypeSystem.containsKey(ua.browser)) this.hashMapTypeSystem.put(ua.browser,1);
        if (!ua.browser.contains("-")&&hashMapTypeSystem.containsKey(ua.browser)) this.hashMapTypeSystem.put(ua.browser,hashMapTypeSystem.get(ua.browser)+1);
    }

    public long getTrafficRate () {
        Duration duration = Duration.between(this.maxTime, this.minTime);
        return this.totalTraffic/duration.toHours();
    }
    public HashMap<String, Double> getTypeSystemStatistics () {
    Integer [] intTypeSystem =  hashMapTypeSystem.values().toArray(new Integer [0]);
    String [] strTypeSystem =  hashMapTypeSystem.keySet().toArray(new String [0]);
    int totalIntTypeSystem =0;
    HashMap <String, Double> hashMapTypeSystemStatistics = new HashMap<>();
    for (int i=0;i<intTypeSystem.length;i++) {
        totalIntTypeSystem+=intTypeSystem[i];
    }
    for (int i =0; i<strTypeSystem.length; i++){
    double prosentTypeSystem = (double)hashMapTypeSystem.get(strTypeSystem[i])/totalIntTypeSystem;
    hashMapTypeSystemStatistics.put(strTypeSystem[i],prosentTypeSystem);
    }
    return hashMapTypeSystemStatistics;
    }
}
