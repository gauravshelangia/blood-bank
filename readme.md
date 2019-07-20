# auth-wizard

This application contains simple user auth system with spring boot. 

## Requirements
### Install postgresql 
    * `brew install postgres` (Mac OsX command)
    * `brew services start postgresql` (start postgres)
### Setting up user and database with postgres
    * `create user root with encrypted password 'admin';` (create use)
    * `create database blood_bank; (create database);`
    * `grant all privileges on database blood_bank to root;` (grant permission to the user on database auth_wizard)
        
### Deployment
    * clone this repository
    * `cd blodd-bank`
    * `mvn clean install` -- build project
    * populate properties file values
    * cd rest-web
    * `mvn spring-boot:run` -- command to deploy this project
### Verification
    * After deployment, open swagger-ui using endpoint (localhost:8080/blood-bank/swagger-ui.html)
    * In swagger-UI, there are two endpoint all functionality required
              
