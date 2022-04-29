package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class EuchreGame {
    public Card[] cards; // масив от всички карти в тестето от карти
    private Card[] hand; // текущо изтеглена ръка от най- много 5 карти
    private String TRUMP; // константа на всяка отделна игра
    private Random random; // генератор на случайни числа
    private int dealCard; // брой карти изтеглени текущо от cards

    private static Face[] faces = {Face.valueOf("ACE"), Face.valueOf("KING"), Face.valueOf("QUEEN"), Face.valueOf("JACK"), Face.valueOf("TEN"), Face.valueOf("NINE")};
    private static Suit[] suits = {Suit.valueOf("CLUBS"), Suit.valueOf("DIAMONDS"), Suit.valueOf("HEARTS"), Suit.valueOf("SPADES")};

    EuchreGame() {
        this.cards = new Card[24];
        //fill new array with cards
        int iterator = 0;
        for (int i = 0; i < faces.length; i++) {
            for (int j = 0; j < suits.length; j++, iterator++) {
                this.cards[iterator] = new Card(faces[i].getFace(), suits[j].getSuit());
            }
        }
        //set random TRUMP
        this.random = new Random();
        this.TRUMP = suits[random.nextInt(4)].getSuit();
    }

    public String getTrump() {
        return this.TRUMP;
    }

    public void shuffleCards() {
        random = new Random();

        for (int i = 0; i < 24; i++) {
            int swapIdx = random.nextInt(24);

            Card tempCard = new Card(cards[i].getFace(), cards[i].getSuit());
            cards[i] = new Card(cards[swapIdx].getFace(), cards[swapIdx].getSuit());
            cards[swapIdx] = new Card(tempCard.getFace(), tempCard.getSuit());
        }
        this.dealCard = 0;
    }

    String printCards() {
        StringBuilder toPrint = new StringBuilder();
        for (int i = 0; i < hand.length && this.hand[i] != null; i++) {
            toPrint.append(hand[i].toString());
            toPrint.append(",");
            if ((i + 1) % 3 == 0) {
                toPrint.append('\n');
            }
        }
        return toPrint.toString();
    }

    public boolean dealHand() {
        this.hand = new Card[5];
        Arrays.fill(this.hand, null);

        int dealtCards = 0;
        for (int i = 0; dealCard < 24 && i < 5; i++, dealCard++, dealtCards++) {
            this.hand[i] = new Card(cards[dealCard].getFace(), cards[dealCard].getSuit());
        }

        return dealtCards == 5;
    }

    public int countHandStrength() {
        int[] occurrences = countFaces();
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += occurrences[i] * (i + 1);
        }

        return result;
    }

    private int[] countFaces() {
        int[] occurrences = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 5; i++) {
            occurrences[Face.valueOf(this.hand[i].getFace()).ordinal()]++;
        }
        return occurrences;
    }

    public boolean hasJackQueenKingTrump() {
        boolean jack = false;
        boolean ace = false;
        boolean king = false;
        for (int i = 0; i < 5 && this.hand[i] != null; i++) {
            //check for TRUMP jack
            if (this.hand[i].getFace().equals("JACK") && this.hand[i].getSuit().equals(this.TRUMP)) {
                jack = true;
                continue;
            }
            //check for TRUMP Queen
            if (this.hand[i].getFace().equals("QUEEN") && this.hand[i].getSuit().equals(this.TRUMP)) {
                ace = true;
                continue;
            }
            //check for TRUmP King
            if (this.hand[i].getFace().equals("KING") && this.hand[i].getSuit().equals(this.TRUMP)) {
                king = true;
            }
        }

        return jack && ace && king;
    }

    public  boolean hasJackAndAceTrump(){
        boolean jack = false;
        boolean ace = false;

        for (int i = 0; i < 5 && this.hand[i] != null; i++) {
            //check for TRUMP jack
            if (this.hand[i].getFace().equals("JACK") && this.hand[i].getSuit().equals(this.TRUMP)) {
                jack = true;
                continue;
            }
            //check for TRUMP Ace
            if (this.hand[i].getFace().equals("ACE") && this.hand[i].getSuit().equals(this.TRUMP)) {
                ace = true;
            }

        }

        return jack && ace;
    }

}
