public class Alien extends LivingThing{
    
    public Alien(Room room){
        super("The Alien", room);
    }

    public void kill(Human p){
        p.die();
    }
}
