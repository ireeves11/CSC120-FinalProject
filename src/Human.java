
public class Human extends LivingThing{
    
    public Human(String name){
        super(name);
    }

    public void talk(String dialogue){
        System.out.println(this.name + " says: " + dialogue);
    }
}
