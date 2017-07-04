package model;

import exception.CircularDependencyException;
import lombok.Getter;

import java.util.*;

public class Route {

    @Getter
    private ArrayList<Location> unsortedLocations;

    @Getter
    private ArrayList<Location> sortedLocations = new ArrayList<Location>();

    @Getter
    private Set<LinkedList> interchangeableLocations = new HashSet<LinkedList>();

    public Route(ArrayList<Location> unsortedLocations){
        this.unsortedLocations = unsortedLocations;
    }

    public void sortLocations() throws CircularDependencyException {
        for(Location currentLocation : unsortedLocations){
            this.addLocation(currentLocation);
        }

        for(LinkedList<Location> currentLinkedList : this.interchangeableLocations){
            for(Location currentLocation : currentLinkedList){
                System.out.println(currentLocation);
                this.sortedLocations.add(currentLocation);
            }
        }

    }

    private void addLocation(Location location) throws CircularDependencyException {

        if(this.isLocationAlreadyContained(location)){
            return;
        }

        if(location.hasParent()){
            if(this.checkCircularDependency(location)){
                throw new CircularDependencyException("The Locations in the list are circularly linked!");
            }
            this.addLocation(location.getParent());
        }


        Location firstChild = this.isItTheParentOfALocation(location);
        if(firstChild == null){
            this.insertNewLinkedListNode(location);

        }else{
            LinkedList containingLinkedList = getContainingLinkedList(firstChild);
            Integer index = containingLinkedList.indexOf(firstChild);
            containingLinkedList.add(index, location);
        }

    }

    private void insertNewLinkedListNode(Location location){
        LinkedList<Location> currentLinkedList = new LinkedList<Location>();
        currentLinkedList.add(location);

        interchangeableLocations.add(currentLinkedList);
    }

    private boolean isLocationAlreadyContained(Location location){

        for(LinkedList<Location> currentLinkedList : this.interchangeableLocations){
            for(Location currentLocation : currentLinkedList){
                if(currentLocation == location){
                    return true;
                }
            }
        }
        return false;
    }

    private Location isItTheParentOfALocation(Location location){

        for(LinkedList<Location> currentLinkedList : this.interchangeableLocations){
            for(Location currentLocation : currentLinkedList){
                if(currentLocation == location.getParent()){
                    return currentLocation;
                }
            }
        }
        return null;

    }

    private LinkedList getContainingLinkedList(Location location){
        for(LinkedList currentLinkedList: this.interchangeableLocations){
            if(currentLinkedList.contains(location)){
                return currentLinkedList;
            }
        }
        return null;
    }

    private boolean checkCircularDependency(Location location){

        if(!location.hasParent()){
            return false;
        }

        Location slow, fast;
        slow = fast = location;

        while(true){

            slow = slow.getParent();

            if(slow == null){
                return false;
            }

            if(fast.getParent() == null){
                return false;
            }else if(fast.getParent().getParent() == null){
                return false;
            }else{
                fast = fast.getParent().getParent();
            }

            if(slow == fast){
                return true;
            }
        }
    }

}
