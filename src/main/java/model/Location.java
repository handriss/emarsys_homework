package model;

import exception.InvalidLocationNameException;
import lombok.Getter;
import lombok.Setter;

public class Location {

    @Getter
    private Character name;

//    A parent comes before the current location
    @Getter
    @Setter
    private Location parent = null;

    public Location(Character name) throws InvalidLocationNameException {
        if (name >= 'a' && name <= 'z') {
            this.name = name;
        }else{
            throw new InvalidLocationNameException("Name must be represented by a lowercase character of the English alphabet!");
        }
    }

    public Location(String name) throws InvalidLocationNameException {

        if(name.length() > 1){
            throw new InvalidLocationNameException("Name must be one character long!");
        }
        else if (!name.matches("[a-z]")) {
            throw new InvalidLocationNameException("Name must be represented by a lowercase character of the English alphabet!");
        }
        else{
            this.name = name.charAt(0);
        }
    }

    public boolean hasParent(){
        return !(this.parent == null);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name=" + name +
                '}';
    }

}
