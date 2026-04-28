public class PlayerCharacter extends Human{
    
    public PlayerCharacter(String name, Room room){
        super(name, room);
    }

    public void grabItem(Item x){
        if (x.canPickUp()){
            this.inventory.add(x);
        }
        else{
            throw new RuntimeException("You can't pick up this object");
        }
    }

    public void perceive(Human a){
        if(!this.currentRoom.getBrokenLightbulbs()){  //add flashlight option here too

        }else{
            System.out.println(a.darkToString());
        }
    }

    public void perceive(Room a){
        if(!this.currentRoom.getBrokenLightbulbs()){ //also add flashlight option here too
            
        }else{
            System.out.println(a.darkToString());
        }
    }
}
