# Emarsys homework
## Hinkel András, 2017.07.03.

### Description of my thinking


The base unit of the planned holiday route is the `Location` class. This class has the following fields:
* a one letter field called name
* a parent location (this is a location that must be visited after the current Location), this field may contain one Location or may be null
* a set of child locations (locations that must be visited before the current location), this field may be null or may contain any number of child Locations