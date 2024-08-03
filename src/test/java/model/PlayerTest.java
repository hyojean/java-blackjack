package model;

import model.Card;
import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("pobi", 10000);
    }

    @Test
    public void testPlayerCreation() {
        assertEquals("pobi", player.getName());
        assertEquals(10000, player.getBetAmount());
    }

    @Test
    public void testPlayerReceiveCard() {
        Card card = new Card("하트", "A");
        player.receiveCard(card);
        assertEquals(1, player.getCards().size());
        assertEquals(card, player.getCards().get(0));
    }

    @Test
    public void testPlayerHandValue() {
        player.receiveCard(new Card("하트", "A"));
        player.receiveCard(new Card("다이아몬드", "K"));
        assertEquals(21, player.getCardsValue());
    }
}
