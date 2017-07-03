package model;

import exception.InvalidLocationNameException;

import java.util.Set;

public class Location {

    private Character name;

    //A child az, akinek a jelenlegi node elott kell jonnie
    // I am not sure yet if I need this field
    private Set<Location> children = null;

    private Location parent = null;

    public Location(Character name) throws InvalidLocationNameException {
        if (!(name >= 'a' && name <= 'z')) {
            throw new InvalidLocationNameException("Name must be represented by a lowercase character of the English alphabet!");
        }
    }

    public Location(String name) throws InvalidLocationNameException{

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

    public void setParent(Location parent){
        this.parent = parent;
    }

    public Location getParent(){
        return this.parent;
    }
}
