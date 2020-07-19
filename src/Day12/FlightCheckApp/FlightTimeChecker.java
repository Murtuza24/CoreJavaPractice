package Day12.FlightCheckApp;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightTimeChecker {

    static List<FlightDetails> flightDetailsArrayList = new ArrayList<>();

//    FlightDetails flightDetails;

    static List<FlightDetails> filteredFlights;

    public static void main(String[] args) {

        setFlightsData();

        System.out.println("Enter From:");
        Scanner sc = new Scanner(System.in);
        String startPoint = sc.nextLine();


        System.out.println(flightDetailsArrayList.toString());

        getFiltered(startPoint);

    }

    private static void getFiltered(String startPoint) {
        filteredFlights = flightDetailsArrayList.stream()
                .filter(flight -> flight.getStartingPoint().toLowerCase().contains(startPoint))
                .collect(Collectors.toList());

        System.out.println(filteredFlights.toString());
//        for (FlightDetails fl : filteredFlights) {
//            System.out.println(fl.getStartingPoint());
//        }

        filteredFlights.forEach(fDetails -> System.out.println(FlightDetails.getStartingPoint()));
    }

    private static void setFlightsData() {
        FlightDetails flightDetails = new FlightDetails();
        flightDetails.setFlightNumber("EK513");
        flightDetails.setDurations(1650);

        flightDetails.setStartingPoint("Dallas Fort Worth, DFW");
        LocalDateTime leaving = LocalDateTime.of(2020, Month.JULY, 20, 7, 30);
        ZoneId zoneId = ZoneId.of("America/Chicago");
        ZonedDateTime departureTime = ZonedDateTime.of(leaving, zoneId);
        flightDetails.setDepartureTime(departureTime);

        flightDetails.setDestinations("Bombay, BOM");
        ZoneId zoneId2 = ZoneId.of("Asia/Kolkata");
        ZonedDateTime arrivalTime = departureTime.withZoneSameInstant(zoneId2).plusMinutes(flightDetails.getDurations());
        flightDetails.setArrivalTime(arrivalTime);

        System.out.println(flightDetails.getStartingPoint());
        System.out.println(flightDetails.getDepartureTime());
        System.out.println(flightDetails.getDestinations());
        System.out.println(flightDetails.getArrivalTime());
        flightDetailsArrayList.add(flightDetails);

        /////////////////////////////////////
        System.out.println("\n ------------------------------------");

        flightDetails = new FlightDetails();
        flightDetails.setFlightNumber("EK510");
        flightDetails.setDurations(1800);

        flightDetails.setStartingPoint("Los Angeles, LAX");
        leaving = LocalDateTime.of(2020, Month.JULY, 20, 19, 30);
        zoneId = ZoneId.of("America/Los_Angeles");
        departureTime = ZonedDateTime.of(leaving, zoneId);
        flightDetails.setDepartureTime(departureTime);

        flightDetails.setDestinations("Bombay, BOM");
        zoneId2 = ZoneId.of("Asia/Kolkata");
        arrivalTime = departureTime.withZoneSameInstant(zoneId2).plusMinutes(flightDetails.getDurations());
        flightDetails.setArrivalTime(arrivalTime);

        System.out.println(flightDetails.getStartingPoint());
        System.out.println(flightDetails.getDepartureTime());
        System.out.println(flightDetails.getDestinations());
        System.out.println(flightDetails.getArrivalTime());
        flightDetailsArrayList.add(flightDetails);


    }
}
