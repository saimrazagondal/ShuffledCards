
import java.util.Random;
import java.util.Scanner;

public class DealtHand {


    /**
     * Variables
     * 1. head of the list
     * 2. tail of the list
     * 3. variable to keep track of the number of cards currently in the hand
     */
    private Card head;
    private Card tail;
    private int numberOfCards;

    /**
     * Create an empty deck of cards
     * Scanner for user input
     */
    private DeckOfCards deck;
    private Scanner scanner = new Scanner(System.in);


                    /*************************************************/


    /**
     *Constructor
     *Initializes an empty hand of cards
     * Uses a deck of cards as parameter
     */
    public DealtHand(DeckOfCards deck){
        this.deck = deck;
        head = null;
        tail = null;
        numberOfCards = 0;
    }


    /**
     * Getter method for number of cards
     * Keeps track of how many cards are in the hand
     */
    public int getNumberOfCards(){
        return numberOfCards;
    }


    /**
     * Draws a card from the deck
     * Adds the card into the hand
     */
    public Card addCard(){

        Card card = deck.removeRandomCard();
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
        numberOfCards++;

        return card;
    }


    /**
     * Removes random card from the hand
     * returns the card
     */
    public Card removeRandomCard() {

        //Check if hand is empty then return null
        if (numberOfCards == 0) {
            System.out.println("Hand is empty!\n");
            return null;
        }
        //Initialize a random number based on number of cards left in hand
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

        //decrement numberOfCards to keep track of cards left in the hand
        numberOfCards--;

        //Checks to see if there are any cards in the hand
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
        else
            previous.setNext(current.getNext());


        return current;
    }


    /**
     * Removes a card by position
     * Prompts the user for input about the choice of position
     * Removes the card from the hand after input
     */
    public Card removeByPos(){

        if(numberOfCards == 0){
            System.out.println("Hand is empty!\n");
            return null;
        }

        promptForInput();
        int pos = scanner.nextInt();

        while(pos > numberOfCards){
            System.out.println("Not enough cards in the hand!\nPlease enter another value:- ");
            pos = scanner.nextInt();

        }
            Card current = head;
            Card dummy = new Card();
            dummy.setNext(head);
            Card previous = dummy;

            int count = 1;

            while (count < pos) {
                previous = previous.getNext();
                current = current.getNext();
                count++;
            }

            //decrement numberOfCards to keep track of cards left in the hand
            numberOfCards--;

            //Checks to see if there are any cards in the hand
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
            else
                previous.setNext(current.getNext());

            return current;
        }



    // Asks the user to enter the position of the card they want to remove from the hand
    private void promptForInput(){
        System.out.println("Please enter the position of card you want to remove:- ");
    }


    //Prints out the number of cards in the hand currently
    public void printNumberOfCards(){
        System.out.println("Number of cards in the hand:- " + getNumberOfCards());
    }


    //Print the Hand
    public String toString() {

        int cardsLeft = numberOfCards;
        if (cardsLeft == 0) {
            return "Hand is Empty!";
        }

        //String builder to store entire hand
        StringBuilder sb = new StringBuilder();

        Card current = head;

        while(cardsLeft > 0){
            System.out.println(current.toString());
            cardsLeft--;
            current = current.getNext();
        }

        return sb.toString();
    }

}
