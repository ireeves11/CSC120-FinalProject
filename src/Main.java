import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Item potato = new Item("Potato");
        Knife knife = new Knife();
        Note note = new Note();

        Human gregg = new Human("Gregg");
        String dialogue1 = "Captain! I heard something in the storage room, and it made me nervous. Would you go check it out?";
        String dialogue2 = "Did you look in the storage room? No? What, are you too scared?";
        String dialogue3 = "What was in the storage room? \n...A what.\nOh god, we're all going to die!";

        LivingThing alien = new LivingThing("The Alien");

        PlayerCharacter pc = new PlayerCharacter("Placeholder Name");

        Ship spaceship = new Ship();

        Room storage = new Room("Storage", "It is a small room tightly packed with necessary supplies for your trip.");
        storage.addItem(note);
        storage.enter(alien);


        Room commonArea = new Room("Common area", "A cozy area with a couch and faux fireplace. This is where you and Gregg hang out while on long trips.");
        commonArea.addItem(potato);
        commonArea.enter(gregg);
        commonArea.enter(pc);


        Room cockpit = new Room("Cockpit", "This is where the magic happens. Lots of panelling with buttons and dials, all of which you are familiar with. Luckily, the ship is on autopilot at the moment, otherwise you'd be stuck in here, unable to wander about.");
        cockpit.addItem(knife);

        spaceship.addRoom(storage);
        spaceship.addRoom(commonArea);
        spaceship.addRoom(cockpit);

        cockpit.addAdjacentRooms(storage);
        cockpit.addAdjacentRooms(commonArea);
        commonArea.addAdjacentRooms(storage);
        commonArea.addAdjacentRooms(cockpit);
        storage.addAdjacentRooms(commonArea);
        storage.addAdjacentRooms(cockpit);

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to my game! Enter the word 'quit' to stop playing at any time.");
        System.out.println("In general, you are able to 'go' to rooms, 'use' items, 'talk' to people");
        System.out.println("Please enter your character's name: ");
        String input = sc.nextLine();
        pc.rename(input);

        System.out.println("You are currently on board your ship, travelling from one planet to the next with your friend and copilot Gregg.");
        System.out.println("What room on the ship would you like to start in? Storage, Common Area, or Cockpit? ");
        input = sc.nextLine().toLowerCase();

        boolean talkedToGregg = false;
        boolean beenInStorage = false;
        boolean talkedToAlien = false;

        while(!input.equals("quit") && pc.getAliveness()){

            while(commonArea.getOccupants().contains(pc)){

                //gives info on common area
                if(input.contains("common area") || input.contains("help")){
                    System.out.println(commonArea + "\nWhat would you like to do?");
                }

                input = sc.nextLine().toLowerCase();

                //goes to storage
                if(input.contains("go to") && input.contains("storage")){
                    pc.goTo(commonArea,storage);
                    break;
                }

                //goes to cockpit
                else if(input.contains("go to") && input.contains("cockpit")){
                    pc.goTo(commonArea,cockpit);
                    break;
                }

                //grabs potato
                else if((input.contains("pick up") || input.contains("grab")) && input.contains("potato")){
                    try {
                        pc.pickUp(potato);
                        commonArea.removeItem(potato);
                        System.out.println("You picked up the potato");
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //attempts to use potato
                else if(input.contains("use") && input.contains("potato")){
                    try {
                        potato.use();
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //uses knife and kills gregg
                else if((input.contains("attack") || input.contains("use")) && input.contains("knife") && input.contains("gregg")){
                    if(pc.getInventory().contains(knife)) {
                        knife.use(gregg);
                        gregg.rename("dead Gregg");
                        System.out.println("You killed gregg! How could you?!");
                    } else {
                        System.out.println("You don't have a knife in your inventory yet. Pick it up and try again.");
                    }
                }

                //uses knife nonlethally
                else if(input.contains("use") && input.contains("knife")){
                    try {
                        pc.use(knife);
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //attempts to use note if in inventory
                else if(input.contains("use") && input.contains("note")){
                    try {
                        note.use();
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //reads note if its in your inventory
                else if(input.contains("read") && input.contains("note")){
                    if(pc.getInventory().contains(note)){
                        note.read();
                    }
                    else{
                        System.out.println("You don't have a note. What are you doing?");
                    }
                }

                //you talk with gregg and get one of 3 dialogue options depending on your alien interactions and if you've talked to him before
                else if(input.contains("talk") && input.contains("gregg")){
                    System.out.println("You go over to Gregg.\n");
                    if(!talkedToGregg && !beenInStorage){
                        gregg.talk(dialogue1);
                    }
                    else if(talkedToGregg && !beenInStorage){
                        gregg.talk(dialogue2);
                    }
                    else if(beenInStorage){
                        gregg.talk(dialogue3);
                    }

                }

                else{
                    System.out.println("Sorry, I don't think I understood what you were trying to do.\nTry using some of the keywords 'go to', 'use', or 'pick up', and remember that if you're doing it to someone or with something to include the person/object" +
                    "s name in the command!");
                }

            }

            while(storage.getOccupants().contains(pc)){

                //informational center
                if(input.contains("storage") || input.contains("help")){
                    System.out.println(storage + "\nWhat would you like to do?");
                }

                input = sc.nextLine().toLowerCase();

                //moves you to the common area
                if(input.contains("go to") && (input.contains("common area") || input.contains("common room"))){
                    pc.goTo(storage, commonArea);
                    break;
                }

                //moves you to the cockpit
                else if(input.contains("go to") && input.contains("cockpit")){
                    pc.goTo(storage,cockpit);
                    break;
                }

                //talks to alien, angering it
                else if(input.contains("talk") && input.contains("alien")){
                    alien.talk();
                    talkedToAlien = true;
                    System.out.println("The alien looks mad...");
                }

                //picks up the note and adds it to inventory
                else if((input.contains("pick up") || input.contains("grab")) && input.contains("note")){
                    if(talkedToAlien){
                        pc.die();
                        System.out.println("The alien, still mad from when you talked to it, lunges forward, knocking you into the storage shelving. Your head hits the floor with a crack, and you die on impact.");
                        input = "quit";
                        break;
                    }
                    try {
                        pc.pickUp(note);
                        storage.removeItem(note);
                        System.out.println("You picked up the note");
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //reads the note. if you talked to the alien, it kills you after
                else if(input.contains("read") && input.contains("note")){
                    note.read();
                    if(talkedToAlien){
                        System.out.println("While reading the note, the alien slowly creeps across the room. It seems to be angry at you from when you talked to it and decides your time would be better spent in it's stomach. The alien eats you.");
                        pc.die();
                        input = "quit";
                        break;
                    }
                }

                //attempts to use knife- successfully kills alien if you have it, but you die if you don't.
                else if((input.contains("attack") || input.contains("use")) && input.contains("knife") && input.contains("alien")){
                    try {
                        knife.use(alien);
                        alien.rename("dead Alien");
                        System.out.println("You killed the alien! Congratulations!");
                        input = "quit";
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                        System.out.println("The alien correctly interprets your motion as an attempted attack, and in retaliation takes out its own knife and stabs you to death.");
                        pc.die();
                        input = "quit";
                        break;
                    }
                }

                //uses knife nonlethally
                else if(input.contains("use") && input.contains("knife")){
                    try {
                        pc.use(knife);
                        System.out.println("The alien takes this as a threat and throws a box at you, crushing you to death");
                        pc.die();
                        input = "quit";
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                        System.out.println("Regardless, the alien takes this as a threat and jumps on you, crushing you to death.");
                        pc.die();
                        input = "quit";
                        break;
                    }
                }
                
                //Attempts to use potato, die if have talked to alien
                else if(input.contains("use") && input.contains("potato")){
                    try {
                        potato.use();
                        System.out.println("..you actually have an answer for that now. The alien seems happy, trills a bit, and then scampers off before you look out the window and see it swimming through space towards the planet you just came from.");
                        input = "quit";
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                    if(talkedToAlien){
                        System.out.println("Your attempt to use a potato, whether or not in your posession, irritated the alien further, causing it to spin around in distress. It's barbed tail whacks into you, puncturing some of your more important arteries, killing you.");
                        pc.die();
                        input = "quit";
                        break;
                    }
                }

                else{
                    System.out.println("Sorry, I don't think I understood what you were trying to do.\nTry using some of the keywords 'go to', 'use', or 'pick up', and remember that if you're doing it to someone or with something to include the person/object" +
                    "s name in the command!");
                }

            }

            while(cockpit.getOccupants().contains(pc)){
                //informational center
                if(input.contains("cockpit") || input.contains("help")){
                    System.out.println(cockpit + "\nWhat would you like to do?");
                }

                input = sc.nextLine().toLowerCase();

                //moves you to the common area
                if(input.contains("go to") && (input.contains("common area") || input.contains("common room"))){
                    pc.goTo(cockpit, commonArea);
                    break;
                }

                //moves you to the cockpit
                else if(input.contains("go to") && input.contains("storage")){
                    pc.goTo(cockpit,storage);
                    break;
                }
                
                //picks up knife
                else if((input.contains("pick up") || input.contains("grab")) && input.contains("knife")){
                    try {
                        pc.pickUp(knife);
                        cockpit.removeItem(knife);
                        System.out.println("You picked up the knife. Be careful, it's sharp.");
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //tries to use knife non-lethally
                else if(input.contains("use") && input.contains("knife")){
                    try {
                        pc.use(knife);
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //attempts to use note if in inventory
                else if(input.contains("use") && input.contains("note")){
                    try {
                        note.use();
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                //reads note if its in your inventory
                else if(input.contains("read") && input.contains("note")){
                    if(pc.getInventory().contains(note)){
                        note.read();
                    }
                    else{
                        System.out.println("You don't have a note. What are you doing?");
                    }
                }

                //attempts to use potato
                else if(input.contains("use") && input.contains("potato")){
                    try {
                        potato.use();
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                else{
                    System.out.println("Sorry, I don't think I understood what you were trying to do.\nTry using some of the keywords 'go to', 'use', or 'pick up', and remember that if you're doing it to someone or with something to include the person/object" +
                    "s name in the command!");
                }

            }
        }
    }
}

