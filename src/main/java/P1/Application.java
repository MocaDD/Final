package P1;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {
        HashMap<String, String> hashMap1 = new HashMap<>();
        HashMap<String, String> hashMap2 = new HashMap<>();

        hashMap1.put("Smith", "949–0504");
        hashMap1.put("Marty", "206–9024");
        hashMap2.put("Marty", "206–9024");
        hashMap2.put("Hawking", "123–4567");
        hashMap2.put("Smith", "949–0504");
        hashMap2.put("Newton", "123– 4567");

        System.out.println(isSubMap(hashMap1, hashMap2));
    }

    private static boolean isSubMap(HashMap<String, String> hashMap1, HashMap<String, String> hashMap2) {

        int result;
        int index = 0;

        if (hashMap1.size() == 0) {
            return true;
        }

        for (String key : hashMap1.keySet()) {
            if (hashMap2.containsKey(key)) {
                result = hashMap2.get(key).compareTo(hashMap1.get(key));
                if (result == 0) {
                    index++;
                }
            }
        }

        if (index == hashMap1.size()) {
            return true;
        } else {
            return false;
        }
    }
}