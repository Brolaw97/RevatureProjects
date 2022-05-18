# PROJECT TWO

## Project Description

A Avatar the Last Airbender themed Social media platform

## Technologies Used

*  PostgreSQL
*  Java
*  Spring Boot
*  Spring Data
*  Spring Security
*  Spring Mail
*  HTML
*  JavaScript
*  JUnit 
*  AWS EC2 
*  AWS S3
*  AWS RDS

## Features

* Create an account on the platform, make posts, and see other people's posts.
* Reset your password from an email response
* Upload pictures to profile and posts

To-do list:
* Do more testing
* Make a working search functionality

## Getting Started
   
- git clone https://github.com/Brolaw97/RevatureProjects.git
- Import the Maven Project into a Java IDE such as Spring Tools Suite
- Configure your application.yml variables to your specifications
   - Add in the url, username, and password for your database
   - Add the username and password for an email for the email service
   - Add the access key and secret key for your S3 log in for photo handling
- Either set up a cloud computing server or launch on your localhost
- Depending on which option chosen above, Do one of the following:
   - On the JS files for AJAX requests, change the url for the requests to match your server IP address
   - On the JS files for AJAX requests, change the url for the requests to localhost instead of an IP adress

## Usage

- Once the server is set up, you can run it as a Spring Boot Application
- Go to the port 9099 on the server you set up and it will take you to the log in page
- From this page you can register an account by clicking on the register account button
- Once registered, it will redirect back to the log in page where you can now log in
- Once logged in, you can now access and view the home page
- On the home page, you can update your profile, make posts, choose a bending style, and view posts by yourself and anyone else on the server / in the database
- You can log out of the page, invalidating the session, and with the security you will not be able to go back to the main page without logging in again
- Back on the log in page, you can now choose to reset your password. It will ask for an email, if the email entered is in the database it will reset the password to a temporary one. It will then send an email to the email entered with the temporary password. The page will redirect to a password reset field.
- On the password reset field, it will ask for your email, the temporary password, and your new password. Once the fields have been submitted, it will update accordingly and redirect to the login page once again.

## Contributors

> Jake Rowe
> Frederick Doell
> Ramzy Malak
