public class UserAgent {
final String typeSystem; //Windows, macOS или Linux
final String browser; //Edge, Firefox, Chrome, Opera или Safari

    public UserAgent(String userAgent) {
        this.typeSystem = addTypeSystem(userAgent);
        this.browser = addBrowser(userAgent);
    }

    private static String addTypeSystem(String userAgent) {
        String typeSystem = "-";
        if (userAgent.contains("Windows")) {typeSystem="Windows";}
        if (userAgent.contains("Linux")||userAgent.contains("X11")) {typeSystem="Linux";}
        if (userAgent.contains("Mac OS")) {typeSystem="macOS";}
        return typeSystem;
    }
    private static String addBrowser (String userAgent) {
    String lineBrowser = "-";
    if (userAgent.contains("Firefox")){lineBrowser ="Firefox";}
    if (userAgent.contains("Presto")){lineBrowser ="Opera";}
    if (userAgent.contains("Chrome") && userAgent.contains("Safari")){lineBrowser ="Chrome";}
    if (userAgent.contains("Chrome") && userAgent.contains("Safari")&& userAgent.contains("Edg")){lineBrowser ="Edg";}
    if (userAgent.contains("Chrome") && userAgent.contains("Safari")&& userAgent.contains("OPR")){lineBrowser ="Opera";}
    if (userAgent.contains("Version") && userAgent.contains("Safari")){lineBrowser ="Safari";}
    return lineBrowser;
    }

    public String getTypeSystem() {
        return typeSystem;
    }

    public String getBrowser() {
        return browser;
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "typeSystem=" + typeSystem +
                ", browser=" + browser +
                '}';
    }
}
