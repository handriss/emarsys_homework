import exception.InvalidLocationNameException;
import model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocationNamingTest {

    @Before
    public void setup(){
        System.out.println("Setting up test...");
    }

    @Test
    public void testLocationCreationWithValidNameAsString(){

        try{
            Location location = new Location("a");
            location = new Location("g");
            location = new Location("z");
        }catch(InvalidLocationNameException e){
            Assert.fail();
        }
    }

    @Test
    public void testLocationCreationWithValidNameAsCharacter(){

        try{
            Location location = new Location('a');
            location = new Location('g');
            location = new Location('z');
        }catch(InvalidLocationNameException e){
            Assert.fail();
        }
    }
}
