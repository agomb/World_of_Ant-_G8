











import java.util.ArrayList;
//modif ici test pour git
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
        //interfaceGame = new InterfaceGame();
    }
    
    /**
     * Method to choose the player : deliveroo or stolen ant
     * 
     * @return type : "deliver" for deliveroo ant 
     *                "stolen" for stolen ant    
     */
    public String choosePlayer()
    {
      return "";
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
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   un paramètre pour cette méthode
     * @param  x   un autre paramètre
     * @return     la somme des deux paramètres
     */
    public void createRoom()
    {
        // Here we create the rooms
        Room roomPlayer = new Room("PlayerRoom");
        room.add(roomPlayer);
        Room roomOpponent = new Room("OpponentRoom");
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
        //Here we create the doors between two rooms - initialization of the Hashmap
        new Door(roomPlayer, "East", room1, "West");
        new Door(room1, "North", room2, "South");
        //new Door(room1, "East", room3, "West", theLock);
        new Door(room3, "East", room4, "West");
        new Door(room4, "East", room5, "West");
        new Door(room5, "South", room6, "North");
        //new Door(room6, "South", room7, "North", theLock);
        new Door(room7, "East", room8, "West");
        new Door(room8, "South", room9, "North");
        new Door(room9, "South", room10, "North");
        new Door(room10, "West", room11, "East");
        new Door(room11, "West", room12, "East");
        new Door(room12, "West", room13, "East");
        new Door(room13, "North", room14, "South");
        //new Door(room14, "East", room15, "West", theLock);
        new Door(room14, "North", room16, "South");
        new Door(room16, "East", room17, "West");
        new Door(room17, "East", room7, "West");
        //new Door(room5, "West", room18, "East", theLock);
        new Door(room18, "East", room19, "West");
        new Door(room19, "North", room20, "South");
        new Door(room20, "East", room21, "West");
        new Door(room21, "East", room22, "West");
        new Door(room22, "East", room23, "West");
        new Door(room23, "South", room24, "North");
        new Door(room24, "South", room25, "North");
        //new Door(room25, "South", room26, "North", theLock);
        new Door(room26, "West", room28, "East");
        new Door(room28, "West", room29, "East");
        new Door(room26, "South", room27, "North");
        new Door(room27, "South", roomOpponent, "North");  
    }
    
 
    
    public Player getPlayer(){
        return playerChoose;
    }
    
    public Player getComputer(){
        return playerUnplay;
    }
    
    public void createPlayer(boolean b){
        Room depart  = null;
        
        for ( Room r : room) {
            if (r.getDescription() == "PlayerRoom"){
                depart = r;
            }
            
        };
        
        if (b == true){
          playerChoose = new  StolenAnt("play", depart);
          playerUnplay = new DeliverooAnt("unplay", depart);
        }else{
          playerUnplay  = new  StolenAnt("unplay", depart);
          playerChoose = new DeliverooAnt("play", depart);
        }
    }
    
    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   un paramètre pour cette méthode
     * @param  x   un autre paramètre
     * @return     la somme des deux paramètres
     */
    public void createBox()
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
        TreasureBox boxH = new TreasureBox("BoxH", theCreatedKeyRuby, null);
    }
}