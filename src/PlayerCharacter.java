import java.util.ArrayList;

public class PlayerCharacter extends LivingThing{

    private ArrayList<Item> inventory;

    public PlayerCharacter(String name){
        super(name);
    }

    public void pickUp(Item a){
        if(!inventory.contains(a)){
            inventory.add(a);
        }
        else{
            throw new RuntimeException("You already have this in your inventory!");
        }
    }

    public void putDown(Item a){
        if(inventory.contains(a)){
            inventory.remove(a);
        }
        else{
            throw new RuntimeException("This item isn't in your inventory anyway!");
        }
    }

    public void use(Item a){
        if(this.inventory.contains(a)){
            a.use();
        }
        else{
            throw new RuntimeException("That item isn't in your inventory, so how are you supposed to use it?");
        }
    }
    
    public void lookAround(Room a){
        System.out.print(a);
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }
}
