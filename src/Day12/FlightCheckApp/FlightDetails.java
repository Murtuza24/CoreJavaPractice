package Day12.FlightCheckApp;

import java.time.ZonedDateTime;
import java.util.List;

public class FlightDetails {
    private static String flightNumber;
    private static String startingPoint;
    private static ZonedDateTime departureTime;
    private static String destinations;
    private static ZonedDateTime arrivalTime;
    private static int durations;

    public FlightDetails() {
    }

    public static String getFlightNumber() {
        return flightNumber;
    }

    public static void setFlightNumber(String flightNumber) {
        FlightDetails.flightNumber = flightNumber;
    }

    public static String getStartingPoint() {
        return startingPoint;
    }

    public static void setStartingPoint(String startingPoint) {
        FlightDetails.startingPoint = startingPoint;
    }

    public static String getDestinations() {
        return destinations;
    }

    public static void setDestinations(String destinations) {
        FlightDetails.destinations = destinations;
    }

    public static int getDurations() {
        return durations;
    }

    public static void setDurations(int durations) {
        FlightDetails.durations = durations;
    }

    public static ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public static void setDepartureTime(ZonedDateTime departureTime) {
        FlightDetails.departureTime = departureTime;
    }

    public static ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public static void setArrivalTime(ZonedDateTime arrivalTime) {
        FlightDetails.arrivalTime = arrivalTime;
    }

}
