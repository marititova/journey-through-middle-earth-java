/**
 * Stellt ein Objekt Wizard dar.
 */
public class Wizard implements Player {
	
	private int x = 0;
	private int y = 0;
	private int n = 6;
	private MapObject[] inventory = new MapObject[n];
	
	/**
	* Sucht nach leerem Platz im Inventar, 
	* wenn gefunden, speichert übergebenes Item.
	* @param map = Karte
	*/
    public void takeItem(Map map) {
		int a = getX();
		int b = getY();
		int count = 0;
		if (map.getObject(a, b) == null) {
			System.out.println("There is nothing on the ground!");
		}
		if ((map.getObject(a, b) != null) && (map.getObject(a, b).isLootable() == false)) {
			System.out.println(map.getObject(a, b).getName() + " cannot be taken!");
		}
		if ((map.getObject(a, b) != null) && (map.getObject(a, b).isLootable() == true)) {
			for (int i = 0; i < getInvSize(); i++) {
				if (getInvObj(i) == null) {
					setInvObj(i, map.getObject(a, b));
					System.out.println(map.getObject(a, b).getName() + " is placed in inventory.");
					map.retrieveItem(a, b);
					break;
				} else {
					count++;
				}
				if (count >= getInvSize()) {
					System.out.println("Inventory is full!");
				}
			}
		}
	}
    /**
	* Sucht nach übergebenem Namen im Inventar, wenn gefunden,
	* legt Item auf den Boden.
	* Überprüft, ob das Objekt aufnehmbar und Platz im Inventar des Spielers ist.
	* @param map = Karte
	* @param name = Name
	*/
    public void putItemDown(Map map, String name) {
		int a = getX();
		int b = getY();
		int count = 0;
		if (map.getObject(a, b) == null) {
			loop:
			for (int z = 0; z < getInvSize(); z++) {
				if (getInvObj(z) != null) {
					if ((getInvObj(z).getName()).equals(name)) {
						map.placeMapItem(a, b, getInvObj(z));
						System.out.println(getInvObj(z).getName() + " is dropped on the ground.");
						setInvObj(z, null);
						break loop;
					} else {
						count++;
					}
				}
				if (getInvObj(z) == null) {
					count++;
				}
				if (count >= getInvSize()) {
					System.out.println(name + " is not in inventory!");
				}
			}
		} else {
			System.out.println("You cannot drop a object here!");
			System.out.println("There is something already lying on the ground!");
		}
	}
    /**
	* Gibt das Inventar auf der Konsole aus.
	*/
    public void printInventory() {
		System.out.println("Inventory:");
		for (int i = 0; i < getInvSize(); i++) {
			if (getInvObj(i) == null) {
				System.out.print("| empty |");
				System.out.print(" ");
			} else {
				System.out.print("|" + getInvObj(i).getName() + "|");
				System.out.print(" ");
			}
		}
		System.out.println("");
	}
    /**
	* Setzt X-Koordinate des Spielers.
	* @param x = X-Koordinate
	*/
	public void setX(int x) {
		this.x = x;
	}
	/**
	* Setzt Y-Koordinate des Spielers.
	* @param y = Y-Koordinate
	*/
	public void setY(int y) {
		this.y = y;
	}
	/**
	* Gibt X-Koordinate des Spielers zurück.
	* @return x
	*/
    public int getX() {
		return this.x;
	}
	/**
	* Gibt Y-Koordinate des Spielers zurück.
	* @return y
	*/
	public int getY() {
		return this.y;
	}
	/**
	* Platziert übergebenes Objekt in den Slot von Inventar.
	* @param a = Index
	* @param obj = Item
	*/
	public void setInvObj(int a, MapObject obj) {
		this.inventory[a] = obj;
	}
	/**
	* Gibt das Objekt von Inventar zurück.
	* @param a = Index
	* @return Objekt von Inventar mit Index a
	*/
	public MapObject getInvObj(int a) {
		return inventory[a];
	}
	/**
	* Gibt die Größe von Inventar zurück.
	* @return n
	*/
	public int getInvSize() {
		return this.n;
	}
}
