public class Batteries extends Item{
    
    public Batteries(Room room){
        super("AA Batteries", true, room);
    }

    @Override
    public void use(){
        this.location = null;
        this.pickupable = false;
    }
}
