import java.util.HashMap;
import java.util.Map;

public class Route {
    private static final Map<Character, Integer> distances = new HashMap<>();

    static {
        int distance = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            distances.put(c, distance);
            distance += 20;
        }
    }

    private void travel() {

    }
}
