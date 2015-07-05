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

For further information about EIP, I recommend this page:  https://docs.wso2.com/display/IntegrationPatterns/Enterprise+Integration+Patterns+with+WSO2+ESB

This is valid for:

<ul>
<li>WSO2 ESB 4.8.1
<li>RabbitMQ 3.4.4
<li>Apache Qpid client 0.30
</ul>

<h3>How to check the sourcecode</h3>

After downloading the code, execute the next commands:

<code>
$ cd wso2esb-rabbitmq-message-store
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="com.chakray.chilcano.wso2.rabbitmq.sample.HelloRabbitMQ"
</code>

<h3>How to deploy on WSO2 ESB</h3>

Deploy the libraries:

<ol>
<li> Copy <i>hello_rabbitmq_jndi.properties, qpid-client-0.30.jar, qpid-common-0.30.jar, wso2esb-rabbitmq-msmp-0.1.jar</i> to %WSO2ESB_HOME%/repository/components/lib/ folder.
<li> Restart WSO2 ESB
</ol>

Deploy the Synapse files for the Message Store and API samples:

<ol>
<li> In RabbitMQ side you need to create a queue and 2 routing keys. I recommend you use the <i>hello_rabbitmq_config_broker.json</i> and import it from the RabbitMQ web admin console.
<li> Copy <i>HelloRabbitMQMsgStore1.xml</i> into %WSO2ESB_HOME%/repository/deployment/server/synapse-configs/default/message-stores/
<LI> Copy <i>HelloRabbitMQRest1.xml</i> into %WSO2ESB_HOME%/repository/deployment/server/synapse-configs/default/api/
</ol>

WSO2 ESB automatically will deploy these 2 synapse files and after that you are ready to send a message to WSO2 ESB and store this message in RabbitMQ side.



-end-


