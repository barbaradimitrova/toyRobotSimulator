# Toy Robot Simulator 

Assumptions:
1. Each command is send to the application's REST API via Post Method
2. When "Report" command is send, output in the console is acceptable
3. Illegal Argument Exception is thrown only in a case of synthax error or invalid command, which results in a 400 Bad Request Response 
4. Each set of commands is run on a newly started application

TestCases in the Challenge are represented in the GameAppTest.java
Endpoint Integration test with mocked GameApp response is shown in EndpointIntegrationTest.java

Authowired and Beans annotation is used for SpringBoot set up. 
