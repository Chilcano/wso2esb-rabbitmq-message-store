# wso2esb-rabbitmq-message-store
WSO2 ESB Message Store (MS) and Message Processor (MP) implementation for RabbitMQ.

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

How to check the code:
<code>
$ cd wso2esb-rabbitmq-message-store
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="com.chakray.chilcano.wso2.rabbitmq.sample.HelloRabbitMQ"
</code>

How to deploy on WSO2 ESB:

<ol>
<li> Copy <i>hello_rabbitmq_jndi.properties, qpid-client-0.30.jar, qpid-common-0.30.jar, wso2esb-rabbitmq-msmp-0.1.jar</i> to %WSO2ESB_HOME%/repository/components/lib/ folder.
<li> Restart WSO2 ESB
<li> Copy <i>HelloRabbitMQMsgStore1.xml, HelloRabbitMQRest1.xml</i> into %WSO2ESB_HOME%/repository/distribution/server/xxxxx
</ol>

-end-


