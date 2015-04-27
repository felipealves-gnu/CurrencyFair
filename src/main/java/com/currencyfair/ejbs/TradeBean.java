package com.currencyfair.ejbs;

import com.currencyfair.pojos.TradeMessage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author felipe
 */
@Singleton
public class TradeBean {

    private List<TradeMessage> trades;

    @PostConstruct
    private void initialize() {
        trades = new ArrayList<TradeMessage>();
    }

    public void addTrade(TradeMessage tradeMessage) {   
        trades.add(tradeMessage);
    }

    public List<TradeMessage> getTrades() {
        return trades;
    }
}
