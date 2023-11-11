import java.time.Duration;
import java.time.LocalDateTime;

public class Statistics {
    private long totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
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

    public void addEntry (LogEntry log) {
        this.totalTraffic =this.totalTraffic + log.responseSize;
        if (this.minTime==null||this.minTime.isBefore(log.time)) this.minTime=log.time;
        if (this.maxTime==null||this.maxTime.isAfter(log.time)) this.maxTime=log.time;
    }

    public long getTrafficRate () {
        Duration duration = Duration.between(this.maxTime, this.minTime);
        return this.totalTraffic/duration.toHours();
    }
}
