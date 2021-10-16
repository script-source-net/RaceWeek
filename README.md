# RacingTeam
Eine Factory um den Umgang mit implements und extends zu üben. 
Das Team.Team ist die grösste Abstrakte Instanz von der aus sich alles ableitet.

##Team.Team.Person
abstract class

**extends: Team.Team**

Eine Team.Team.Person ist die Haupt-Abstract-Klasse für die erstellung aller Team.Team-Mitglieder.
Verschiedene Jobs entsprechen jeweils einer eigenen Klasse.

###Team.Team.Driver
**extends: Team.Team.Person**

###Team.Mechanic
**extends: Team.Team.Person**

##Team.Vehicle.Vehicle
abstract class
**extends: Team.Team**

###Team.Vehicle.Truck
**extends Team.Vehicle.Vehicle**

###Team.Vehicle.Vehicle.RacingCar
**extends Team.Vehicle.Vehicle**
