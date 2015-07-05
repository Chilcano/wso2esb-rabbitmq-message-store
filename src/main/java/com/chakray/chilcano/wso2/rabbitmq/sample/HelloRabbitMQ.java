package com.chakray.chilcano.wso2.rabbitmq.sample;

import java.io.InputStream;
import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class HelloRabbitMQ
{

    public HelloRabbitMQ()
    {
    }

    public static void main(String[] args)
    {
        HelloRabbitMQ hello = new HelloRabbitMQ();
        hello.runTest();
    }

    private void runTest()
    {
        try (InputStream resourceAsStream = this.getClass().getResourceAsStream("hello_rabbitmq_jndi.properties"))
        {
            System.setProperty("qpid.amqp.version", "0-91");
            System.setProperty("qpid.dest_syntax", "BURL");
            System.setProperty("IMMEDIATE_PREFETCH", "true");
            System.setProperty("qpid.declare_exchanges", "false");
            System.setProperty("qpid.declare_queues", "false");

            Properties properties = new Properties();
            properties.load(resourceAsStream);

            Context context = new InitialContext(properties);

            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("myRabbitMQConnectionFactory1");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // There are 2 destinations used as publisher and consumer independently, suitable for RabbitMQ
            Destination destinationPublisher = (Destination) context.lookup("myJndiDestQueuePublisher1");
            Destination destinationConsumer = (Destination) context.lookup("myJndiDestQueueConsumer1");

            MessageProducer messageProducer = session.createProducer(destinationPublisher);
            MessageConsumer messageConsumer = session.createConsumer(destinationConsumer);

            TextMessage message = session.createTextMessage("Hello RabbitMQ 3.4.4 !!");
            messageProducer.setDeliveryMode(Session.AUTO_ACKNOWLEDGE);
            messageProducer.send(message);
            messageProducer.close();

            Thread.sleep(10000);  // After 10 secs the message will be consumed

            message = (TextMessage)messageConsumer.receive();
            System.out.println(message.getText());

            session.close();
            connection.close();
            context.close();
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
