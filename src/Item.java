public class Item{
    
    protected String name;
    protected boolean pickupable;
    protected Room location;

    public Item(String name, boolean pickUp, Room location){
        this.name = name;
        this.pickupable = pickUp;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public void setCanPickUp(boolean can){
        this.pickupable = can;
    }

    public boolean canPickUp(){
        return this.pickupable;
    }

    //when being picked up, set the room to "Inventory"
    public void setLocation(Room room){
        this.location = room;
    }

    public Room getLocation(){
        return this.location;
    }

    public void use(){
        System.out.println("How, exactly, do you 'use' a(n) " + this.getName());
    }

    @Override
    public String toString(){
        return "This is a " + this.name;
    }
}
