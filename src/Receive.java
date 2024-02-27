import com.rabbitmq.client.*;

public class Receive {

    private final String QUEUE_NAME;
    private final ConnectionFactory factory;
    private final Connection connection;
    private final Channel channel;
    private int messagesReceived = 0;
    private int totalMessages;

    public Receive(String queueName) throws Exception {
        QUEUE_NAME = queueName;
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();

        // Get total messages in the queue
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(QUEUE_NAME);
        totalMessages = declareOk.getMessageCount();
        System.out.println(" [*] Waiting for messages on queue: " + QUEUE_NAME);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            JdbcInsert ins = new JdbcInsert(message,"HO");

            messagesReceived++;
            if (messagesReceived >= totalMessages) {
                stopConsuming();
            }
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }

    private void stopConsuming() {
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("All messages received. Stopping consumption.");
    }

}
