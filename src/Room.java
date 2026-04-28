import java.util.ArrayList;

public class Room {
    
    private ArrayList <LivingThing> occupants;
    private boolean brokenLightbulbs;
    private String name;
    private ArrayList <Room> adjacentRooms;

    /**
     * defaults room constructor (empty room, lights on, no broken lightbulbs)
     * @param name name of the room
     */
    public Room(String name){
        this.occupants = new ArrayList();
        this.brokenLightbulbs = false;
        this.name = name;
        this.adjacentRooms = new ArrayList();
    }

    /**
     * another room constructor with more specifics
     * @param name name of room
     * @param lightsOn if the lights are on
     * @param occupants occupants starting in the room
     */ 
    public Room(String name, ArrayList <LivingThing> occupants){
        this.occupants = occupants;
        this.brokenLightbulbs = false;
        this.name = name;
    }

    /**
     * has a living thing enter a room and get added as an occupant
     * @param a the living thing entering the room
     */
    public void enter(LivingThing a){
        this.occupants.add(a);
    }

    public String getName(){
        return this.name;
    }

    /**
     * has a living thing leave a room and removed as an occupant
     * @param a living thing leaving the room
     */
    public void exit(LivingThing a){
        this.occupants.remove(a);
    }

    public boolean getBrokenLightbulbs(){
        return this.brokenLightbulbs;
    }

    //need to make a lightbulb object and add it here
    public void fixLightbulbs(){
        if (this.brokenLightbulbs){
            this.brokenLightbulbs = false;
        } else{
            throw new RuntimeException("The lightbulbs in the room aren't broken");
        }
    }

    public ArrayList<Room> getAdjacentRooms(){
        return this.adjacentRooms;
    }

    public String toString(){
        return "You are in the " + name;
    }

    public String darkToString(){
        return "You know that you should be in the " + name + ", but you can't see anything";
    }
}
