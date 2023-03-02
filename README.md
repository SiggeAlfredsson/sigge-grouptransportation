# sigge-grouptransportation

todo add when vehicle is free, add function to move vehicle, remove route from group

AUTH?


ENDPOINTS
--------------------------------------------------


GET:

group

getroute+params

user

vehicle

-------------------

POST:

group

groups/groupid/routes // create route, change endpoint add delete

user

user/userId/groupId

vehicle

vehicle/vehicleId/groupId

-------------------

DELETE:

channel/groupId    // change to group ?

user/userId

user/userId/groupId

vehicle/vehicleId

vehicle/vehicleId/groupId

-------------------

PATCH:

vehicle/use/state(0/1)/vehicleId
