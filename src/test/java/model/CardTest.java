package model;

import model.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void testCardCreation() {
        Card card = new Card("하트", "A");
        assertEquals("A하트", card.toString());
    }

    @Test
    public void testCardValue() {
        Card card = new Card("하트", "A");
        assertEquals(11, card.getValue());

        card = new Card("스페이드", "K");
        assertEquals(10, card.getValue());

        card = new Card("다이아몬드", "5");
        assertEquals(5, card.getValue());
    }
}
