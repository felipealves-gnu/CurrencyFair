# CurrencyFair
CurrencyFair project 

Requirements: The server used to this project was Glassfish 4.1

After glassfish is installed Inside Glass follow these steps
 - Now is necessary to create two JSM resources in the administrative area of glassfish.
 - Before to start the next 2 steps read this blog to clarify somethings http://www.greenkode.com/2011/09/using-glassfish-and-ejb-3-0-message-driven-beans-for-java-messaging/ .
 - In "JMS Connection Factory"(inside JMS Resources) area in the field "JNDI Name" fill out the field with jms/tradeConnectionFactory .
 - In "JMS Destination Resources"(inside JMS Resources) area in the field "JNDI Name" fill out the field with jms/tradeQueue , 
 	"Physical Destination Name" with tradeQueue and Resource Type" choose javax.jms.Queue .
 - Now is necessary compile the project with maven, using "mvn install" command.
 - Deploy the application called Currency in glassfish.