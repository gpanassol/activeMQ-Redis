package br.com.cadmus.processing.sale;

import br.com.cadmus.processing.redis.CacheRedis;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

public class ConsumerSale {

    public static final String AMQ_BROKER_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "fila.pedidos";

    public void consumerQueueSale() throws Exception{

        //InitialContext context = new InitialContext();
        ConnectionFactory cf = new ActiveMQConnectionFactory(AMQ_BROKER_URL);
        Connection conexao = cf.createConnection();
        conexao.start();
        Session session = conexao.createSession(false, 1);
        Destination fila = new ActiveMQQueue(QUEUE_NAME);
        MessageConsumer consumer = session.createConsumer(fila);
        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;

                try {

                    String json = textMessage.getText();
                    System.out.println("Processando: " + json);

                    //SEND ActiveMQ Topic
                    ProducerSale producer = new ProducerSale();
                    producer.producerTopicSaleProcessed(json);

                    //SEND redis
                    CacheRedis redis = new CacheRedis();
                    redis.sendCacheRedis(json);
                    redis.showListCacheAll();

                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
