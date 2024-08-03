package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Dealer dealer;
    private List<Player> players;
    private Deck deck;

    public Game(List<String> playerNames, List<Integer> betAmounts) {
        if (playerNames == null || playerNames.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 null이 될 수 없습니다.");
        }
        if (playerNames.size() != betAmounts.size()) {
            throw new IllegalArgumentException("플레이어 이름의 개수와 배팅금의 개수는 같아야 합니다.");
        }
        dealer = new Dealer();
        players = new ArrayList<>();
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), betAmounts.get(i)));
        }
        deck = new Deck();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void start() {
        for (Player player : players) {
            player.receiveCard(deck.dealCard());
            player.receiveCard(deck.dealCard());
        }
        dealer.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());
    }

    public void play() {
        for (Player player : players) {
            while (player.getCardsValue() < 21 && player.wantsCard()) {
                player.receiveCard(deck.dealCard());
            }
        }
        while (dealer.wantsCard()) {
            dealer.receiveCard(deck.dealCard());
        }
    }
}
