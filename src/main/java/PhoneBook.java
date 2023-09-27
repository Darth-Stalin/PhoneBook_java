import java.util.*;

public class PhoneBook {
    static HashMap<String, Integer> pb = new HashMap<>();
    public static void main(String[] args) {
        Map<String, HashSet<String>> map = new HashMap<>();

        updateBook(map, "Арисова Евгения", "852");
        updateBook(map, "Арисова Евгения", "89562");
        updateBook(map, "Арисова Евгения", "7539512");
        updateBook(map, "Шеймов Игорь", "15268");
        updateBook(map, "Шеймов Игорь", "1745689");
        updateBook(map, "Бодулев Сергей","2345678");
        updateBook(map, "Бодулев Сергей","8888888");
        updateBook(map, "Бодулев Сергей","2345678");

        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            HashSet<String> value = entry.getValue();
            System.out.println(key + value);
//            System.out.println();
        }
        pb.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
    private static void updateBook(Map<String, HashSet<String>> map, String key, String value) {
        if (map.containsKey(key)) {
            HashSet<String> oldVal = map.get(key);
            oldVal.add(value);
        } else {
            HashSet<String> newList = new HashSet<>();
            newList.add(value);
            map.put(key, newList);
        }
    }
}