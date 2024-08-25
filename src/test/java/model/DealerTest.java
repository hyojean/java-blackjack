package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {
    private Dealer dealer;

    @BeforeEach
    public void setUp() {
        dealer = new Dealer();
    }

    @Test
    public void testDealerCreation() {
        assertEquals("딜러", dealer.getName());
    }

    @Test
    public void testDealerReceiveCard() {
        Card card = new Card("하트", "A");
        dealer.receiveCard(card);
        assertEquals(1, dealer.getCards().size());
        assertEquals(card, dealer.getCards().get(0));
    }

    @Test
    public void testDealerHandValue() {
        dealer.receiveCard(new Card("하트", "A"));
        dealer.receiveCard(new Card("다이아몬드", "K"));
        assertEquals(21, dealer.getCardsValue());
    }
}
