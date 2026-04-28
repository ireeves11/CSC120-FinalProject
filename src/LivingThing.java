public class LivingThing{

    protected String name;
    protected boolean isAlive;
    protected Room currentRoom;
    protected int health;

    public LivingThing(String name, Room room, int health){
        this.name = name;
        this.isAlive = true;
        this.currentRoom = room;
        this.health = health;
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

    public void die(){
        this.isAlive = false;
    }

    public int getHealth(){
        return this.health;
    }

    public void getHit(){
        this.health -= 1;
        if(this.health == 0){
            this.die();
        }
    }

    public void goTo(Room room){
        if(this.currentRoom.getAdjacentRooms().contains(room)){
            this.currentRoom = room;
        }
        else if(this.currentRoom.equals(room)){
            throw new RuntimeException("You're already in that room!");
        }
        else{
            throw new RuntimeException("That's not a room you can reach right now");
        }
    }
}