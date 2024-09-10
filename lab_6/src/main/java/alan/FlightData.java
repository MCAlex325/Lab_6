package alan;

import java.util.List;

class FlightData {
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    @Override
    public String toString() {
        return "FlightData{" +
                "flights=" + flights +
                '}';
    }
}
