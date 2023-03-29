import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // check if this.residents contains name
    try{
      if (this.residents.contains(name)){
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resdient of " + this.name);
    }
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
    }
    catch (RuntimeException e){
      System.out.println(e);
    }
  }
  public String moveOut(String name){
    try{
      if (!this.residents.contains(name)){
          throw new RuntimeException(name + " doesn't live in " + this.name);
    }
    this.residents.remove(name);
    System.out.println(name + " has moved out of " + this.name);

  }
    catch (RuntimeException e){
    System.out.println(e);
    
    }
    return name;
  }


  public boolean isResident(String person){
    if (this.residents.contains(name)){
      return true;
    }
    else{
      return false;
    }
  }
  

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    // House morrow = new House("Morrow", "The Quad", 4, false);
    // System.out.println(morrow);
    // morrow.moveIn("Jordan");
    // morrow.moveIn("Jordan");
    // System.out.println(morrow);
    House king = new House("King", "The Quad", 3, true);
    System.out.println(king);
    king.moveIn("Tabby");
    king.moveIn("Liz");
    king.moveOut("Tabby");
    king.isResident("Tabby");
    king.isResident("Liz");
    System.out.println(king);
  }

}