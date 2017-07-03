import exception.InvalidLocationNameException;
import model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LocationNamingTest {

    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup(){
        System.out.println("Setting up test...");
    }

    @Test
    public void testLocationCreationWithValidName(){

        try{
            Location location = new Location("a");
            location = new Location("g");
            location = new Location("z");

            location = new Location("a");
            location = new Location("h");
            location = new Location("z");
        }catch(InvalidLocationNameException e){
            Assert.fail();
        }
    }

    @Test
    public void testLocationCreationWithInvalidName(){
        int i = 0;
        Location location;

        try{
            location = new Location("0");
        }catch(InvalidLocationNameException e){
            i++;
        }

        try{
            location = new Location('0');
        }catch(InvalidLocationNameException e){
            i++;
        }

        try{
            location = new Location("A");
        }catch(InvalidLocationNameException e){
            i++;
        }

        try{
            location = new Location('A');
        }catch(InvalidLocationNameException e){
            i++;
        }

        try{
            location = new Location("$");
        }catch(InvalidLocationNameException e){
            i++;
        }

        try{
            location = new Location('$');
        }catch(InvalidLocationNameException e){
            i++;
        }

        Assert.assertEquals(i, 6);
    }

    @Test
    public void testLocationCreationWithLongName(){
        try{
            Location location = new Location("absd");
            Assert.fail();
        }catch(InvalidLocationNameException e){
            expectedException.expect(InvalidLocationNameException.class);
        }
    }
}
