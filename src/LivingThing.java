public class LivingThing{

    protected String name;
    protected boolean isAlive;
    protected Room currentRoom;

    public LivingThing(String name, Room room){
        this.name = name;
        this.isAlive = true;
        this.currentRoom = room;
    }

    public String getName(){
        return this.name;
    }

    public boolean getAliveness(){
        return this.isAlive;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }
    
}