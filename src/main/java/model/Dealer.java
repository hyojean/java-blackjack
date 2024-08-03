package model;

public class Dealer extends Player {

    public Dealer() {
        super("딜러", 0);
    }

    @Override
    public boolean wantsCard() {
        return getCardsValue() <= 16;
    }

    public boolean isBlackjack() {
        return getCards().size() == 2 && getCardsValue() == 21;
    }
}
