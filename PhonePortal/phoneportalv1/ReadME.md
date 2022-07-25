Description:
 Welcome to my phone portal application. 

Libraries used: 
 SQL database
 Spring Boot
 Spring Web
 Spring JPA
 Devtools
 
Tools used:
 Eclipes 
 
 
Developed by: 
 Eduardo Becerra (Ed)
 Dariel Guerra

Please use the commands below on postman to use the application...

Add new user:
POST 
http://localhost:8085/newuser
	
	{
    "user_name" : "dan pickles",
    "pass_word" : "1234"
	}

**********************************************************
Choose plan:
PUT 
http://localhost:8085/chooseplan/{id}

	{
    "plan_name" : "STANDARD"
	}

**********************************************************
If standard plan chosen:
PUT 
http://localhost:8085/standard/{id}

	{
    "phone_number_1" : 1234567,
    "device_name_1" : "device name"
	}

**********************************************************
If standard plan chosen:
PUT 
http://localhost:8085/family/{id}

	{
    "phone_number_1" : 1234567,
    "device_name_1" : "device name",
    "phone_number_2" : 1234567,
    "device_name_2" : "device name",
    "phone_number_3" : 1234567,
    "device_name_3" : "device name",
    "phone_number_4" : 1234567,
    "device_name_4" : "device name"
	}

**********************************************************
If ultimate plan chosen:
PUT
http://localhost:8085/ultimate/{id}

	{
    "phone_number_1" : 1234567,
    "device_name_1" : "device name"
	}

**********************************************************
Add new user(use to view bill):
GET 
http://localhost:8085/getuser/{id}

**********************************************************
Delete user:
DELETE 
http://localhost:8085/delete/{id}

**********************************************************
NOT IN PRODUCTION
Get all users:
GET
http://localhost:8085/allusers

