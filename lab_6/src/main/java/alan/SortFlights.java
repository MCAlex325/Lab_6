package alan;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class SortFlights {
    public static void sortFlights(List<Flight> flights) {
        Collections.sort(flights, new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return f1.getDepartureTime().compareTo(f2.getDepartureTime());
            }
        });
    }
}
