public class Lightbulb extends Item{
    
    private boolean isBroken;

    public Lightbulb(Room room){
        super("Lightbulb", true, room);
        this.isBroken = false;
    }

    public void shatter(){
        this.isBroken = true;
    }

    public boolean getIsBroken(){
        return this.isBroken;
    }
}
