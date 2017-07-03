import exception.InvalidLocationNameException;
import model.Location;
import model.Route;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InvalidLocationNameException {

        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');
        unsortedLocations.add(location1);

        Location location2 = new Location('b');
        unsortedLocations.add(location2);

        Route route = new Route(unsortedLocations);
        route.sortLocations();
    }
}
