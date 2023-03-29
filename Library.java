/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building{

    private Hashtable<String, Boolean> collection;
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
    }

    public Hashtable<String, Boolean> getCollection() {
      return this.collection;
    }


    public void addTitle(String title){
      try{
        if(this.collection.containsKey(title)){
          throw new RuntimeException("This book is already in the library.");
        } 
        else{
          this.collection.put(title, true);
        }
      }
        catch (RuntimeException e){
          System.out.println(e);
           
        } 
    }

    

    public String removeTitle(String title){
      try{
        if(!this.collection.containsKey(title)){
          throw new RuntimeException(title + " isn't in the library");
        } 
        else{
          this.collection.remove(title);
        }
      }
        catch (RuntimeException e){
          System.out.println(e);
           
        } 
        return(title); 
  }

  

    public void checkOut(String title){
      try{
        if(!this.collection.containsKey(title)){
          throw new RuntimeException(title + " does not exist in the library.");
        } else if (this.collection.get(title).equals(false)){
            throw new RuntimeException(title + " has not been returned to the library.");
          }
        else{
          this.collection.replace(title, false);
          System.out.println(title + " has successfully been checked out.");
        }
      }
        catch (RuntimeException e){
          System.out.println(e);
           
        } 
    }


    public void returnBook(String title){
      try{
        if(!this.collection.containsKey(title)){
          throw new RuntimeException(title + " does not exist in the library.");
        } else if (this.collection.get(title).equals(true)){
            throw new RuntimeException(title + " has already been returned to the library.");
          }
        else{
          this.collection.replace(title, true);
          System.out.println(title + " has been returned.");
        }
      }
        catch (RuntimeException e){
          System.out.println(e);
           
        } 
    }

  

    // returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean containsTitle(String title){
      if(this.collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
    } 

    


    // returns true if the title is currently available, false otherwise
    public boolean isAvailable(String title){
      if (this.collection.get(title).equals(true)){
        return true;
      }
      else{
        return false;
        }
      }

      public String toString() {
        String description = super.toString();
        description += " There are currently " + this.collection.size() + " books in this collection.";
        return description;
      }
  
    // prints out the entire collection in an easy-to-read way (including checkout status)
    public void printCollection(){
      System.out.println(this.collection.toString());
    }
    

    public static void main(String[] args) {
      Library nielson = new Library("Nielson", "Smith College", 4);
      nielson.addTitle("The Lorax by Dr. Seuss");
      System.out.println(nielson);
      nielson.printCollection();
      nielson.isAvailable("The Lorax by Dr. Seuss");
      nielson.containsTitle("The Lorax by Dr. Seuss");
      // nielson.checkOut("The Lorax by Dr. Seuss");
      // nielson.returnBook("The Lorax by Dr. Seuss");
      // nielson.checkOut("The Lorax by Dr. Seuss");
      // nielson.removeTitle("The Lorax by Dr. Seuss");
      nielson.checkOut("The Lorax by Dr. Seuss");
      nielson.addTitle("Bible");
      nielson.returnBook("Bible");
    }
  
  }