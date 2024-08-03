package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game(Arrays.asList("pobi", "jason"), Arrays.asList(10000, 20000));
        game.start();
    }

    @Test
    public void testGameCreation() {
        assertNotNull(game.getDealer());
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    public void testGameStart() {
        assertEquals(2, game.getDealer().getCards().size());
        for (Player player : game.getPlayers()) {
            assertEquals(2, player.getCards().size());
        }
    }

    @Test
    public void testCalculateProfit() {
        Dealer dealer = game.getDealer();
        dealer.getCards().clear();
        dealer.receiveCard(new Card("하트", "10"));
        dealer.receiveCard(new Card("다이아몬드", "8"));

        Player player1 = game.getPlayers().get(0);  // pobi
        player1.getCards().clear();
        player1.receiveCard(new Card("하트", "A"));
        player1.receiveCard(new Card("다이아몬드", "K"));
        assertEquals(15000, game.calculateProfit(player1));

        Player player2 = game.getPlayers().get(1);  // jason
        player2.getCards().clear();
        player2.receiveCard(new Card("클로버", "5"));
        player2.receiveCard(new Card("스페이드", "K"));
        assertEquals(-20000, game.calculateProfit(player2));
    }
}
