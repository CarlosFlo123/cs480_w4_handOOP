import java.util.*;
import java.lang.*;

class Palm implements Cloneable {
    ////////////////////////
    // Data memebers
    ////////////////////////
    private int size;

    //////////////////////////
    // Member functions
    /////////////////////////
    // Manager function
    public Palm(int size1) {
        this.size = size1;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // This shouldn't happen, since we are Cloneable
            return null;
        }
    }

    //////////////////////////
    // Member functions
    /////////////////////////
    // Access functions
    public boolean isLarge() {
        return this.size > 50;
    } // A palm is large if
      // size is larger than 50

    public int getSize() {
        return this.size;
    }

    public void setSize(int size1) {
        size = size1;
    }

    // Implementor function
    public void enlarge(int sizeInc) {
        this.size += sizeInc;
    }

    public void shrink(int sizeDec) {
        this.size -= sizeDec;
    }

    public String toString() { // See the Demo class to figure out how to
        return " Size of palm is " + this.size;                       // implement this function
    }
}

class Finger implements Cloneable {
    ////////////////////////
    // Data members
    ////////////////////////
    private int len;

    //////////////////////////
    // Member functions
    /////////////////////////
    // Manager function
    public Finger(int len1) {
        this.len = len1;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // This shouldn't happen, since we are Cloneable
            return null;
        }
    }

    // Access functions
    public boolean isLong() {
        return this.len > 30;
    } // A finger is long if
      // its length is longer than 30

    public int getLen() {
        return this.len;
    }

    public void setLen(int len1) {
        this.len = len1;
    }

    // Implementor function
    public void enlarge(int lenInc) {
        this.len += lenInc;
    }

    public void shrink(int lenDec) {
        this.len -= lenDec;
    }

    public String toString() { // See the example in the Demo class to figure
        return ("Lenght of finger is " + this.len);                       // out how to implement this function

    }
}

class Hand implements Cloneable {
    ////////////////////////
    // Data members
    ////////////////////////
    private Palm palm = new Palm(0);
    private Vector fingers;

    //////////////////////////
    // Member functions
    /////////////////////////

    // Manager function
    public Hand(Palm palm1, Vector<Finger> fingers1) {
        this.palm = (Palm) palm1.clone();
        this.fingers = (Vector) fingers1.clone();  //u can clone Vector as Object too
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // This shouldn't happen, since we are Cloneable
            return null;
        }
    }

    // Predicate function
    public boolean isNormal() {
        return this.fingers.size() == 5;
    } // A hand is normal if it
      // has 5 fingers
      // Access functions

    public Palm getPalm() {
        return this.palm;
    }

    public Finger getFinger(int i) {
        return this.fingers.elementAt(i);
    }

    public Vector getFingers() {
        return this.fingers;
    }

    // Implementor function
    public int numOfFingers() {
        return this.fingers.size();
    }

    public void lostOneFinger(int index) {
        this.fingers.remove(i);
    }

    public String toString() {
        String s = "";
        s += this.palm.toString() + "\n";
        for (int i = 0; i < this.fingers.size(); i++){
            s += ("\tFinger " + i + ": " + fingers.elementAt(i).toString() + "\n");
        }
        return s;
    }
}

/*
 * Will display
 * 
 * Experiment clone ... Size of palm is 15 Size of palm is 20 Size of palm is 20
 * 
 * Display information about Hand ... Size of palm is 20 Finger 0: Length of
 * finger is 3 Finger 1: Length of finger is 4 Finger 2: Length of finger is 5
 * 
 */
public class handOOP {
    public static void main(String argv[]) {
        System.out.println("\nExperiment clone ...");
        Palm palm = new Palm(15);
        System.out.println(palm); // print "Size of palm is 15"
        Palm palm1 = palm;
        palm1.setSize(20);
        System.out.println(palm); // print "Size of palm is 20"
        Palm palm2 = (Palm) palm.clone();
        palm2.setSize(30);
        System.out.println(palm); // print "Size of palm is 20"
        
        Vector fingers = new Vector();
        fingers.addElement(new Finger(3));
        fingers.addElement(new Finger(4));
        fingers.addElement(new Finger(5));

        System.out.println("\nDisplay information about Hand ...");
        Hand p = new Hand(palm, fingers);
        System.out.println(p);
    }
}