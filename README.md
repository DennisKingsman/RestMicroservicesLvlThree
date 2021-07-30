# Author
## DennisKingsman
# Resources
[mcs-lvl-three](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB)
# Recommended to study
[External sources documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)
# Use 
Spring profiles
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
# Related repository
[mcs-lvl-one-two](https://github.com/DennisKingsman/RestMicroservicesLvlOne)