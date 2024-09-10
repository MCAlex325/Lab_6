package alan;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {

    @JsonProperty("FlightNumber")
    private String flightNumber;
    @JsonProperty("Airline")
    private String airline;
    @JsonProperty("Destination")
    private String destination;
    @JsonProperty("DepartureTime")
    private String departureTime;
    @JsonProperty("ArrivalTime")
    private String arrivalTime;
    @JsonProperty("Gate")
    private String gate;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Duration")
    private String duration;
    @JsonProperty("AircraftType")
    private String aircraftType;
    @JsonProperty("Terminal")
    private String terminal;



    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return " Flight \n {\n" +
                " flightNumber='" + flightNumber + '\'' +
                ",\n airline='" + airline + '\'' +
                ",\n destination='" + destination + '\'' +
                ",\n departureTime='" + departureTime + '\'' +
                ",\n arrivalTime='" + arrivalTime + '\'' +
                ",\n gate='" + gate + '\'' +
                ",\n status='" + status + '\'' +
                ",\n duration='" + duration + '\'' +
                ",\n aircraftType='" + aircraftType + '\'' +
                ",\n terminal='" + terminal + '\'' +
                "\n }";
    }
    public String getFlightNumber() {
        return flightNumber;
    }
}