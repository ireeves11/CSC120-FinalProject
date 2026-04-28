public class Flashlight extends Item{
    
    private boolean isOn;
    private int batteryLife;

    public Flashlight(Room room){
        super("Flashlight", true, room);
        this.isOn = false;
        this.batteryLife = 15;
    }

    @Override
    public void use(){
        if(this.isOn){
            throw new RuntimeException("You're already using your the Flashlight");
        } 
        else if(this.batteryLife == 0){
            throw new RuntimeException("You're Flashlight is dead! It needs new batteries");
        }
        else{
            this.isOn = true;
        }
    }

    public void replaceBatteries(Batteries doubleA){
        this.batteryLife = 15;
        doubleA.use();
    }

    public void turnOff(){
        if(this.isOn){
            this.isOn = false;
        } else{
            throw new RuntimeException("The Flashlight is already off");
        }
    }

    public boolean getIsOn(){
        return this.isOn;
    }

    public String onOrOff(){
        if(this.isOn){
            return "On";
        }
        else{
            return "Off";
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", it is currently " + this.onOrOff();
    }

}
