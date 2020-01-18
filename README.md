# Cyclone Insider
This project is designed to be a messaging board app for Iowa State students and facility to use. Students can subscribe to their “Classrooms” which are forums where students can have discussions relating to the course in question. People affiliated with Iowa State can also post about events happening on campus or anything else as long as it relates to Iowa State. Special permissions are given out to certain people, such as professors.

## Design Decisions
Dagger Dependency Injection:
Using the Google Dagger Dependency injection library, we were able to create services and repositories via abstraction that we can easily test by mocking them.

### MVVM:
Model-View-ViewModel facilitates our seperation of development of the UI. So we can inject our 
services, with dependency injection, into our ViewModel so we have all the business logic inside the ViewModel for easy Test Writing.

### JSON Web Token Authentication:
Also known as JWT, we use this as our basis of authentication. This key is received on the server side. Once validated, the server knows the user that is currently making the request, so we can provide the user with data relevant to them

### Reactive Streams (RxJava):
Based on the Observable-Observer pattern, RxJava allows us to handle asynchronous data easily. For Example, RxJava allows us to de-couple our active network calls in case the view is destroyed before finishing. It also helps with manipulating data so that our UI understands it. RxJava also allows us to easily cache data and send events across our UI without thinking too much.


