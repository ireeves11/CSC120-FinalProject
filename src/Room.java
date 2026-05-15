import java.util.ArrayList;

public class Room {
    
    private ArrayList <LivingThing> occupants;
    private ArrayList <Item> things;
    private boolean brokenLightbulbs;
    private String name;
    private String description;
    private ArrayList <Room> adjacentRooms;

    /**
     * defaults room constructor (empty room, lights on, no broken lightbulbs)
     * @param name name of the room
     */
    public Room(String name, String description){
        this.occupants = new ArrayList();
        this.brokenLightbulbs = false;
        this.name = name;
        this.things = new ArrayList();
        this.description = description;
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

    public String getName(){
        return this.name;
    }
    
    public ArrayList<Item> getItems(){
        return this.things;
    }

    public ArrayList<LivingThing> getOccupants(){
        return this.occupants;
    }

    public void addItem(Item a){
        this.things.add(a);
    }

    public void removeItem(Item a){
        this.things.remove(a);
    }

    public ArrayList<Room> getAdjacentRooms(){
        return this.adjacentRooms;
    }

    public void addAdjacentRooms(Room a){
        this.adjacentRooms.add(a);
    }

    //need to make a lightbulb object and add it here
    public void fixLightbulbs(){
        if (this.brokenLightbulbs){
            this.brokenLightbulbs = false;
        } else{
            throw new RuntimeException("The lightbulbs in the room aren't broken");
        }
    }

    public String toString(){
        return "You are in the " + this.name + ". " + this.description + " This room is adjacent to the " + this.adjacentRooms + "rooms\nYou can clearly see the following things in the room:\n" + this.things + " You know the following...people are in the room as well:\n" + this.occupants ;
    }

    public String darkToString(){
        return "You know that you should be in the " + this.name + ", but you can't see anything";
    }
}
