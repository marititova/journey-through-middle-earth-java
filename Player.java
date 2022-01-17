/**
 * Stellt ein Objekt Spieler dar.
 */
public interface Player {

    /**
	* Sucht nach leerem Platz im Inventar, 
	* wenn gefunden, speichert übergebenes Item.
	* @param map = Karte
	*/
    void takeItem(Map map);
    /**
	* Sucht nach übergebenem Namen im Inventar, wenn gefunden,
	* legt Item auf den Boden.
	* Überprüft, ob das Objekt aufnehmbar und Platz im Inventar des Spielers ist.
	* @param map = Karte
	* @param name = Name
	*/
    void putItemDown(Map map, String name);
    /**
	* Gibt das Inventar auf der Konsole aus.
	*/
    void printInventory();
	/**
	* Setzt X-Koordinate des Spielers.
	* @param x = X-Koordinate
	*/
	void setX(int x);
	/**
	* Setzt Y-Koordinate des Spielers.
	* @param y = Y-Koordinate
	*/
	void setY(int y);
	/**
	* Gibt X-Koordinate des Spielers zurück.
	* @return x
	*/
    int getX();
	/**
	* Gibt Y-Koordinate des Spielers zurück.
	* @return y
	*/
	int getY();
	/**
	* Platziert übergebenes Objekt in den Slot von Inventar.
	* @param a = Index
	* @param obj = Item
	*/
	void setInvObj(int a, MapObject obj);
	/**
	* Gibt das Objekt von Inventar zurück.
	* @param a = Index
	* @return Objekt von Inventar mit Index a
	*/
	MapObject getInvObj(int a);
	/**
	* Gibt die Größe von Inventar zurück.
	* @return n
	*/
	int getInvSize();
}
