# RacingTeam
Eine Factory um den Umgang mit implements und extends zu üben. 
Das Team ist die grösste Abstrakte Instanz von der aus sich alles ableitet.

##Person
abstract class

**extends: Team**

Eine Person ist die Haupt-Abstract-Klasse für die erstellung aller Team-Mitglieder.
Verschiedene Jobs entsprechen jeweils einer eigenen Klasse.

###Driver
**extends: Person**

###Mechanic
**extends: Person**

##Vehicle
abstract class
**extends: Team**

###Truck
**extends Vehicle**

###RacingCar
**extends Vehicle**
