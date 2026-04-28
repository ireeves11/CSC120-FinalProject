import java.util.ArrayList;

public class Ship {
    
    private int shipHealth;
    private ArrayList <Room> rooms;
    protected ArrayList <LivingThing> passengers;

    public Ship(){
        this.shipHealth = 10;
        this.rooms = new ArrayList();
        this.passengers = new ArrayList();
    }

    /**
     * gets the ship's health
     * @return
     */
    public int getHealth(){
        return this.shipHealth;
    }

    /**
     * fixes some of the ship at a time for a max of 10 health
     */
    public void fixShip(){
        if(this.shipHealth <= 7){
            this.shipHealth += 3;
        }
        else{
            this.shipHealth = 10;
        }
    }

    /**
     * reduces the ship's health by damage amount
     * @param damage amount of damage done to the ship
     */
    public void damageShip(int damage){
        this.shipHealth -= damage;
        //Need to add statement to address if the ship runs out of health and everyone dies
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public void addPassenger(LivingThing a){
        this.passengers.add(a);
    }
}
