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
    public String isBot () {
        String isBot = "-";
        if (this.userAgent.contains("compatible")) isBot = "bot";
        if (this.userAgent.contains("okhttp")) isBot = "bot";
        if (this.userAgent.contains("aiohttp")) isBot = "bot";
        if (this.userAgent.contains("Go-NEB")) isBot = "bot";
        if (this.userAgent.contains("bot")) isBot = "bot";
        if (this.userAgent.contains("Bot")) isBot = "bot";
        if (this.userAgent.contains("Feedly")) isBot = "bot";
        if (this.userAgent.contains("RSS")) isBot = "bot";
        if (this.userAgent.contains("FeedBurner")) isBot = "bot";
        if (this.userAgent.contains("SCAN")) isBot = "bot";
        if (this.userAgent.contains("python-requests")) isBot = "bot";
        if (this.userAgent.contains("Feedspot")) isBot = "bot";
        if (this.userAgent.contains("UniversalFeedParser")) isBot = "bot";
        if (this.userAgent.contains("newspaper")) isBot = "bot";
        if (this.userAgent.contains("Buck")) isBot = "bot";
        if (this.userAgent.contains("Blogtrottr")) isBot = "bot";
        if (this.userAgent.contains("CFNetwork")) isBot = "bot";
        if (this.userAgent.contains("Mozilla/5.0 zgrab/")) isBot = "bot";
        if (this.userAgent.contains("facebookexternalhit")) isBot = "bot";
        if (this.userAgent.contains("WordPress")) isBot = "bot";
        if (this.userAgent.contains("Netvibes")) isBot = "bot";
        if (this.userAgent.contains("Microsoft Office Protocol Discovery")) isBot = "bot";
        if (this.userAgent.contains("Citoid")) isBot = "bot";
        if (this.userAgent.contains("ZoteroTranslationServer")) isBot = "bot";
        if (this.userAgent.contains("Iframely")) isBot = "bot";
        if (this.userAgent.contains("Thunderbird")) isBot = "bot";
        if (this.userAgent.contains("FeedDemon")) isBot = "bot";
        if (this.userAgent.contains("Gofeed")) isBot = "bot";
        if (this.userAgent.contains("Vable Ltd admin")) isBot = "bot";
        if (this.userAgent.contains("Faraday")) isBot = "bot";
        if (this.userAgent.contains("Amiga-AWeb")) isBot = "bot";
        if (this.userAgent.contains("curl")) isBot = "bot";
        if (this.userAgent.contains("atVoice")) isBot = "bot";
        if (this.userAgent.contains("restclient-cpp")) isBot = "bot";
        if (this.userAgent.contains("Ktor client")) isBot = "bot";
        if (this.userAgent.contains("WhatsApp/")) isBot = "bot";
        if (this.userAgent.contains("ALittle Client")) isBot = "bot";
        if (this.userAgent.contains("PocketParser")) isBot = "bot";
        if (this.userAgent.contains("Ruby")) isBot = "bot";
        if (this.userAgent.contains("Outlook-iOS")) isBot = "bot";
        if (this.userAgent.contains("FeedFetcher")) isBot = "bot";
        if (this.userAgent.contains("Y!J-DLC")) isBot = "bot";
        if (this.userAgent.contains("Instagram")) isBot = "bot";
        if (this.userAgent.contains("Scrapy")) isBot = "bot";
        if (this.userAgent.contains("p2/mars-sr0")) isBot = "bot";
        if (this.userAgent.contains("Apache-HttpClient")) isBot = "bot";
        if (this.userAgent.contains("Wget")) isBot = "bot";
        if (this.userAgent.equals("(X11)")) isBot = "bot";
        if (this.userAgent.equals("Mozilla/5.0")) isBot = "bot";
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
