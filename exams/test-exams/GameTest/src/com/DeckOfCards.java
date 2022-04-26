package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cards.*;

public class DeckOfCards {
    private ArrayList<Card> cards;
    private int currentCard;

    public DeckOfCards() {
        this.currentCard = 0;
        this.cards = new ArrayList<Card>();
        String[] faces = {"ACE", "DEUCE", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
        String[] suits = {"HEARTS", "CLUBS", "SPADES", "DIAMONDS"};

        for (int i = 0; i < faces.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                this.cards.add(new Card(FaceOfCard.valueOf(faces[i]), SuitOfCard.valueOf(suits[j])));
            }
        }
    }

    public void shuffle() {
        this.currentCard = 0;
        Collections.shuffle(cards);
    }

    public Card[] dealFive() {
        Card[] hand = new Card[5];
        Arrays.fill(hand, null);

        //deal until we deal 5 or reach the end of the deck
        for (int i = 0; i < 5 && currentCard < 52; i++, currentCard++) {
            hand[i] = cards.get(currentCard);
        }
        return hand;
    }

    public static void sortByFaceCards(ArrayList<Card> deck) {
        if (deck == null) return;
        ArrayList<Card> sortedDeck = new ArrayList<>(deck);

        //bubble sort the array
        for (int i = 0; i < deck.size() - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < deck.size() - 1 - i; j++) {
                if (sortedDeck.get(j).getFace().ordinal() >
                        sortedDeck.get(j + 1).getFace().ordinal()) {
                    Collections.swap(sortedDeck, j, j + 1);
                    swapped = true;
                }
            }
            // no swapping means array is already sorted
            if (!swapped) {
                break;
            }
        }

        for (Card card : sortedDeck) {
            System.out.printf("%s ", card.toString());
        }
    }

    public void printBySuits() {
        for (SuitOfCard suit : SuitOfCard.values()) {
            System.out.printf("%s: \n", suit.getSuit());
            for (Card card : cards) {
                if (card.getSuit().getSuit().equals(suit.getSuit())) {
                    System.out.printf("%s ", card.getFace());
                }
            }
            System.out.println();
        }
    }

    public List<FaceOfCard> getDistinctFaces(Card[] deck) {
        if (deck == null || deck.length == 0) return null;
        List<FaceOfCard> distinctFaces = new ArrayList<>();

        for (Card card : deck) {
            FaceOfCard face = card.getFace();
            if (!distinctFaces.contains(face)) {
                distinctFaces.add(face);
            }
        }
        return distinctFaces;
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        for (Card card : deck.cards) {
            System.out.printf("%s", card.toString());
        }

        //shuffle
        deck.shuffle();
        System.out.println("\nShuffled card:");
        for (Card card : deck.cards) {
            System.out.printf("%s ", card.toString());
        }

        //deal five
        Card[] hand = deck.dealFive();
        System.out.println("\nDeal five cards:");
        System.out.println(Arrays.toString(hand));

        //sort by face
        System.out.println("\nSort by face:");
        sortByFaceCards(deck.cards);

        //print by suits
        System.out.println("\nPrinted by suits:");
        deck.printBySuits();

        //distinct faces
        System.out.println("\nDistinct faces in hand:");
        List<FaceOfCard> list = deck.getDistinctFaces(hand);
        System.out.println(list);
    }
}
