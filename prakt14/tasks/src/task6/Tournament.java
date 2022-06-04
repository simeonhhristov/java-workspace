package task6;

import java.util.*;

public class Tournament {
    public static void main(String[] args) {
        TreeMap<String,String> teams = new TreeMap<>();

        teams.put("San Francisco", "Forty-niners");
        teams.put("Chicago", "Bears");
        teams.put("Denver", "Broncos");
        teams.put("Seattle", "Seahawks");
        teams.put("Miami", "Dolphins");
        teams.put("Detroit", "Lions");

        System.out.printf("Size: %d, Chicago's team: %s\n", teams.size(), teams.get("Chicago"));

        teams.put("San Francisco", "Niners");

        System.out.printf("Is San Diego registered?: %s", teams.containsKey("San Diego")); ;

        teams.remove("Denver");

        teams.put("Dallas", "Cowboys");

        Set<String> keys = teams.keySet();
        for (String key : keys){
            System.out.println(teams.get(key));
        }

        List<Map.Entry<String, String>> entryList = new ArrayList<>(teams.entrySet()) ;
        Collections.sort(entryList, Map.Entry.comparingByValue());
        Collections.reverse(entryList);
    }
}
