package cards;

public enum FaceOfCard {
    ACE("Ace"),
    DEUCE("Deuce"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King");

    private String face;

    FaceOfCard(String face) {
        this.face = face;
    }

    String getFace() {
        String copy = new String(this.face);
        return copy;
    }
}
