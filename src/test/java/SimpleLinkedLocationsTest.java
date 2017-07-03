import exception.CircularDependencyException;
import exception.InvalidLocationNameException;
import model.Location;
import model.Route;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleLinkedLocationsTest {


    @Test
    public void testFewLocationsLinkedInRowInReverseParentOrder() throws InvalidLocationNameException, CircularDependencyException {
        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');
        unsortedLocations.add(location1);

        Location location2 = new Location('b');
        location2.setParent(location1);
        unsortedLocations.add(location2);

        Location location3 = new Location('c');
        location3.setParent(location2);
        unsortedLocations.add(location3);

        Route route = new Route(unsortedLocations);
        route.sortLocations();

        Assert.assertEquals(route.getInterchangeableLocations().size(), 1);

        LinkedList locationsInRow = route.getInterchangeableLocations().iterator().next();
        Assert.assertEquals(locationsInRow.indexOf(location1), 2);
        Assert.assertEquals(locationsInRow.indexOf(location2), 1);
        Assert.assertEquals(locationsInRow.indexOf(location3), 0);

    }

    @Test
    public void testFewLocationsLinkedInRow() throws InvalidLocationNameException, CircularDependencyException {
        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');

        Location location2 = new Location('b');

        Location location3 = new Location('c');

        location2.setParent(location3);
        location1.setParent(location2);

        unsortedLocations.add(location1);
        unsortedLocations.add(location2);
        unsortedLocations.add(location3);

        Route route = new Route(unsortedLocations);
        route.sortLocations();

        Assert.assertEquals(route.getInterchangeableLocations().size(), 1);

        LinkedList locationsInRow = route.getInterchangeableLocations().iterator().next();
        Assert.assertEquals(locationsInRow.indexOf(location1), 0);
        Assert.assertEquals(locationsInRow.indexOf(location2), 1);
        Assert.assertEquals(locationsInRow.indexOf(location3), 2);

    }

}
