import java.util.ArrayList;

public class Human extends LivingThing{
    
    private ArrayList<Item> inventory;
    private Item currentItem;

    public Human(String name, Room room){
        super(name,room);
        this.inventory = new ArrayList();
        currentItem = null;
    }

    public void die(){
        this.isAlive = false;
    }

    public void grabItem(Item x){
        if (x.canPickUp()){
            this.inventory.add(x);
        }
        else{
            throw new RuntimeException("You can't pick up this object");
        }
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public Item getCurrentItem(){
        return this.currentItem;
    }

    public void use(Item x){

    }
}
