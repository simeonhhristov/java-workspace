package game;

public enum Face {
    ACE("ACE"),
    KING("KING"),
    QUEEN("QUEEN"),
    JACK("JACK"),
    TEN("TEN"),
    NINE("NINE");

    private final String face;

    Face(String face) {
        this.face = face;
    }

    String getFace() {
        return  this.face;
    }
}
