# sigge-grouptransportation

microservice to get routes and assign then to groups.

TODO:
Finish RouteController -> addCarRouteToGroup (check comments in class)


ENDPOINTS
--------------------------------------------------


GET:

groups      
|/Gets a list of all groups with registered routes, users, vehicles.

route/car+params   
|/get directions from point a to b.

user    
|/List of all users

vehicles   
|/List of all vehicles in db

-------------------

POST:

group  
|/create a group

car/groupid+params 
|ex  /route/car/1?origin=Stenungsund&destination=Uddevalla   /Create a car route and add it to a group

user 
|/create a user

user/userId/groupId   
|/add a user to a group

vehicle 
|/create vehicle

vehicle/vehicleId/groupId 
|/assign vehicle to group

-------------------

DELETE:

group/groupId     

user/userId

user/userId/groupId  
|/remove a user from a group

vehicle/vehicleId

vehicle/vehicleId/groupId   
|/remove a vehicle from a group

-------------------

PATCH:

vehicle/use/{state}/{time}/vehicleId    
|/set state if vehicle is free, state is 0/1, time is in minutes.

vehicle/{vehicleId}/location/{newLocatiom}    
|/change location of a vehicle
