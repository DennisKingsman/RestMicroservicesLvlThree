# Author
## DennisKingsman
# Resources
[youtube-guide-mcs-lvl-3](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB)
# Recommended to study
## Common
[12factor.net](https://12factor.net/)  
[External sources documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)  
## Accumulation(May not apply to this project)
### RestTemplate
[rest-template](https://www.baeldung.com/rest-template)  
[doc-restTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
### Jms
[spring-jms](https://www.baeldung.com/spring-jms)  
[doc-jmsTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jms/core/JmsTemplate.html)  
[doc-jmsListener](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jms/annotation/JmsListener.html)  
[doc-mqQ](https://www.ibm.com/docs/en/ibm-mq/8.0?topic=jms-mqqueue)
### Reactive web
[reactor-core](https://www.baeldung.com/reactor-core)  
[spring-webflux](https://www.baeldung.com/spring-webflux)  
[docs-web-reactive](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)  
[mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)  
[flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)
### WebClient 
[docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html)  
[spring-5-webclient](https://www.baeldung.com/spring-5-webclient)
### Kafka
[docs.spring.io/spring-kafka](https://docs.spring.io/spring-kafka/reference/html/)  
[baeldung.com/spring-kafka](https://www.baeldung.com/spring-kafka)  
[spring-kafka](https://spring.io/projects/spring-kafka)  
[spring-boot-kafka-testing](https://www.baeldung.com/spring-boot-kafka-testing)  
[docs-kafkaTemplate](https://docs.spring.io/spring-kafka/api/org/springframework/kafka/core/KafkaTemplate.html)  
[spring-kafka-reference](https://docs.spring.io/spring-kafka/docs/1.1.2.RELEASE/reference/html/_reference.html)  
## Spring Cloud 
[spring-cloud-config](https://cloud.spring.io/spring-cloud-config/reference/html/)  
[Customizing the Bootstrap Property Sources](https://projects.spring.io/spring-cloud/spring-cloud.html)  
[spring-cloud-bootstrapping](https://www.baeldung.com/spring-cloud-bootstrapping)  
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
Create a spring cloud config server and a spring cloud config client  
Add `@RefreshScope` into bean which need to be refreshable  
Use postman to see the app is up and running(`get` request to [actuator/health](http://localhost:8080/actuator/health))  
You should receive
```
{
    "status": "UP"
}
```
To trigger refresh in actuator use `post` request to
```
http://localhost:8080/actuator/refresh
```
Try to commit to config-file repo and then send this post request.  
Real-time management done!
# Issues
## Spring cloud config server
If config for spring cloud server is not in the main dir of git repo than it can't find cfg file  
I have created a new repo for application.yml only so it can clone this repo  
You also can use your local git repo  
## Real-time management
Besides the Spring Actuator you need to add Spring Cloud Bootstrap and bootstrap.yml  
smth like:
```
spring:
  application:
    name: foo
  cloud:
    config:
      uri: ${SPRING_CONFIG_URI:http://localhost:8888}

```
You also can add to this file  the management endpoints web exposure include property there.
# Related repository
[application.yml for cfg-server](https://github.com/DennisKingsman/ConfigSpringCloudServer)  
[mcs-lvl-one-two](https://github.com/DennisKingsman/RestMicroservicesLvlOne)  
[spring-cloud-config-server](https://github.com/DennisKingsman/RestMicroservicesLvlOne/tree/master/spring-cloud-config-server-for-mcs-lvl-3-related-project/spring-cloud-config-server)
