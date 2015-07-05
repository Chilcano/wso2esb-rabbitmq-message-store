# wso2esb-rabbitmq-message-store
<h2>WSO2 ESB Message Store (MS) and Message Processor (MP) implementation for RabbitMQ</h2>

This MS&MP implements the way how to WSO2 ESB and RabbitMQ (or any Message Broker) should work.
With this MS&MP we can implement different EIP related with messaging such as:

<ul>
    <li>Dead Letter Queue
    <li>Wire Tap
    <li>Retry Queue
    <li>Throttling
</ul>

For further information about EIP, I recommend the next pages:  
<ul>
<li><a target="_new" href="https://docs.wso2.com/display/IntegrationPatterns/Enterprise+Integration+Patterns+with+WSO2+ESB">https://docs.wso2.com/display/IntegrationPatterns/Enterprise+Integration+Patterns+with+WSO2+ESB</a>
<li>
<a href="https://holisticsecurity.wordpress.com/2014/12/03/wso2-message-broker-vs-apache-qpid-messaging-eip/" target="_new">https://holisticsecurity.wordpress.com/2014/12/03/wso2-message-broker-vs-apache-qpid-messaging-eip/</a>
</ul>


This is valid for:

<ul>
<li>WSO2 ESB 4.8.1
<li>RabbitMQ 3.4.4
<li>Apache Qpid client 0.30
</ul>

<h3>How to check the sourcecode and configuration</h3>

After downloading the code, execute the next commands:

<pre>
$ cd wso2esb-rabbitmq-message-store
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="com.chakray.chilcano.wso2.rabbitmq.sample.HelloRabbitMQ"
</pre>

The <code>com.chakray.chilcano.wso2.rabbitmq.sample.HelloRabbitMQ</code> is a simple JMS client that publish and consume a message to/from RabbitMQ. This sample uses Apache Qpid client library, does not use RabbitMQ client libraries. To execute properly you should update the <code>hello_rabbitmq_jndi.properties</code> with your values.

<h3>How to deploy on WSO2 ESB</h3>

Deploy the libraries:

<ol>
<li> Copy <code>hello_rabbitmq_jndi.properties, qpid-client-0.30.jar, qpid-common-0.30.jar, wso2esb-rabbitmq-msmp-0.1.jar</code> to <code>%WSO2ESB_HOME%/repository/components/lib/</code> folder.
<li> Restart WSO2 ESB
</ol>

Deploy the Synapse files for the Message Store and API samples:

<ol>
<li> In RabbitMQ side you need to create a queue and 2 routing keys. I recommend you use the <code>hello_rabbitmq_config_broker.json</code> and import it from the RabbitMQ web admin console.
<li> Copy <code>HelloRabbitMQMsgStore1.xml</code> into <code>%WSO2ESB_HOME%/repository/deployment/server/synapse-configs/default/message-stores/</code>
<li> Copy <code>HelloRabbitMQRest1.xml</code> into <code>%WSO2ESB_HOME%/repository/deployment/server/synapse-configs/default/api/</code>
</ol>

WSO2 ESB automatically will deploy these 2 synapse files and after that you are ready to send a message to WSO2 ESB and store this message in RabbitMQ side.


-end-


