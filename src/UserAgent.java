public class UserAgent {
final String typeSystem; //Windows, macOS или Linux
final String browser; //Edge, Firefox, Chrome, Opera или Safari
final String userAgent;
    public UserAgent(String userAgent) {
        this.typeSystem = addTypeSystem(userAgent);
        this.browser = addBrowser(userAgent);
        this.userAgent=userAgent;
    }

    private static String addTypeSystem(String userAgent) {
        String typeSystem = "-";
        if (userAgent.contains("Windows")) {typeSystem="Windows";}
        if (userAgent.contains("Linux")||userAgent.contains("X11")) {typeSystem="Linux";}
        if (userAgent.contains("Mac OS")) {typeSystem="macOS";}
        return typeSystem;
    }
    private static String addBrowser (String userAgent) {
    String lineBrowser = "Другой";
    if (userAgent.contains("Firefox")){lineBrowser ="Firefox";}
    if (userAgent.contains("Gecko/2008070208")){lineBrowser ="Firefox";}
    if (userAgent.contains("FxiOS")){lineBrowser ="Firefox";}
    if (userAgent.contains("GranParadiso")){lineBrowser ="Firefox";}
    if (userAgent.contains("Chrome") && userAgent.contains("Safari")){lineBrowser ="Chrome";}
    if (userAgent.contains("Ubuntu") && userAgent.contains("Chrome")){lineBrowser ="Chrome";}
    if (userAgent.contains("CriOS") && userAgent.contains("Safari")){lineBrowser ="Chrome";}
    if (userAgent.contains("Chrome") && userAgent.contains("Safari")&& userAgent.contains("Edg")){lineBrowser ="Edg";}
    if (userAgent.contains("Chrome") && userAgent.contains("Safari")&& userAgent.contains("OPR")){lineBrowser ="Opera";}
    if (userAgent.contains("OPiOS") && userAgent.contains("Safari")){lineBrowser ="Opera";}
    if (userAgent.contains("Presto")){lineBrowser ="Opera";}
    if (userAgent.contains("Opera/9.02 (Windows NT 5.1; U; en)")){lineBrowser ="Opera";}
    if (userAgent.contains("Opera/5.0 (")){lineBrowser ="Opera";}
    if (userAgent.contains("Version") && userAgent.contains("Safari")){lineBrowser ="Safari";}
    if (userAgent.contains("version") && userAgent.contains("safari")){lineBrowser ="Safari";}
    if (userAgent.contains("GSA") && userAgent.contains("Safari")){lineBrowser ="Safari";}
    if (userAgent.contains("iOS_Browser") && userAgent.contains("Safari")){lineBrowser ="Safari";}
    if (userAgent.contains("Trident") && userAgent.contains("rv")){lineBrowser ="Internet Explorer";}
    if (userAgent.equals("-") ){lineBrowser ="-";}
    return lineBrowser;
    }
    public boolean isBot () {
        boolean isBot = false;
        if (this.userAgent.contains("bot")) isBot = false;
        return isBot;
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
