package Kata5;

import View.HistogramDisplay;
import View.Histogram;
import java.io.File;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.Locale;

public class Kata5 {

    public static void main(String[] args) throws SQLException {
        SqliteFlightStore flightStore = new SqliteFlightStore(new File("flights.db"));
        Histogram<String> histogram = new Histogram<String>();
        for (Flight flight : flightStore.flights()) 
            histogram.increment(flight.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        new HistogramDisplay("Histogram",histogram).execute();
    }
    
}
