package q2;

/**
 * @invariant NVector object length > 0.
 */
public class NVector {
    /**
     * Constructor to initialize vector values to 0 with size n.
     * @param n size of vector.
     * @precondition n > 0
     * @postcondition v.length() > 0
     */
    public NVector(int n){
        v = new double[n];
    }

    /**
     * Constructor with copying another NVector object.
     * @param other the NVector object being copied.
     * @precondition other.length() > 0
     * @postcondition v.length() > 0
     */
    public NVector(NVector other){
        v = other.v;
    }

    /**
     * Vararg NVector constructor.
     * @param v The arguments being put into the vector.
     * @precondition none
     * @postcondition this.v.length() > 0
     */
    public NVector(double... v){
        this.v = v;
    }

    /**
     * Returns the vectors size.
     * @return the size of the vector.
     */
    public int length(){
        return v.length;
    }

    /**
     * Returns the element at index i of vector.
     * @param i index of the element to return.
     * @return The element at index i in the vector.
     * @precondition length() > 0
     * @postcondition none
     */
    public double get(int i){
        return v[i];
    }

    /**
     * Checks if vectors are equal.
     * @param other NVector object to compare.
     * @return True if equal, false if not.
     * @precondition other.length() > 0
     * @postcondition none
     */
    public boolean equals(NVector other){
        if(length() == other.length()){
            for(int i = 0; i < length(); i++){
                if(v[i] != other.get(i))
                    return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Changes the element at an index in the vector.
     * @param i index to swap element.
     * @param x value to set at index.
     * @return New copy of NVector object with changed element.
     * @precondition length() > 0, i >= 0
     * @postcondition length() > 0
     */
    public NVector set(int i, double x){
        NVector c = new NVector(this);
        c.v[i] = x;
        return c;
    }

    /**
     * Adds two NVector objects together.
     * @param other NVector object being added.
     * @return The result of both NVector objects being added.
     * @precondition length() > 0
     * @postcondition length() > 0
     */
    public NVector add(NVector other){
        if(length() != other.length()){
            System.out.println("Can not add two unequal sized vectors");
            return null;
        }
        else {
            NVector result = new NVector(length());
            for(int i = 0; i < v.length; i++)
                result.v[i] = v[i] + other.v[i];
            return result;
        }
    }

    /**
     * Performs scalar product of two NVector objects.
     * @param other NVector object used in scalar product.
     * @return The scalar product of both NVector objects.
     * @precondition length() > 0, other.length() > 0
     * @postcondition length() > 0
     */
    public double sprod(NVector other){
        if(length() != other.length()){
            System.out.println("Can not find scalar product two unequal sized vectors");
            return 0;
        }
        else {
            double result = 0;
            for(int i = 0; i < v.length; i++)
                result += v[i] * other.v[i];
            return result;
        }
    }

    /**
     * Overridden toString method to print NVector object.
     * @return Formatted string representation of NVector object.
     * @precondition none
     * @postcondition none
     */
    public String toString(){
        String s = "[";
        for(int i = 0; i < v.length; i++) {
            if (i == 0) {
                s += v[i];
            } else
                s += " " + v[i];
        }
        s += "]";
        return s;
    }

    /**
     * Main method that shows how the methods are used
     */
    public static void main(String[] args) {
        NVector v0 = new NVector(4);
        NVector v1 = new NVector(1, 2, 3, 4);
        NVector v2 = new NVector(5, 6, 7, 8);
        System.out.println("v0 is " + v0);
        System.out.println("v1 is " + v1);
        System.out.println("v2 is " + v2);
        System.out.println("Assigning v3 = v2.set(1,2) ");
        NVector v3 = v2.set(1, 2);
        NVector v4 = new NVector(v3);
        System.out.println("v3 is " + v3);
        System.out.println("v4 is " + v4);
        System.out.println("length of v3 = " + v3.length());
        System.out.println("v1 + v3 (addition) = " + v1.add(v3));
        System.out.println("v1 * v3 (scalar prod) = " + v1.sprod(v3));
    }
    public double[] v;
}