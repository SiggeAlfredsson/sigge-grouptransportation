﻿# sigge-grouptransportation

todo add when vehicle is free, add function to move vehicle, remove route from group

AUTH?


ENDPOINTS
--------------------------------------------------


GET:

groups      /Gets a list of all groups with registered routes, users, vehicles.

route/car+params      /get directions from point a to b.

user      /List of all users

vehicles      /List of all vehicles in db

-------------------

POST:

group     /create a group

car/groupid+params //ex  /route/car/1?origin=Stenungsund&destination=Uddevalla   /Create a car route and add it to a group

user      /create a user

user/userId/groupId     /add a user to a group

vehicle     /create vehicle

vehicle/vehicleId/groupId     /assign vehicle to group

-------------------

DELETE:

group/groupId     

user/userId

user/userId/groupId     /remove a user from a group

vehicle/vehicleId

vehicle/vehicleId/groupId     /remove a vehicle from a group

-------------------

PATCH:

vehicle/use/state(0/1)/vehicleId      /set state if vehicle is free
