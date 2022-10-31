package co.edu.unipiloto.platVMS.util;

import java.util.Locale;

public class DirectionsHelper {
    private String units;

    public DirectionsHelper(String units){
        this.units = units.toLowerCase();
    }

    public double measureDistance(double lat1, double lon1, double lat2, double lon2){
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (units.equals("km")) {
                dist = dist * 1.609344;
            } else if (units.equals("miles")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}
