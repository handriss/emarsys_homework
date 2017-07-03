import exception.InvalidLocationNameException;
import model.Location;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class RouteOptimizer {

    @Before
    public void setup(){
        System.out.println("Setting up test...");
    }

    @Test
    public void testLocationCreationWithValidName(){

        try{
            Location location = new Location("a");
            return;
        }catch(InvalidLocationNameException e){
            fail();
        }
    }
}
