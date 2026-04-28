import java.util.ArrayList;

public class Alien extends LivingThing{
    
    private ArrayList<LivingThing> puppets;

    public Alien(Room room){
        super("The Alien", room, 2);
        this.puppets = new ArrayList();
        this.health = 2;
    }

    public void kill(LivingThing p){
        p.die();
        puppets.add(p);
    }

    public void usePuppet(){
        if(!puppets.isEmpty()){
            puppets.get(puppets.size()-1);
        }
    }

    public void addPuppets(Human a){
        this.puppets.add(a);
    }

    public void echo(){
        System.out.println("ring! ring! ring!");
    }

}
