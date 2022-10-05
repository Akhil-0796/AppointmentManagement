# AppointmentManagement

steps to run the code
-> download the code from https://github.com/Akhil-0796/AppointmentManagement.git 
-> open this code in Editor( IntelliJ or Eclipse)
-> run the AppointmentManagementApplication.java

to verify please visit this swagger url : http://localhost:8080/swagger-ui/index.html where i have exposed all the Rest end points.

ways to hit end points :

1. with postman collection present in target->postmanCollection.
2. with terminal curl commands.
3. with swaggerui.

curl comands:

-> add appointment:

curl --location --request POST 'http://localhost:8080/save-appointment' \
--header 'Content-Type: application/json' \
--data-raw ' {
        "date": "2022-10-02",
        "startTime": "21:05:21.814",
        "duration": 2.5,
        "purpose": "interview"
    }'
    
 
 -> get all appointments :
 
 curl --location --request GET 'http://localhost:8080/getAll'
 
 -> update appointment:
 
 curl --location --request PUT 'http://localhost:8080/update-appointment/2' \
--header 'Content-Type: application/json' \
--data-raw ' {
        "date": "2022-10-04",
        "startTime": "21:05:21.814",
        "purpose": "meeting2",
        "duration" : "3.4"
    }'
    
-> get appointment by id :

curl --location --request GET 'http://localhost:8080/get-by-id/2'

-> get appointments between dates: 

curl --location --request GET 'http://localhost:8080/get-by-date?startDate=2022-10-02&endDate=2022-10-10'

-> delete appointment by id :

curl --location --request DELETE 'http://localhost:8080/delete-by-id/2'

<img width="815" alt="image" src="https://user-images.githubusercontent.com/65871617/194020938-85870adf-824c-4596-9e95-e58461e9b8ea.png">
<img width="810" alt="image" src="https://user-images.githubusercontent.com/65871617/194021075-8a260bbc-62ec-4c38-bc99-429d72b4ad5e.png">
<img width="816" alt="image" src="https://user-images.githubusercontent.com/65871617/194021183-53566cc5-6726-4fc7-8fb0-2a6a8dc93517.png">
<img width="820" alt="image" src="https://user-images.githubusercontent.com/65871617/194021305-604974f6-c45c-41d2-b48f-2f4aead1eacd.png">
<img width="831" alt="image" src="https://user-images.githubusercontent.com/65871617/194021373-4b1ce2dc-9687-4cf1-80f0-88fbf75b22b7.png">
<img width="831" alt="image" src="https://user-images.githubusercontent.com/65871617/194021476-90fb27b1-1859-4c6b-9dc6-1bf333d39331.png">

