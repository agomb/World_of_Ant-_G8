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
    // variables d'instance - 
    private List<Room> room; //countain rooms of the map
    private Player playerChoose; //character plays by the player
    private Player playerUnplay; //character plays by the computer
    private Key theCreatedKey;
    private Special theCreatedSpecial;
    private int timer;
    private int count;
    private InterfaceBegin interfaceBegin;
    private Lock theLock;
    /**
     * Constructor of the Game
     */
    public Game()
    {
        room = new ArrayList<Room>();
        
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
     *Each room of the underground has a number and the doors have directions 
     *
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
        room2.addItem((Item)box2);
        Room room3 = new Room("3");
        room.add(room3);
        Room room4 = new Room("4");
        room.add(room4);
        Room room5 = new Room("5");
        room.add(roomPlayer);
        Room room6 = new Room("6");
        room.add(room6);
        room6.addItem((Item)box6);
        Room room7 = new Room("7");
        room.add(room7);
        Room room8 = new Room("8");
        room.add(room8);
        Room room9 = new Room("9");
        room.add(room9);
        Room room10 = new Room("10");
        room.add(room10);
        room10.addItem((Item)box10);
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
        room20.addItem((Item)box20);
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
        room27.addItem((Item)boxRuby);
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
        roomC.addItem((Item)boxC);
        Room roomD = new Room("D");
        room.add(roomD);
        Room roomE = new Room("E");
        room.add(roomE);
        Room roomF = new Room("F");
        room.add(roomF);
        roomF.addItem((Item)boxF);
        Room roomG = new Room("G");
        room.add(roomG);
        roomG.addItem((Item)boxG);
        
        
        
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