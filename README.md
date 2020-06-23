## online-meeting-room-booking-app

#### **Steps for installation & Running the Application:**
1. Create an empty directory
2. In the empty directory-clone the project from https://github.com/ShahinaSk/online-meeting-room-booking-app/tree/v1.0.0
    using command: git clone -b v1.0.0 git@github.com:ShahinaSk/online-meeting-room-booking-app.git
3. In your IDE, import the project as a maven project from the cloned directory.
4. Run mvn clean install to install all the dependencies into your local repository.
5. Run the Spring Boot Application.
6. For Testing the API in Postman use following urls.
    -> To get all the available rooms: 
            http://127.0.0.1:8080/api/v1/app/roomType/buildingName
                                     (or)
            http://127.0.0.1:8080/api/v1/app/roomType/buildingName/floorNumber
        roomType is type of the meeting room: 4-seater or 8-seater (datatype: String)
        buildindName is name of the building we want to book a meeting (data type: String)
        floorNumber is the number of the floor in which you want to book the meeting room(data type: Integer)
                
    -> To book a meeting room : http://127.0.0.1:8080/api/v1/app/roomNumber
            rooomNumber is the meeting room's number you want to book(datatype:Integer)
    -> To cancel a booking: http://127.0.0.1:8080/api/v1/app/bookingId
            bookingId is the booking Id of the meeting room(datatype: Integer)
7. You can also view the swagger API in the url: http://127.0.0.1:8080/swagger-ui.html
         
            