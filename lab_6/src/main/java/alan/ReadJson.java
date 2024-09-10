package alan;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;



public class ReadJson {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        FlightData flightData;


        try {
            File file = new File("A:\\Code\\OOP\\Java\\Lab_6\\lab_6\\src\\main\\java\\alan\\flights_data.json");
            flightData = objectMapper.readValue(file, FlightData.class);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose search type: ");
            System.out.println("1. FlightNumber");
            System.out.println("2. Status");
            System.out.println("3. AirLine");
            System.out.println("4. Destination");
            System.out.println("5. DepartureTime");
            System.out.println("6. By time range");
            System.out.println("7. By date");
            System.out.println("8. By arrival range");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            List<Flight> flights = new ArrayList<>();
            switch (choice) {
                case 1:
                    System.out.println("Enter the flight number to search for: ");
                    String flightNumber = scanner.nextLine();
                    flights = FlightsSearch.findFlightsByNumber(flightData, flightNumber);
                    SortFlights.sortFlights(flights);
                    break;
                case 2:
                    System.out.println("Enter the flight status to search for (e.g. 'Delayed'): ");
                    String status = scanner.nextLine();
                    flights = FlightsSearch.findFlightsByStatus(flightData, status);
                    SortFlights.sortFlights(flights);
                    break;
                case 3:
                    System.out.println("Enter the AirLine to search for: ");
                    String airLine = scanner.nextLine();
                    flights = FlightsSearch.findFlightsByAirLine(flightData, airLine);
                    SortFlights.sortFlights(flights);
                    break;
                case 4:
                    System.out.println("Enter the Destination to search for: ");
                    String destination = scanner.nextLine();
                    flights = FlightsSearch.findFlightsByDestination(flightData, destination);
                    SortFlights.sortFlights(flights);
                    break;
                case 5:
                    System.out.println("Enter the DepartureTime to search for: ");
                    String departureTime = scanner.nextLine();
                    flights = FlightsSearch.findFlightsByDepartureTime(flightData, departureTime);
                    SortFlights.sortFlights(flights);
                    break;
                case 6: 
                    System.out.println("Enter the start time in the format: (yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine(), formatter);
                    System.out.println("Enter the end time in the format: (yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine(), formatter);

                    flights = FlightsSearch.findFlightsInTimeRange(flightData, startTime, endTime);
                    SortFlights.sortFlights(flights);
                    break;
                case 7:
                    System.out.println("Enter the date the format: (yyyy-MM-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

                    flights = FlightsSearch.findFlightsByDate(flightData, date);
                    SortFlights.sortFlights(flights);
                    break;
                case 8:
                    System.out.println("Enter the initial arrival time in the format: (yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime arrivalStartTime = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

                    System.out.println("Enter the final arrival time in the format: (yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime arrivalEndTime = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

                    flights = FlightsSearch.findFlightsByArrivalTimeRange(flightData, arrivalStartTime, arrivalEndTime);
                    SortFlights.sortFlights(flights);
                    break;
                default:
                    System.out.println("Wrong choice. Try again");
                    return;
            }


            if (!flights.isEmpty()) {
                System.out.println("\nFinding flights: ");
                for(Flight flight : flights) {
                    System.out.println(flight);
                }
            } else {
                System.out.println("No flights were found for the specified criterion");
            }

        } catch (IOException e) {
            
            System.err.println("An error occurred while reading JSON file -- " + e.getMessage());
        }
    }
}