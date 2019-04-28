
public class Card {

    /**
     * variables
     * 1. face value of card as an integer (1-13)
     * 2. face value as a string (one - thirteen)
     * 3. suit value of the card as an integer (1-4)
     * 4. suit value as string
     * 5. unique id
     */
    private int faceValue;
    private String faceValueString;
    private int suitValue;
    private String suitValueString;
    private int id;

    private Card next;


    /* Constructor*/
    public Card() {
        this.next = null;
    }


    /**
     * Getter Methods
     */
    public int getFaceValue() {
        return faceValue;
    }

    public String getFaceValueString() {
        return faceValueString;
    }

    public int getSuitValue() {
        return suitValue;
    }

    public String getSuitValueString() {
        return suitValueString;
    }

    public int getId() {
        return id;
    }

    public Card getNext() {
        return next;
    }

    /**
     * Setter Methods
     */
    public void setFaceValueString(String faceValueString) {
        this.faceValueString = faceValueString;
    }

    public void setSuitValueString(String suitValueString) {
        this.suitValueString = suitValueString;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public void setSuitValue(int suitValue) {
        this.suitValue = suitValue;;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNext(Card next) {
        this.next = next;
    }



    public String toString() {
        return this.faceValueString + " of " + this.suitValueString;
    }
}
