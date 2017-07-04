# Emarsys homework
## Hinkel András, 2017.07.03.


### Overview

I have created this project in Java with Maven. 

### Description of my thinking


The base unit of the planned holiday route is the `Location` class. Each holiday location represents an instance
of this class.

The instances of the `Location` class that are dependent on each other are stored in a LinkedList, for example the 
following three destinations are interdependent and would go into one LinkedList:
* a => b
* b => c
* c

If an instance of a `Location` class has no dependency, it is stored as a LinkedList which has a length of one.

The above LinkedLists are stored inside a Set in the `Route` class. After the locations are ordered, I generate the optimal holiday route by first
iterating through the Set in an outer loop, and through each inner LinkedList in an inner loop, since the order in the Set
is arbitrary, but the order in the inner loop must be kept.


### I have considered these most important corner cases

* If a `Location` occurs more than once in the input data, always the first occurrence is considered
* A `Location` may have more than one parent (a parent is a node that must come before the current node in the order), in
this case I considered the order of the child nodes arbitrary, their order depends on when they show up in the input data,
but the parent always comes before any of them
* There may be circular dependencies between the locations. I specifically test for this before inserting a new
location into its place using [Floyd's cycle-finding algorithm](https://stackoverflow.com/questions/2663115/how-to-detect-a-loop-in-a-linked-list)