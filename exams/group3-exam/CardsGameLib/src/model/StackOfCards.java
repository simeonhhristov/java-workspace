package model;

import java.util.Arrays;
import java.util.Random;

public class StackOfCards {
    private Card[] cards; // масив от всички карти в тестето от карти
    private Card[] pack1; // масив на първото тесте след деленето на картите
    private Card[] pack2; // масив на второто тесте след деленето на картите
    private  Card[] hand; // текущо изтеглена ръка от най- много 12 карти
    private  int trump; // индекс на цвят в Cards.suits, Коз на играта
    private  Random random; // генератор на случайни числа
    private   int currentCard; // брой карти изтеглени текущо от cards
    private   int currentPack1; // брой карти изтеглени текущо от pack2
    private   int currentPack2; // брой карти изтеглени текущо от pack1

    public StackOfCards() {
        cards = new Card[64];
        int current = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                this.cards[current] = new Card(i + 1, j + 1);
                current++;
                this.cards[current] = new Card(i + 1, j + 1);
                current++;
            }
        }
        this.hand = new Card[12];
        Arrays.fill(this.hand, null);

        this.random = new Random();
        this.trump = random.nextInt(4);
    }

    public int getTrump() {
        return this.trump;
    }

    public void shuffleCards() {
        random = new Random();

        for (int i = 0; i < 64; i++) {
            int swapIdx = random.nextInt(64);

            Card tempCard = new Card(cards[i].getFace(), cards[i].getSuit());
            cards[i] = new Card(cards[swapIdx].getFace(), cards[swapIdx].getSuit());
            cards[swapIdx] = new Card(tempCard.getFace(), tempCard.getSuit());
        }
        this.currentCard = 0;
    }

    public String printCards() {
        StringBuilder toPrint = new StringBuilder();

        for (int i = 0; i < hand.length && this.hand[i] != null; i++) {
            toPrint.append(hand[i].toString());
            toPrint.append(", ");
            if ((i + 1) % 4 == 0) {
                toPrint.append('\n');
            }
        }

        return toPrint.toString();
    }
    public void make2packs(){
        this.shuffleCards();

        random = new Random();
        int N = random.nextInt(33) + 16;

        this.pack1 = new Card[N];
        this.pack2 = new Card[64 - N];

        for (int i = 0; i < N; i++) {
          this.pack1[i] = new Card(cards[currentCard].getFace(), cards[currentCard].getSuit());
          currentCard++;
        }

        for (int i = 0; i < 64 - N; i++){
            this.pack2[i] = new Card(cards[currentCard].getFace(), cards[currentCard].getSuit());
            currentCard++;
        }

        this.currentPack1 = 0;
        this.currentPack2 = 0;
    }

    public  boolean dealHand() {
        for (int i = 0; i < 12; i++) {
            if(i % 2 == 0) {
                if(currentPack1 < pack1.length - 1)
                {
                    this.hand[i] = new Card(pack1[currentPack1].getFace() - 1, pack1[currentPack1].getSuit() - 1);
                    currentPack1++;
                } else if (currentPack2 < pack2.length - 1){
                    this.hand[i] = new Card(pack2[currentPack2].getFace() - 1, pack2[currentPack2].getSuit() - 1);
                    currentPack2++;
                }
            } else{
                if(currentPack2 < pack2.length - 1)
                {
                    this.hand[i] = new Card(pack2[currentPack2].getFace() - 1, pack2[currentPack2].getSuit() - 1);
                    currentPack2++;
                } else if (currentPack1 < pack1.length - 1){
                    this.hand[i] = new Card(pack1[currentPack1].getFace() - 1, pack1[currentPack1].getSuit() - 1);
                    currentPack1++;
                }
            }
        }

        //check weather hand is full
        return this.hand[11] != null;
    }

    public boolean hasKQ(){
        boolean[] kingSuits = {false, false, false, false};
        boolean[] queenSuits = {false, false, false, false};

        for (int i = 0; i < 12 && this.hand[i] != null; i++) {
            //check for kings
            if (this.hand[i].getFace() - 1 == 6){
                kingSuits[this.hand[i].getSuit() - 1] = true;
            }
            //check for queen
            if (this.hand[i].getFace() - 1 == 5){
                queenSuits[this.hand[i].getSuit() - 1] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if(kingSuits[i] && queenSuits[i]) {
                return true;
            }
        }
        return false;
    }

    public  boolean has4ACE() {
        int count = 0;
        for (int i = 0; i < 12 && this.hand[i] != null; i++) {
            if(this.hand[i].getFace() - 1 == 7){
                count++;
            }
        }
        return count == 4;
    }
}
