import exception.InvalidLocationNameException;
import model.Location;
import model.Route;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ComlexLinkedListLocationsTest {

    @Test
    public void testLocationsWithTheSameParent() throws InvalidLocationNameException {
        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');
        Location location2 = new Location('b');
        Location location3 = new Location('c');
        Location location4 = new Location('d');

        location2.setParent(location1);
        location3.setParent(location1);
        location4.setParent(location2);

        unsortedLocations.add(location1);
        unsortedLocations.add(location2);
        unsortedLocations.add(location3);
        unsortedLocations.add(location4);

        Route route = new Route(unsortedLocations);
        route.sortLocations();

        LinkedList locationsInRow = route.getInterchangeableLocations().iterator().next();
        Assert.assertEquals(locationsInRow.indexOf(location1), 3);
        Assert.assertEquals(locationsInRow.indexOf(location4), 0);

//        Since location2 and location3 has the same parent they may be at the 1st or 2nd index in the array
        Assert.assertEquals(locationsInRow.indexOf(location2) + locationsInRow.indexOf(location3), 3);
    }
}
