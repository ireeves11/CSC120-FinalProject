public class Note extends Item{

    private String contents;

    public Note(){
        super("Note");
        this.contents = "Don't forget to call Mom today!";
    }

    public void read(){
        System.out.println("You pick up the note. It reads: " + contents);
    }
    
}
