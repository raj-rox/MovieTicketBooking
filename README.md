# MovieTicketBooking
A simple Movie Ticket Booking App created on Java with admin interface to add movies, theaters and shows.
Created by Parth Shah, Maulik Shah and Raj Shah.
//Change MySQL Database Settings before running the app.

Software Used: Java Netbeans, mySQL Database.
Project Description:
We have created 7 forms:
1.	Login
2.	Register
3.	User Home
4.	Ticket Booking
5.	Booking History
6.	Receipt
7.	Admin Home
Our main aim with this project was to make our application as user-friendly and visually appealing as possible, keeping in mind real world movie booking application structures.
We have used panels for distinction in layout, buttons for action calls, labels, text fields, password fields, separators, date pickers and have extensively used images in labels for a clean and beautiful user interface.
The application starts with a login, where you have options of registering or logging in, each having a dedicated page to themselves. For sign up, the name, username and password are taken as input from a text field into the database table called ‘user’. Further, you login with the same details, and the database cross verifies your identity for matching username and password. On a successful login, the user home page opens, from where the user may choose to book a new movie, view their booking history, or add money to the wallet. If the user chooses to book a new movie, he is taken to the movie booking page, where a movie choice is given, and the available shows, according to the chosen movie, are displayed. If the user has a sufficient wallet balance, then a movie is booked, receipt is displayed, and the entry is made in the database. 
 
Data is pulled from the database and displayed in a tabular for in the movie history page. We have also created an Admin home page, form where an administrator may add new movies, new theatres, or new shows.
We have extensively applied form validation for empty input fields, username-password mismatches, and duplicate entries of username, movies or theatres.
Throughout the project, a very close tie up to the database is maintained for all the application data like user details, movie booking details, show details, etc.
