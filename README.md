# Multiple JDBC Clients

In a [previous tutorial](https://youtu.be/qLDrfebeXS0) I walked through the progression of accessing a database in 
Java and Spring. In the comments for that video I was asked how to use the JDBC Client when you're using multiple 
data sources. I thought that was a great question and this tutorial is to walk through that scenario.

## Getting Started

Create a new application at start.spring.io with the web,jdbc, and h2 dependencies or by clicking on 
[this link](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.0&packaging=jar&jvmVersion=21&groupId=dev.danvega&artifactId=multiple-ds&name=multiple-ds&description=Multiple%20DataSources%20using%20the%20new%20JDBC%20Client&packageName=dev.danvega.multiple-ds&dependencies=web,jdbc,h2,devtools).

## Configuring Two DataSources in a Spring Application

There is a really good section in the Spring Boot Reference Documentation on [Configuring Two DataSources](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-access.configure-two-datasources).


