public class Knife extends Item{
    
    public Knife(Room room){
        super("Knife", true, room);
    }

    public void slash(){
        System.out.println("Woosh!");
    }

    public void slash(LivingThing a){
        a.getHit();
    }

    @Override
    public String toString(){
        return super.toString() + ". Be careful, it's sharp";
    }
}
