import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class LogEntry {
   final String ipAddr;
   final ZonedDateTime time;
   final HttpMethod method;
   final String path;
   final int respronseCode;
   final int responseSize;
   final String referer;
   final String userAgent;

    public LogEntry(String line) throws ParseException {
        String[] partsIpAddr = line.split(" ");
        this.ipAddr = partsIpAddr[0].trim();
        int firstIndexOftime = Math.max(line.indexOf("["), 0)+1;
        int lastIndexOftime = Math.max(line.indexOf("]"), 0);
        String timeStr = line.substring(firstIndexOftime,lastIndexOftime).trim();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH);
        this.time = ZonedDateTime.parse(timeStr, format);
        int firstIndexOfmethod = Math.max(line.indexOf('"'), 0)+1;
        String lineMethod = line.substring(firstIndexOfmethod).trim();
        String[] partsMethod = lineMethod.split(" ");
        String methodStr = partsMethod[0].trim();
        this.method= HttpMethod.valueOf(methodStr);
        int firstIndexOfpath = Math.max(line.indexOf(" /"), 0);
        int lastIndexOfpath = Math.max(line.indexOf("\" "), 0);
        this.path= line.substring(firstIndexOfpath,lastIndexOfpath).trim();
        String lineCode = line.substring(lastIndexOfpath+1).trim();
        String[] partsCode = lineCode.split(" ");
        String codeStr = partsCode[0].trim();
        this.respronseCode= Integer.parseInt(codeStr);
        String sizeStr = partsCode[1].trim();
        this.responseSize=Integer.parseInt(sizeStr);
        this.referer= partsCode[2].replace("\"","").trim();
        int firstIndexOfuserAgent = Math.max(lineCode.indexOf("\" \""), 0);
        this.userAgent= lineCode.substring(firstIndexOfuserAgent).replace("\"","").trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getRespronseCode() {
        return respronseCode;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public String getReferer() {
        return referer;
    }

    public String getAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "ipAddr=" + ipAddr  +
                ", time=" + time +
                ", method=" + method +
                ", path=" + path  +
                ", respronseCode=" + respronseCode +
                ", responseSize=" + responseSize +
                ", referer=" + referer +
                ", userAgent=" + userAgent +
                '}';
    }
}
