public class Bell extends Item{
    
    public Bell(Room room){
        super("Bell", true, room);
    }

    public void ring(Alien a){
        System.out.println("Ring!");
        if(this.getLocation().equals(a.getCurrentRoom())){
            a.echo();
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", if you were to shake it, it would make a lovely ringing sound";
    }
}
