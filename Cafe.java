/* This is a stub for the Cafe class */
public class Cafe extends Building {

    // The number of ounces of coffee remaining in inventory
    private int nCoffeeOunces; 

    // The number of sugar packets remaining in inventory
    private int nSugarPackets; 

    // The number of "splashes" of cream remaining in inventory
    private int nCreams; 

    // The number of cups remaining in inventory
    private int nCups; 
    /**
     * 
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    /**
     * Creates a Cafe object
     *@param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     * @return a new cafe object with a name, address,  floor amount, nCoffeeOunces, nSugarPackets, nCreams, and nCups.
     * in the format [name] is a [nFloors]-building located at [address].
     */

    /*Accessor for nCoffeeOunces */
    public int nCoffeeOunces(){
        return this.nCoffeeOunces;
    }
    /*Accessor for nSugarPackets */
    public int nSugarPackets(){
        return this.nSugarPackets;
    }
    /*Accessor for nCreams */
    public int nCreams(){
        return this.nCreams;
    }
    /*Accessor for nCups */
    public int nCups(){
        return this.nCups;
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        try{
            if(this.nCoffeeOunces <= size-1 | this.nSugarPackets <= nSugarPackets-1 | this.nCreams <= nCreams-1 | this.nCups == 0){
                throw new RuntimeException("We are low on our inventory to make coffee. Comeback another time.");
            } this.nCoffeeOunces -= size;
              this.nSugarPackets -= nSugarPackets;
              this.nCreams -= nCreams;
              this.nCups -= 1;
              System.out.println("Thank you for your purchase!");
        } catch (RuntimeException e){
            System.out.println(e);
            this.restock(size, nSugarPackets, nCreams, 1);
            }
    }
    /**
     * 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if(this.nCoffeeOunces < nCoffeeOunces){
            this.nCoffeeOunces = nCoffeeOunces+20;
        }
        if(this.nSugarPackets < nSugarPackets){
            this.nSugarPackets = nSugarPackets+10;
        }
        if(this.nCreams < nCreams){
            this.nCreams = nCreams+10;
        }
        if(this.nCups < nCups){
            this.nCups = nCups+5;
        }
    } 
    /**
     * restocks nCoffeeOunces, nSugarPackets, nCreams, and nCups so that a coffee can be made
     * @param args
     */


    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass", "Smith College", 1, 12, 12, 12, 12);
        System.out.println(compass);
        compass.sellCoffee(16, 13, 13);
        compass.sellCoffee(16, 13, 13);
    }
    
}
