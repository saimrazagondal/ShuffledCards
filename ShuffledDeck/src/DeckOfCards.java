
import java.util.Random;


public class DeckOfCards {

    /***
     * variables
     * 1. head of the list
     * 2. variable to keep track of current number of cards in the deck
     * 3. tail of the list
     */
    private Card head;
    private int numberOfCards;
    private Card tail;


                /************************************************/


    /**
     * Constructor
     * Creates an empty deck of cards
     */
    public DeckOfCards() {
        head = null;
        tail = null;
        numberOfCards = 0;
    }


    /**
     * Assuming that order of suits is (ascending) -> Spades, Clubs, Hearts, Diamonds
     * Initializes a deck that contains 52 cards in order
     * This deck is not shuffled rather just like a new deck
     */
    public void initialiseDeck() {

        // Create initial deck
        int[] suitValues = {1, 2, 3, 4};
        int[] faceValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        String[] suitStrings = {"Spades", "Clubs", "Hearts", "Diamonds"};
        String[] faceStrings = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        for (int i = 0; i < suitValues.length; i++) {
            for (int j = 0; j < faceValues.length; j++) {
                this.addCardToDeck(suitValues[i], suitStrings[i], faceValues[j], faceStrings[j]);
            }
        }
    }


    /**
     * Keeps track of number of cards in the deck
     */
    public int getNumberOfCards() {
        return numberOfCards;
    }



    /**
     * Adds a card to the deck
     * Parameters: Suit and Face Value of the card
     */
    private void addCardToDeck(int suitValue, String suitString, int faceValue, String faceString) {
        Card card = new Card();
        card.setFaceValue(faceValue);
        card.setFaceValueString(faceString);
        card.setSuitValue(suitValue);
        card.setSuitValueString(suitString);
        card.setId(suitValue * faceValue);

        if (head == null) {
            head = card;
            tail = card;
        }

        else if (head == tail) {
            head.setNext(card);
            tail = card;
        }

        else {
            tail.setNext(card);
            tail = card;
        }

        this.numberOfCards++;
    }


    /**
     * Removes a card from the deck
     * The position of the removed card is determined via a random number
     */
    public Card removeRandomCard() {

        //Check if deck is empty then return null
        if (numberOfCards == 0) {
            return null;
        }

        //Initialize a random number based on number of cards left in deck
        Random random = new Random();
        int randomNumber = random.nextInt(numberOfCards);


        Card current = head;
        Card dummy = new Card();
        dummy.setNext(head);
        Card previous = dummy;

        int count = 0;

        while (count < randomNumber) {
            previous = previous.getNext();
            current = current.getNext();
            count++;
        }

        //decrement numberOfCards to keep track of cards left in the deck
        numberOfCards--;

        //Checks to see if there are any cards in the deck
        if (numberOfCards == 0) {
            head = null;
            tail = null;
        }
        else if (current == head) {
            head = head.getNext();
        }
        else if (current == tail) {
            tail = previous;
            tail.setNext(null);
        }
        else {
            previous.setNext(current.getNext());
        }

        return current;
    }



    /**
     * Shuffles the Deck
     * Picks out a card from the deck based on the random generator
     * swaps that card with the head of the list
     * does so for 52 iterations shuffling the cards completely
     */
    public void shuffle()
    {

        //random number generator
        Random rand = new Random();


        for (int i = 0; i < 52; i++) {
            int r = i + rand.nextInt(52 - i);

            Card current = head;
            Card dummy = new Card();
            dummy.setNext(head);
            Card previous = dummy;

            int count = 0;

            while (count < r) {
                previous = previous.getNext();
                current = current.getNext();
                count++;
            }

            Card temp = new Card();
            if(current.getNext() != null){
                previous.setNext(current.getNext());
                current.setNext(head);
                head = current;
            } else {
                current.setNext(head);
                previous.setNext(null);
                head =current;
            }
        }

        /**
         * Print out the shuffled deck
         */
        System.out.println("The shuffled deck is as follows: \n\n" + toString());
        }


    /**
     *Print the deck
     */
    public String toString() {
        if (numberOfCards == 0) {
            return "Deck is Empty!";
        }

        //String builder to store entire deck
        StringBuilder sb = new StringBuilder();

        Card current = head;
        while(current != null) {
            sb.append(current.toString() + "\n");
            current = current.getNext();
        }

        return sb.toString();
    }

}
