import java.util.ArrayList;

public class Human extends LivingThing{
    
    protected ArrayList<Item> inventory;
    protected boolean isPuppet; //may not be necessary?
    protected String job;

    public Human(String name, Room room){
        super(name,room, 1);
        this.inventory = new ArrayList();
        this.isPuppet = false;
    }

    public boolean puppetStatus(){ //
        return this.isPuppet;
    }

    public void becomePuppet(){ //
        this.isPuppet = true;
    }

    public void stopUsingPuppet(){ //
        this.isPuppet = false;
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public void use(Item x){

    }

    public void dropItem(Item i){
        this.inventory.remove(i);
        i.setLocation(this.currentRoom);
    }

    @Override
    public String toString(){
        return "You see " + this.name + " they are doing whatever it is they do...";
    }

    public String darkToString(){
        return "You think you see " + this.name + " but you can't see them very well";
    }

    public String deadToString(){
        return "You see " + this.name + "'s body being held up. Blood is splattered on their clothes and they start at you with empty eyes.";
    }
}
