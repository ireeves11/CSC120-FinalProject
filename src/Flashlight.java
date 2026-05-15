public class Flashlight extends Item{
    
    private boolean isOn;

    public Flashlight(){
        super("Flashlight");
        this.isOn = false;
    }

    @Override
    public void use(){
        if(this.isOn){
            throw new RuntimeException("You're already using your the Flashlight");
        } 
        else{
            this.isOn = true;
        }
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
