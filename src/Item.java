public class Item{
    
    protected String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void use(){
        System.out.println("How, exactly, do you 'use' a(n) " + this.getName());
    }

    @Override
    public String toString(){
        return "This is a " + this.name;
    }
}
