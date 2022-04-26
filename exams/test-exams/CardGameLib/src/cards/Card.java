package cards;

import java.util.Locale;

public class Card {
    private FaceOfCard face;
    private SuitOfCard suit;

    public Card(FaceOfCard face, SuitOfCard suit) {
        setFace(face);
        setSuit(suit);
    }

    public FaceOfCard getFace() {
        return this.face;
    }

    public void setFace(FaceOfCard face) {

        this.face = FaceOfCard.valueOf(face.getFace().toUpperCase());
    }

    public SuitOfCard getSuit() {
        return this.suit;
    }

    public void setSuit(SuitOfCard suit) {
        this.suit = SuitOfCard.valueOf(suit.getSuit().toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("%s of %s\n", face.getFace(), suit.getSuit());
    }
}
