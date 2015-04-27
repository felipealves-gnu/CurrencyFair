package com.currencyfair;

import com.currencyfair.pojos.TradeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author felipe
 */
@Path("trades")
public class TradesResource {

    @Resource(mappedName = "jms/tradeConnectionFactory")
    private QueueConnectionFactory queueCFactory;
    @Resource(mappedName = "jms/tradeQueue")
    private Queue queue;

    @POST
    @Path("send")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createTradeInJSON(TradeMessage tradeMessage) {
        Connection connection;
        
        try {
            connection = queueCFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = (MessageProducer) session.createProducer(queue);
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(tradeMessage);
            messageProducer.send(objectMessage);
            System.out.println("---> objectMessage sent to the queue");
        } catch (JMSException e) {
            Logger.getLogger(TradesResource.class.getName()).log(Level.SEVERE, null, e);
        }

        return "ok";
    }
}
