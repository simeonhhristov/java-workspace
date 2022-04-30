package model;

public class Card {

    int face;
    int suit;

    public static final String[] faces = {"SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
    public static final String[] suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};

    public Card(int face, int suit) {
        setFace(face);
        setSuit(suit);
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String getSuitName() {
        return suits[this.suit - 1];
    }

    @Override
    public String toString() {
        return String.format("%s of %s", faces[this.face - 1], suits[this.suit - 1]);
    }
}
