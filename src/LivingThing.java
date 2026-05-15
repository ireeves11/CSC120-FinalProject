public class LivingThing{

    protected String name;
    protected boolean isAlive;

    public LivingThing(String name){
        this.name = name;
        this.isAlive = true;
    }

    public void rename(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public boolean getAliveness(){
        return this.isAlive;
    }

    public void die(){
        this.isAlive = false;
    }

    public void kill(LivingThing a){
        a.die();
    }

    public void goTo(Room a, Room b){
        if(a.getOccupants().contains(this)){
            a.exit(this);
            b.enter(this);
        }
        else{
            throw new RuntimeException("What even happened bro");
        }
    }

    public void talk(){
        System.out.println("SCREEEEEEEEEEEETCH");
    }
}