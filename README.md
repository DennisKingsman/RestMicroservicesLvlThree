# Author
## DennisKingsman
# Resources
[youtube-guide-mcs-lvl-3](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB)
# Recommended to study
[External sources documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)
# Use 
Spring profiles  
Spring Cloud config server  
# Process
Step 1  
just put the value into property  
Step 2  
put another property file with jar and just run with `java -jar`  
Step 3  
you may try `java -jar config-project-demo-0.0.1-SNAPSHOT.jar --my.greeting="hey from cmd"
`  
Step 4  
Add Spring-actuator to your project and check [config-props](http://localhost:8080/actuator/configprops)  
Step 5  
Achieve environment specific configuration by trying  
```
java -jar config-project-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active= test
```
you can also put @Profile("test") on top of a bean  
Step 6  
Create a spring cloud config server  
# Issues
## Spring cloud config server
If config for spring cloud server is not in the main dir of git repo than it can't find cfg file  
I have created a new repo for application.yml only so it can clone this repo  
You also can use your local git repo  
# Related repository
[application.yml for cfg-server](https://github.com/DennisKingsman/ConfigSpringCloudServer)
[mcs-lvl-one-two](https://github.com/DennisKingsman/RestMicroservicesLvlOne)  
[spring-cloud-config-server]()