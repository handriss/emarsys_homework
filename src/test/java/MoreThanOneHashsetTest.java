import exception.CircularDependencyException;
import exception.InvalidLocationNameException;
import model.Location;
import model.Route;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MoreThanOneHashsetTest {

    @Test
    public void testSeparateSingleLocations() throws InvalidLocationNameException, CircularDependencyException {
        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');
        unsortedLocations.add(location1);

        Location location2 = new Location('b');
        unsortedLocations.add(location2);

        Location location3 = new Location('c');
        unsortedLocations.add(location3);

        Route route = new Route(unsortedLocations);
        route.sortLocations();

        Assert.assertEquals(route.getInterchangeableLocations().size(), 3);

    }

    @Test
    public void testSeparateLinkedLocations() throws InvalidLocationNameException, CircularDependencyException {
        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');
        unsortedLocations.add(location1);

        Location location2 = new Location('b');
        unsortedLocations.add(location2);

        Location location3 = new Location('c');
        location3.setParent(location2);
        unsortedLocations.add(location3);

        Route route = new Route(unsortedLocations);
        route.sortLocations();

        Assert.assertEquals(route.getInterchangeableLocations().size(), 2);

    }
}
