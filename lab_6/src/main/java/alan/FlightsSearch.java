package alan;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightsSearch {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public static List<Flight> findFlightsByNumber(FlightData flightData, String flightNumber) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsByStatus(FlightData flightData, String status) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            if (flight.getStatus().equalsIgnoreCase(status)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsByAirLine(FlightData flightData, String airLine) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            if (flight.getAirline().equalsIgnoreCase(airLine)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsByDestination(FlightData flightData, String destination) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsByDepartureTime(FlightData flightData, String departureTime) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            if (flight.getDepartureTime().equalsIgnoreCase(departureTime)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsInTimeRange(FlightData flightData, LocalDateTime startTime, LocalDateTime endTime) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            LocalDateTime departureTime = LocalDateTime.parse(flight.getDepartureTime(), formatter);
            LocalDateTime arrivalTime = LocalDateTime.parse(flight.getArrivalTime(), formatter);

            if((departureTime.isAfter(startTime) || departureTime.isEqual(startTime)) && 
            (departureTime.isBefore(endTime) || departureTime.isEqual(endTime)) ||
            (arrivalTime.isAfter(startTime) || arrivalTime.isEqual(startTime)) && 
            (arrivalTime.isBefore(endTime) || arrivalTime.isEqual(endTime))) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsByDate(FlightData flightData, LocalDate date) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            LocalDate departureDate = LocalDateTime.parse(flight.getDepartureTime(), dateTimeFormatter).toLocalDate();
            LocalDate arrivalDate = LocalDateTime.parse(flight.getArrivalTime(), dateTimeFormatter).toLocalDate();

            if (departureDate.equals(date) || arrivalDate.equals(date)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public static List<Flight> findFlightsByArrivalTimeRange(FlightData flightData, LocalDateTime arrivalStartTime, LocalDateTime arrivalEndTime) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightData.getFlights()) {
            LocalDateTime arrivalTime = LocalDateTime.parse(flight.getArrivalTime(), dateTimeFormatter);

            if ((arrivalTime.isAfter(arrivalStartTime) || arrivalTime.isEqual(arrivalStartTime)) &&
            (arrivalTime.isBefore(arrivalEndTime) || arrivalTime.isEqual(arrivalEndTime))) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

}
