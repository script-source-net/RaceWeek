# RaceWeek
Eine Factory um den Umgang mit implements und extends zu üben. 

Angefangen hat alles damit das man ein Team & Fahrer definieren kann, diese treten in einem Rennen über n Runden auf einer Strecke mit einem Schwierigkeitsgrad on x gegeneinander an. 

## Die Startaufstellung
Wird Random definiert wobei die Fahrer der TopTeams eine grössere Chance haben auf die vorderen Plätze zu gelanden.

## Events
Während eines Rennens können Events Auftreten, einige müssen einmalig auftreten andere nicht.
### PitStops
Muss Event, jeder Fahrer muss einmal an die Boxen. Die Wahrscheinlichkeit das dies in den ersten Runden des Rennens passiert ist gleich 0, so bis Runde 20 ca haben alle gestoppt. Einige fahren aber vielleicht länger werden aber  10 Runden vor Schluss sicher an die Box gehen.
Ein Pitstop hat einen Platzverlust zur Folge.
- ToDo:PitStops mit variablem Positionsverlust
### Überholmanöver
Es besteht eine Chance x das ein Fahrer einen anderen überholt.
Jeder Fahrer hat einen skill-Wert, dieser in Kombination mit der Schwierigkeit der Strecke definiert ob ein Überholmanöver gelingt.
- TODO: Schreckenschierigkeit Wetterbedingt anpassen.
### Ausfälle
Es besteht eine Chance x das ein Fahrzeug einen technischen Schaden erleidet und der Fahrer ausfällt.
Der Fahrer wird dann im Array DNFArray gelistet und am Ende des Rennens in der Resultattabelle gelistet.

## Endresultat
Das Endresultat listet die platzierten sowie ausgeschiedenen Fahrer nach Platzierung nach der letzten Runde.
