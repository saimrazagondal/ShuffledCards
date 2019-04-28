
import java.util.Scanner;

public class DriverProgram {

    /**
     *
     * The main method of the program
     */
    public static void main(String[] args) {

        //Prompts the user for his choice of action and takes input
        displayMenu();
        Scanner in = new Scanner(System.in);

        int choice = in.nextInt();

        //An empty deck of cards
        //An empty hand
        DeckOfCards deck = new DeckOfCards();
        DealtHand hand = new DealtHand(deck);


        /**
         * If the choice entered is between 1 and 10 then,
         * if 1: initialize the deck in order
         * if 2: Print the deck
         * if 3: Shuffle the deck
         * if 4: Print the hand (Initially empty until cards added)
         * if 5: Print the number of cards in the deck
         * if 6: Print the number of cards in the hand currently
         * if 7: Add a random card from the deck to the hand
         * if 8: Remove a card from the hand by the choice of user
         * if 9: Remove a random card from the hand
         * if 10: exit the program and re-display the menu
         */
        while (choice > 0 && choice < 11) {
            switch (choice) {
                case 1:
                    deck.initialiseDeck();
                    System.out.println("New Deck created successfully!");
                    break;

                case 2:
                    System.out.println(deck.toString());
                    break;

                case 3:
                    deck.shuffle();
                    break;

                case 4:
                    if(hand.getNumberOfCards() == 0) {
                        System.out.println("The hand is empty!");
                        break;
                    }
                    else {
                        System.out.println(hand.toString());
                        break;
                    }

                case 5:
                    System.out.println("The number of cards in the deck is: " + deck.getNumberOfCards());
                    break;

                case 6:
                    System.out.println("The number of cards in the hand is: " + hand.getNumberOfCards());
                    break;

                case 7:
                    Card card3 = hand.addCard();
                    System.out.println(card3.toString() + " added to the hand!");
                    break;

                case 8:
                    if(hand.getNumberOfCards() == 0){
                        System.out.println("Hand is empty! Nothing to remove!");
                        break;
                    } else {
                        Card card = hand.removeByPos();
                        System.out.println(card.toString() + " removed from the hand!");
                        break;
                    }

                case 9:
                    if(hand.getNumberOfCards() == 0){
                        System.out.println("Hand is empty! Nothing to remove!");
                        break;
                    } else {
                        Card card2 = hand.removeRandomCard();
                        System.out.println(card2.toString() + " removed from the hand!");
                        break;
                    }

                 default:
                    break;
            }

            /**
             * After appending a new line
             * Display the menu again so that user can continue
             */
            System.out.println();
            displayMenu();
            choice = in.nextInt();
        }
    }


    /**
     * Displays a menu for the user with options to chose from
     */
    private static void displayMenu() {
        System.out.println("***************");
        System.out.println("\tMenu");
        System.out.println("***************");
        System.out.println("\t 1. Create new deck");
        System.out.println("\t 2. Print the deck of cards:");
        System.out.println("\t 3. Shuffle the deck");
        System.out.println("\t 4. Print dealt hand");
        System.out.println("\t 5. Print the number of cards left in the deck");
        System.out.println("\t 6. Print the number of cards left in the hand");
        System.out.println("\t 7. Remove a card from the deck and place in the hand");
        System.out.println("\t 8. Remove a card from the hand by position");
        System.out.println("\t 9. Remove a card from the hand randomly");
        System.out.println("\t 10. Exit");
        System.out.println();
        System.out.print("Please enter your selection: ");
    }
}