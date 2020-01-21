package br.com.cadmus.processing.sale;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

public class ProducerSale {

    public static final String AMQ_BROKER_URL = "tcp://localhost:61616";
    public static final String TOPIC_NAME = "topico.pedidos.processados";

    public void producerTopicSaleProcessed(String json) throws JMSException {

        ConnectionFactory cf;
        Connection conexao = null;
        Session session = null;

        try {

            cf = new ActiveMQConnectionFactory(AMQ_BROKER_URL);
            conexao = cf.createConnection();
            conexao.start();
            session = conexao.createSession(false, 1);

            Destination topic = new ActiveMQTopic(TOPIC_NAME);
            MessageProducer producer = session.createProducer(topic);

            Message message = session.createObjectMessage(json);
            System.out.println("Enviando Topico: " + message);
            producer.send(message);

            conexao.close();
            session.close();

        } catch ( JMSException  e ){
            e.printStackTrace();
        }
    }
}
