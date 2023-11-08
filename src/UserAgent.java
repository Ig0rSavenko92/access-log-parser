public class UserAgent {
final String typeSystem; //Windows, macOS или Linux
//final String browser; //Edge, Firefox, Chrome, Opera, Bot, Feedly

    public UserAgent(String userAgent) {
        String one2PartsTypeSystem = getTypeSystem(userAgent);
        System.out.println(one2PartsTypeSystem);
        String typeSystem = "-";
        if (one2PartsTypeSystem.equals("Windows")) {typeSystem="Windows";
        }
        if (one2PartsTypeSystem.equals("Linux")||one2PartsTypeSystem.equals("X11")) {typeSystem="Linux";
        }
        if (one2PartsTypeSystem.equals("iPad")||one2PartsTypeSystem.equals("Macintosh")||one2PartsTypeSystem.equals("iPhone")) {typeSystem="macOS";
        }
        this.typeSystem = typeSystem;
    }

    private static String getTypeSystem(String userAgent) {
        int firstIndexOtypeSystem = Math.max(userAgent.indexOf("("), 0);
        String lineTypeSystem = userAgent.substring(firstIndexOtypeSystem).trim();
        String[] partsTypeSystem = lineTypeSystem.split(";");
        String onePartsTypeSystem = partsTypeSystem[0].trim().replace("(","");
        String[] parts2TypeSystem = onePartsTypeSystem.split(" ");
        return parts2TypeSystem[0].trim();
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "typeSystem=" + typeSystem +
                '}';
    }
}
