import java.util.HashMap;
import java.util.Set;

public class Hashmap {
    
    public static void genHash() {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Friday", "It's Friday, Friday, Got to get down on Friday...");
        trackList.put("Toxic", " Baby can't you see, I'm calling");
        trackList.put("Hot'n Cold", "You're hot and you're cold, You're yes and you're no...");
        trackList.put("I Don't want to miss a thing", "Watch you smile while you are sleeping");
        String SongLyrics = trackList.get("Toxic");
        System.out.println(SongLyrics);
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println(trackList.get(key));
        }
    }
}
