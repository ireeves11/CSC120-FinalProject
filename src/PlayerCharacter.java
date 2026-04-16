public class PlayerCharacter extends Human{
    
    public PlayerCharacter(String name, Room room){
        super(name, room);
    }

    public String getName(){
        return this.name;
    }
}
