package cards;

public enum SuitOfCard {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private String suit;

    SuitOfCard(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        String copy = new String(this.suit);
        return copy;
    }
}
