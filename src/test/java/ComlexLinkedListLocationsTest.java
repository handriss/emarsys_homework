import exception.CircularDependencyException;
import exception.InvalidLocationNameException;
import model.Location;
import model.Route;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.LinkedList;

public class ComlexLinkedListLocationsTest {

    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testLocationsWithTheSameParent() throws InvalidLocationNameException, CircularDependencyException {
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

    @Test
    public void testCircularDependency() throws InvalidLocationNameException {
        ArrayList<Location> unsortedLocations = new ArrayList<Location>();

        Location location1 = new Location('a');
        Location location2 = new Location('b');
        Location location3 = new Location('c');
        Location location4 = new Location('d');

        location1.setParent(location2);
        location2.setParent(location3);
        location3.setParent(location4);
        location4.setParent(location1);

        unsortedLocations.add(location1);
        unsortedLocations.add(location2);
        unsortedLocations.add(location3);
        unsortedLocations.add(location4);

        Route route = new Route(unsortedLocations);

        try{
            route.sortLocations();
        }catch(CircularDependencyException e){
            expectedException.expect(CircularDependencyException.class);
        }

    }
}
