public class Knife extends Item{
    
    public Knife(){
        super("Knife");
    }

    public void use(LivingThing a){
        a.die();
    }

    public void use(){
        System.out.println("Be careful with that thing!");
    }

    @Override
    public String toString(){
        return super.toString() + ". Be careful, it's sharp";
    }
}
