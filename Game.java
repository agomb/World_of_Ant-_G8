import java.util.ArrayList;
import java.util.List;
/**
 * Class Game 
 * Contains the main that allows to the user to start a game
 *
 * @author Group8
 * @version 13/11/2019
 */
public class Game
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private List<Room> room; //countain rooms of the map
    private Player playerChoose; //character plays by the player
    private Player playerUnplay; //character plays by the computer
    private Key theCreatedKey;
    private Special theCreatedSpecial;
    private int timer;
    private int count;
    private InterfaceGame interfaceGame;
    /**
     * Constructor of the Game
     */
    public Game()
    {
        room = new ArrayList<Room>();
        createRoom();

    }
    
    /**
     * Method to choose the player : deliveroo or stolen ant
     * 
     * @return type : "deliver" for deliveroo ant 
     *                "stolen" for stolen ant    
     */
    public Player getChoosenPlayer()
    {
      return playerChoose;
    }
    
    /**
     * Method that give if the player win or loose
     * It will check on the bag of the player : 
     * if the deliveroo ant have more than 5 deliveries on the bag 
     * or if the stolent ant have less than 5 deliveries on the bag 
     * the player is a looser !!
     *
     * @param  ant type of player (deliveroo or stolen)
     */
    public void result(Player ant)
    {
        
    }
    
    /**
     * This method initialize the doors and rooms
     * Each room of the underground has a number and the doors have directions
     *
     * @param  y   un paramètre pour cette méthode
     * @param  x   un autre paramètre
     * @return     la somme des deux paramètres
     */
    public void createRoom()
    {

        Key theCreatedKey1 = new Key("key1");
        Key theCreatedKey5 = new Key("key5");
        Key theCreatedKey6 = new Key("key6");
        Key theCreatedKey14 = new Key("key14");
        Key theCreatedKey25 = new Key("key25");
        Key theCreatedKeyRuby = new Key("keyRuby");
        
        Lock theCreatedLockRuby = new Lock(theCreatedKeyRuby);
        Lock Lock1 = new Lock(theCreatedKey1);
        Lock Lock5 = new Lock(theCreatedKey5);
        Lock Lock6 = new Lock(theCreatedKey6);
        Lock Lock14 = new Lock(theCreatedKey14);
        Lock Lock25 = new Lock(theCreatedKey25);        
        
        Special theCreatedSpecialBonus = new Special("bonus");
        Special theCreatedSpecialMalus = new Special("malus");
        
        TreasureBox box2 = new TreasureBox("Box2", theCreatedKey1, null);
        TreasureBox box6 = new TreasureBox("Box6", theCreatedKey5, null);
        TreasureBox box10 = new TreasureBox("Box10", null, theCreatedSpecialMalus);
        TreasureBox box20 = new TreasureBox("Box20", theCreatedKey6, theCreatedSpecialMalus);
        TreasureBox boxRuby = new TreasureBox("BoxRuby", null, theCreatedSpecialMalus, theCreatedLockRuby);
        TreasureBox boxC = new TreasureBox("BoxC", theCreatedKey14, theCreatedSpecialBonus);
        TreasureBox boxF = new TreasureBox("BoxF", theCreatedKey25, theCreatedSpecialMalus); 
        TreasureBox boxG = new TreasureBox("BoxG", theCreatedKeyRuby, null);
      
        

        // Here we create the rooms
        Room roomPlayer = new Room("PlayerRoom");
        room.add(roomPlayer);
        Room roomOpponent  = new Room("OpponentRoom");
        room.add(roomOpponent);
        Room room1 = new Room("1");
        room.add(room1);
        Room room2 = new Room("2");
        room.add(room2);
        Room room3 = new Room("3");
        room.add(room3);
        Room room4 = new Room("4");
        room.add(room4);
        Room room5 = new Room("5");
        room.add(roomPlayer);
        Room room6 = new Room("6");
        room.add(room6);
        Room room7 = new Room("7");
        room.add(room7);
        Room room8 = new Room("8");
        room.add(room8);
        Room room9 = new Room("9");
        room.add(room9);
        Room room10 = new Room("10");
        room.add(room10);
        Room room11 = new Room("11");
        room.add(room11);
        Room room12 = new Room("12");
        room.add(room12);
        Room room13 = new Room("13");
        room.add(room13);
        Room room14 = new Room("14");
        room.add(roomPlayer);
        Room room15 = new Room("15");
        room.add(room15);
        Room room16 = new Room("16");
        room.add(room16);
        Room room17 = new Room("17");
        room.add(room17);
        Room room18 = new Room("18");
        room.add(room18);
        Room room19 = new Room("19");
        room.add(room19);
        Room room20 = new Room("20");
        room.add(room20);
        Room room21 = new Room("21");
        room.add(room21);
        Room room22 = new Room("22");
        room.add(room22);
        Room room23 = new Room("23");
        room.add(room23);
        Room room24 = new Room("24");
        room.add(room24);
        Room room25 = new Room("25");
        room.add(room25);
        Room room26 = new Room("26");
        room.add(room26);
        Room room27 = new Room("27");
        room.add(room27);
        Room room28 = new Room("28");
        room.add(room28);
        Room room29 = new Room("29");
        room.add(room29);
        Room roomA = new Room("A");
        room.add(roomA);
        Room roomB = new Room("B");
        room.add(roomB);
        Room roomC = new Room("C");
        room.add(roomC);
        Room roomD = new Room("D");
        room.add(roomD);
        Room roomE = new Room("E");
        room.add(roomE);
        Room roomF = new Room("F");
        room.add(roomF);
        Room roomG = new Room("G");
        room.add(roomG);

        room2.addItem((Item)box2); 
        room6.addItem((Item) box6);
        room10.addItem((Item) box10); 
        room20.addItem((Item) box20); 
        room27.addItem((Item) boxRuby); 
        roomC.addItem((Item) boxC); 
        roomF.addItem((Item) boxF); 
        roomG.addItem((Item) boxG); 

        //Here we create the doors between two rooms - initialization of the Hashmap

               
        
        Delivery d1 = new Delivery("d1", roomA);
        Delivery d2 = new Delivery("d2", roomB);
        Delivery d3 = new Delivery("d3", roomC);
        Delivery d4 = new Delivery("d4", roomD);
        Delivery d5 = new Delivery("d5", roomE);
        Delivery d6 = new Delivery("d6", roomF);
        Delivery d7 = new Delivery("d7", roomG);
        Delivery d8 = new Delivery("d8", roomA);
        Delivery d9 = new Delivery("d9", roomB);
        Delivery d10 = new Delivery("d10", roomC);
        Delivery d11 = new Delivery("d11", roomD);
        Delivery d12 = new Delivery("d12", roomE);
        Delivery d13 = new Delivery("d13", roomF);
        Delivery d14 = new Delivery("d14", roomG);
        
        
        //if ( playerChoose instanceof DeliverooAnt){
            roomPlayer.addItem((Item)d1);
            roomPlayer.addItem((Item)d2);
            roomPlayer.addItem((Item)d3);
            roomPlayer.addItem((Item)d4);
            roomPlayer.addItem((Item)d5);
            roomPlayer.addItem((Item)d6);
            roomPlayer.addItem((Item)d7);
            roomPlayer.addItem((Item)d8);
            roomPlayer.addItem((Item)d9);
            roomPlayer.addItem((Item)d10);
            roomPlayer.addItem((Item)d11);
            roomPlayer.addItem((Item)d12);
            roomPlayer.addItem((Item)d13);
            roomPlayer.addItem((Item)d14);

        //}else{
            roomOpponent.addItem((Item)d1);
            roomOpponent.addItem((Item)d2);
            roomOpponent.addItem((Item)d3);
            roomOpponent.addItem((Item)d4);
            roomOpponent.addItem((Item)d5);
            roomOpponent.addItem((Item)d6);
            roomOpponent.addItem((Item)d7);
            roomOpponent.addItem((Item)d8);
            roomOpponent.addItem((Item)d9);
            roomOpponent.addItem((Item)d10);
            roomOpponent.addItem((Item)d11);
            roomOpponent.addItem((Item)d12);
            roomOpponent.addItem((Item)d13);
            roomOpponent.addItem((Item)d14);
        //}

        Door.createDoor(roomPlayer, "East", room1, "West");
        Door.createDoor(room1, "North", room2, "South");
        Door.createDoor(room1, "East", room3, "West", theCreatedKey1, Lock1);
        Door.createDoor(room3, "East", room4, "West");
        Door.createDoor(room4, "East", room5, "West");
        Door.createDoor(room5, "South", room6, "North");
        Door.createDoor(room6, "South", room7, "North", theCreatedKey6, Lock6);
        Door.createDoor(room7, "East", room8, "West");
        Door.createDoor(room8, "South", room9, "North");
        Door.createDoor(room9, "South", room10, "North");
        Door.createDoor(room10, "West", room11, "East");
        Door.createDoor(room11, "West", room12, "East");
        Door.createDoor(room12, "West", room13, "East");
        Door.createDoor(room13, "North", room14, "South");
        Door.createDoor(room15, "East", room14, "West", theCreatedKey14, Lock14);
        Door.createDoor(room14, "North", room16, "South");
        Door.createDoor(room16, "East", room17, "West");
        Door.createDoor(room17, "East", room7, "West");
        Door.createDoor(room18, "West", room5, "East", theCreatedKey5, Lock5);
        Door.createDoor(room18, "East", room19, "West");
        Door.createDoor(room19, "North", room20, "South");
        Door.createDoor(room20, "East", room21, "West");
        Door.createDoor(room21, "East", room22, "West");
        Door.createDoor(room22, "East", room23, "West");
        Door.createDoor(room23, "South", room24, "North");
        Door.createDoor(room24, "South", room25, "North");
        Door.createDoor(room25, "South", room26, "North", theCreatedKey25, Lock25);
        Door.createDoor(room26, "West", room28, "East");
        Door.createDoor(room28, "West", room29, "East");
        Door.createDoor(room26, "South", room27, "North");
        Door.createDoor(room27, "South", roomOpponent, "North");  
        Door.createDoor(room3, "Up", roomB, "Down");
        Door.createDoor(room18, "Up", roomD, "Down");
        Door.createDoor(room7, "Up", roomC, "Down");
        Door.createDoor(room15, "Up", roomA, "Down");
        Door.createDoor(room10, "Up", roomE, "Down");
        Door.createDoor(room29, "Up", roomG, "Down");
        Door.createDoor(room21, "Up", roomF, "Down");

        //roomG.addItem((Item)boxG);
    }
    
    public Player getPlayer(){
        return playerChoose;
    }
    
    public Player getComputer(){
        return playerUnplay;
    }
    
    public void createPlayer(boolean b){
        Room departPlayer  = null;
        Room departOpponent = null;
        
        for ( Room r : room) {
            if (r.getDescription() == "PlayerRoom"){
                departPlayer = r;
            }
            if (r.getDescription() == "OpponentRoom"){
                departOpponent = r;
            }        
        };
        
        
        if (b == true){
            playerChoose = new  StolenAnt("play", departPlayer);
            playerUnplay = new DeliverooAnt("unplay", departOpponent);
        }else{
            playerUnplay  = new  StolenAnt("unplay", departOpponent);
            playerChoose = new DeliverooAnt("play", departPlayer);
        }
        
        
    }
    
}