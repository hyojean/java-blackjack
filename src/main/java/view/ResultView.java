package view;

import model.Card;
import model.Dealer;
import model.Game;
import model.Player;

import java.util.List;

public class ResultView {
    public static void showInitialCards(Dealer dealer, List<Player> players) {
        System.out.println("\n딜러와 " + players.size() + "명에게 2장을 나누었습니다.");
        System.out.println("딜러: " + dealer.getCards().get(0));
        for (Player player : players) {
            System.out.println(player.getName() + " 카드: " + player.getCards().get(0) + ", " + player.getCards().get(1));
        }
        System.out.println();
    }

    public static void showFinalResults(Dealer dealer, List<Player> players) {
        int dealerValue = dealer.getCardsValue();
        System.out.println("\n딜러는 16 이하라 한장의 카드를 더 받았습니다.\n");
        System.out.println("딜러 카드: " + formatCards(dealer.getCards()) + " - 결과: " + dealerValue);
        for (Player player : players) {
            int playerValue = player.getCardsValue();
            System.out.println(player.getName() + " 카드: " + formatCards(player.getCards()) + " - 결과: " + playerValue);
        }
        System.out.println();
    }

    public static String formatCards(List<Card> cards) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i));
            if (i < cards.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void showFinalOutcome(Game game) {
        Dealer dealer = game.getDealer();
        List<Player> players = game.getPlayers();

        int dealerProfit = 0;
        for (Player player : players) {
            int profit = game.calculateProfit(player);
            dealerProfit -= profit;
        }

        System.out.println("## 최종 수익");
        System.out.println("딜러: " + dealerProfit);
        for (Player player : players) {
            int profit = game.calculateProfit(player);
            System.out.println(player.getName() + ": " + profit);
        }
    }
}
