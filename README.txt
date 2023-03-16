Railway Infrastructure Logistics Simulator

This is an application designed to simulate and maintain the logistics of railway infrastructure, including railway stations, connections, line intersections, and different train implementations.

This application provides the following functionalities:

    Creating new locomotives, railroad cars, railway stations, and connections between stations from the menu
    Attaching a railroad car to a locomotive
    Loading people/cargo onto railroad cars
    Removing objects from the simulation
    Displaying a report containing all basic information about a trainset
    Displaying % of the distance completed between the starting and destination railway stations
    Displaying a summary of information about railroad cars and the number of people based on the goods transported
    Displaying % of the distance completed between the nearest railway stations on your route
    Listing all existing trainsets automatically added to the AppState.txt file every 5 seconds
    Collision prevention in which a maximum of one trainset can move between two stations.
    Trainset stops at every station it encounters and waits 2 seconds. After reaching the destination station, the trainset waits for 30 seconds and then the train starts its return journey.
    Trainset movement along routes determined according to the indicated objects of the starting and destination railway station. The route between the railway stations must be determined each time algorithmically on the basis of the graph of railway connections.
    When the trainset exceeds the speed of 200km/h, the application must inform the user with an appropriate message on the console in the form of an exception of the type RailroadHazard.
    Careful and correct synchronization of all threads must be ensured.

To run the application, the user needs to execute the Presentation.java file. This file contains a main method that provides examples of each of the functionalities mentioned above.
The application requires the creation of at least 100 railway stations with connections between them and 25 trainsets (with randomly 5-10 railroad cars each).
All exceptions are handled and communicated to the user with appropriate messages without the need to interrupt and restart the application.
This application is designed using Java programming language, Thread class, and appropriate synchronization techniques.
