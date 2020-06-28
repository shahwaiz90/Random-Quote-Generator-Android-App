# Random-Quote-Generator-Android-App
This codebase was orignally created for saudi federation of cybersecurity programming and drones for an interview.

Its a random programing quotes application. It takes all sensitive information through gradle properties and then loads up in the bytecode after compiling it. 

# Flow of the app:
 - If internet available, hits the API and save the response in shared preference 
 - If no internet available, shows data from shared preference. If that data is not present then shows place holder message.

# Design Patterns and Libraries Used: 
 - Clean Architecture (SOLID Principles, Seperation of concerns, Easy Testing)
 - MVVM
 - Retrofit2
 - Kotlin
 - Dagger2
 - RxJava
 - Offline and error handling Scenarios (Using Shared preference by storing json object in it)
 - Separate module (networkSdk) for modularity purpose
 
 # Offline and Online Scenarios respectively
 ![Offline Scenario](https://i.ibb.co/mcPjRH7/Screenshot-2020-06-29-at-12-22-11-AM.png)  ![Onine Scenario](https://i.ibb.co/ZzJLLjT/Screenshot-2020-06-29-at-12-23-52-AM.png)
 
