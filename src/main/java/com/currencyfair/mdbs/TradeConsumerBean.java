package com.currencyfair.mdbs;

import com.currencyfair.pojos.TradeMessage;
import com.currencyfair.ejbs.TradeBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.servlet.http.HttpServlet;

/**
 * The consumer of the queue.
 *
 * @author felipe
 */
@MessageDriven(mappedName = "jms/tradeQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class TradeConsumerBean extends HttpServlet implements MessageListener {

    @EJB
    TradeBean tradeBean;

    @Override
    public void onMessage(Message message) {
        try {
            TradeMessage tradeMessage = message.getBody(TradeMessage.class);
            tradeBean.addTrade(tradeMessage);
            if(!tradeBean.getTrades().isEmpty()){
                System.out.println("Message received in CONSUMER: " + tradeBean.getTrades());
            }
        } catch (JMSException ex) {
            Logger.getLogger(TradeConsumerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
