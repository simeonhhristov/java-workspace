package fig07_09_11;// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.

public class DeckOfCardsTest {
    // execute application
    public static void main(String args[]) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        Card[] rightHand = new Card[5];
        Card[] leftHand = new Card[5];

        System.out.printf("%-20s%-20s\n", "Left hand:", "Right hand:");
        for (int i = 0; i < 5; i++) {
            rightHand[i] = myDeckOfCards.dealCard();
            leftHand[i] = myDeckOfCards.dealCard();
            System.out.printf("%-20s%-20s\n",leftHand[i], rightHand[i]);
        }

        System.out.println("Hand Values: ");
        int rightHandRank = myDeckOfCards.rankHand(rightHand);
        int leftHandRank = myDeckOfCards.rankHand(leftHand);
        System.out.printf("%-20s%-20s\n", myDeckOfCards.getRankLabel(leftHandRank),
                myDeckOfCards.getRankLabel(rightHandRank));

        System.out.println("\nResult:");
        if (rightHandRank < leftHandRank) {
            System.out.println("Right hand is better");
        } else if (rightHandRank > leftHandRank) {
            System.out.println("Left hand is better");
        } else {
            System.out.println("Equal hands");
        }

        // print all 52 Cards in the order in which they are dealt
//      for ( int i = 0; i < 13; i++ )
//      {
//         // deal and print 4 Cards
//         System.out.printf( "%-20s%-20s%-20s%-20s\n",
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//      } // end for
    } // end main
} // end class DeckOfCardsTest

