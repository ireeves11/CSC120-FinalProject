public class Gun extends Item{
    
    private int bullets;

    public Gun(Room room){
        super("Gun");
        this.bullets = 6;
    }

    public void shoot(){
        if(this.bullets > 0){
            this.bullets -= 1;
        }
        else{
            throw new RuntimeException("You don't have any bullets left!");
        }
    }

    public void shoot(LivingThing a){
        if(this.bullets > 0){
            this.bullets -= 1;
            a.getHit();
        }
        else{
            throw new RuntimeException("You don't have any bullets left!");
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", it has " + this.bullets + " left";
    }
}
