import java.util.Random;
import java.util.Scanner;
/**
* Klasse GameMaster. 
* Die Größe des Spielfelds wird als Kommandozeilen-Argument übergeben. 
* MapObject-Objekten werden züfällig platziert.
* Es wird genau ein Ring platziert.
* Jede Runde wird der Spieler nach einer Aktion gefragt. 
* Spieler kann zwischen "walk", "take", "drop Name", "map" und "inv" wählen.
* Das Spiel endet, wenn der Spieler den Ring aufnimmt.
*/
public class GameMaster {
	
    public static void main(String[] args) {
		
		int mapSize = 0;
		while (mapSize < 2) {
			System.out.println("Type a natural number bigger than 1 to create a map of that size: ");
			Scanner scanner = new Scanner(System.in);
			mapSize = scanner.nextInt();
			scanner.close();
		}
		
		Map map = new Map(mapSize);
		map = fillTheMap(map, mapSize);
		
		Player player = new Wizard();
		map.printMap(player.getX(), player.getY());
		
		System.out.println("Type: 'map' to print the map, 'inv' to print your inventory,");
		System.out.println("      'take' to take the item, 'drop nameOfItem' to drop the item,");
		System.out.println("      'walk N', 'walk S', 'walk W' or 'walk E' to move north, south, west or est.");
		System.out.println("The game ends when you took the Ring.");
		boolean foundRing = false; 
		while (foundRing == false) {
			System.out.println("What do you want to do?");
			Scanner input = new Scanner(System.in);
			String eingabe = input.nextLine();
			int len = eingabe.length();
			input.close();
			
			if (eingabe.equals("walk N")) {
				if (map.checkCoordinates(player.getX() - 1, player.getY()) == false) {
					System.out.println("The edge of the map is reached! You cannot walk north.");	
					continue;
				}
				if ((map.checkCoordinates(player.getX() - 1, player.getY()) == true) && (map.getObject(player.getX() - 1, player.getY()) == null)) {
					player.setX(player.getX() - 1);
					System.out.println("Gone N.");
					continue;
				} 
				if ((map.checkCoordinates(player.getX() - 1, player.getY()) == true) && (map.getObject(player.getX() - 1, player.getY()) != null)) {
					if (map.getObject(player.getX() - 1, player.getY()).getCollision() == false) {
						player.setX(player.getX() - 1);
						System.out.println("Gone N.");
						continue;
					} else {
						System.out.println(map.getObject(player.getX() - 1, player.getY()).getName() + " in the way! You cannot pass through!");		
					}
				}		
				continue;
			}	
		
			if (eingabe.equals("walk S")) {	
				if (map.checkCoordinates(player.getX() + 1, player.getY()) == false) {
					System.out.println("The edge of the map is reached! You cannot walk south!");	
					continue;
				}
				if ((map.checkCoordinates(player.getX() + 1, player.getY()) == true) && (map.getObject(player.getX() + 1, player.getY()) == null)) {
					player.setX(player.getX() + 1);
					System.out.println("Gone S.");
					continue;
				} 
				if ((map.checkCoordinates(player.getX() + 1, player.getY()) == true) && (map.getObject(player.getX() + 1, player.getY()) != null)) {
					if (map.getObject(player.getX() + 1, player.getY()).getCollision() == false) {
						player.setX(player.getX() + 1);
						System.out.println("Gone S.");
						continue;
					} else {
						System.out.println(map.getObject(player.getX() + 1, player.getY()).getName() + " in the way! You cannot pass through!");	
					}
				}
				continue;
			}
			
			if (eingabe.equals("walk E")) {	
				if (map.checkCoordinates(player.getX(), player.getY() + 1) == false) {
					System.out.println("The edge of the map is reached! You cannot walk east!");
					continue;
				}					
				if ((map.checkCoordinates(player.getX(), player.getY() + 1) == true) && (map.getObject(player.getX(), player.getY() + 1) == null)) {
					player.setY(player.getY() + 1);
					System.out.println("Gone E.");
					continue;
				}
				if ((map.checkCoordinates(player.getX(), player.getY() + 1) == true) && (map.getObject(player.getX(), player.getY() + 1) != null)) {
					if (map.getObject(player.getX(), player.getY() + 1).getCollision() == false) {
						player.setY(player.getY() + 1);
						System.out.println("Gone E.");
						continue;
					} else {
						System.out.println(map.getObject(player.getX(), player.getY() + 1).getName() + " in the way! You cannot pass through!");
					}
				}
				continue;
			}
			
			if (eingabe.equals("walk W")) {
				if (map.checkCoordinates(player.getX(), player.getY() - 1) == false) {
					System.out.println("The edge of the map is reached! You cannot walk west!");	
					continue;
				}
				if ((map.checkCoordinates(player.getX(), player.getY() - 1) == true) && (map.getObject(player.getX(), player.getY() - 1) == null)) {
					player.setY(player.getY() - 1);
					System.out.println("Gone W.");
					continue;
				}
				if ((map.checkCoordinates(player.getX(), player.getY() - 1) == true) && (map.getObject(player.getX(), player.getY() - 1) != null)) {
					if (map.getObject(player.getX(), player.getY() - 1).getCollision() == false) {
						player.setY(player.getY() - 1);
						System.out.println("Gone W.");
						continue;
					} else {
						System.out.println(map.getObject(player.getX(), player.getY() - 1).getName() + " in the way! You cannot pass through!");
					}
				}
				continue;
			}
			
			if (eingabe.equals("take")) {
				player.takeItem(map);
				for (int k = 0; k < player.getInvSize(); k++) {
					if (player.getInvObj(k) != null) {
						if (player.getInvObj(k).getName().equals("Ring")) {
							System.out.print("You took the ring, your next quest will be to bring it to Mount Doom!");
							foundRing = true;
							break;
						}
					}
				}
				continue;
			}
			
			if (eingabe.equals("map")) {
				map.printMap(player.getX(), player.getY());
				continue;
			}
			
			if (eingabe.equals("inv")) {
				player.printInventory();
				continue;
			}
			try {
				if ((eingabe.substring(0, 4)).equals("drop")) {
					player.putItemDown(map, eingabe.substring(5, len));
					continue;
				}
			} catch (StringIndexOutOfBoundsException e ) {
				System.out.print("");
			}
			System.out.println("False input! Try again.");
		}
	}
	/**
	* Diese Methode platziert zufällig MapObject-Objekte.
	* Es wird genau ein Ring platziert. 
	* @param obj = die Karte
	* @param size = Kartengröße
	* @return die Karte
	*/
	public static Map fillTheMap(Map obj, int size) {
		
		MapObject ring = new Item("Ring");
		MapObject item1 = new Item("Sword", 'I');
		MapObject item2 = new Item("Bow", 'I');
		MapObject item3 = new Item("Arkenstein", 'I');
		MapObject item4 = new Item("Silmaril", 'I');
		MapObject item5 = new Item("Palantir", 'I');
		MapObject item6 = new Item("Helmet", 'I');
		MapObject item7 = new Item("Edelstein", 'I');
		MapObject item8 = new Item("Mithril", 'I');
		MapObject item9 = new Item("Nauglamir", 'I');
		MapObject obs1 = new Obstacle("Swamp", '#');
		MapObject obs2 = new Obstacle("Ruins", '#');
		MapObject obs3 = new Obstacle("Tree", '#');
		MapObject obs4 = new Obstacle("Log", '#');
		MapObject obs5 = new Obstacle("River", '#');
		MapObject obs6 = new Obstacle("Cliff", '#');

		MapObject[] objs = {item1, item2, item3, item4, item5, item6, item7, item8, item9, 
			               obs1, obs2, obs3, obs4, obs5, obs6};
		//Zuerst wird ein Ring platziert
		Random random = new Random();
		int i = 0;
		int j = 0;
		while ((i == 0) && (j == 0)) {
			i = random.nextInt(size);
			j = random.nextInt(size);
		}
		obj.placeMapItem(i, j, ring);
		//Dann werden zufällig andere MapObject-Objekte platziert
		int n = (int) (size * size * 0.3);
		int count = 0;
		int r = 0;
		while (count < n) {
			r = random.nextInt(15);
			i = 0;
			j = 0;
			while ((i == 0) && (j == 0)) {
				i = random.nextInt(size);
				j = random.nextInt(size);
			}
			if (obj.getObject(i, j) == null) {
				obj.placeMapItem(i, j, objs[r]);
				count++;
			}
		}
		return obj;
	}
}
