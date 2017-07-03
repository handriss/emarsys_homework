package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Route {

    private ArrayList<Location> unsortedLocations;

    private Set<LinkedList> interchangeableLocations = new HashSet<LinkedList>();

    public Route(ArrayList<Location> unsortedLocations){
        this.unsortedLocations = unsortedLocations;
    }

    public void sortLocations(){
        for(Location currentLocation : unsortedLocations){
            this.addLocation(currentLocation);
        }
    }

    private void addLocation(Location location){

        if(this.isLocationAlreadyContained(location)){
            return;
        }

        if(location.hasParent()){
            this.addLocation(location.getParent());
        }

        if(interchangeableLocations.size() == 0){

            LinkedList<Location> currentLinkedList = new LinkedList<Location>();
            currentLinkedList.add(location);

            interchangeableLocations.add(currentLinkedList);
        }

    }

    private boolean isLocationAlreadyContained(Location location){

        for(LinkedList currentLinkedList : interchangeableLocations){
            System.out.println(currentLinkedList);
        }

        return false;
    }

    private boolean isItTheParentOfALocation(Location location){
        for(Location currentLocation : unsortedLocations){
            if(currentLocation.getParent() == location){
                return true;
            }
        }
        return false;
    }
}
