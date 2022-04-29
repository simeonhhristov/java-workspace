package game;

public enum Suit {
    CLUBS("CLUBS"),
    DIAMONDS("DIAMONDS"),
    HEARTS("HEARTS"),
    SPADES("SPADES");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    String getSuit() {
        return this.suit;
    }

}
