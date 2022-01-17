/**
 * Stellt ein Objekt von Typ Obstacle dar, das auf einer Karte abgelegt werden kann.
 */
public class Obstacle implements MapObject {
	
	private String name;
	private char symbol;
	
	/**
	* Konstruktor Obstacle
	* nimmt einen Namen an und setzt das Symbol auf den ersten Buchstaben des Namens.
	* @param name = Name des Objekts
	*/
	public Obstacle(String name) {
		this.name = name;
		this.symbol = name.charAt(0);
	}
	/**
	* Konstruktor Obstacle
	* nimmt einen Namen und ein Symbol an.
	* @param name = Name des Objekts
	* @param symbol = Symbol des Objekts
	*/
	public Obstacle(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}
    /**
     * Gibt den Namen des Objekts zurück.
     *
     * @return Name des Objekts.
     */
    public String getName() {
		return this.name;
	}
    /**
     * Gibt das Symbol zurück, das das Objekt auf der Karte darstellt.
     * @return Symbol, das für dieses Objekt angezeigt werden soll.
     */
    public char getSymbol() {
		return this.symbol;
	}
    /**
     * Prüft, ob dieses Objekt vom Spieler aufgenommen werden kann.
     *
     * @return true wenn der Spieler das Objekt aufnehmen kann, andernfalls false.
     */
    public boolean isLootable() {
		if (this instanceof Obstacle) {
			return false;
		} else {
			return true;
		}
	}
    /**
     * Prüft, ob der Spieler durch das Objekt gehen kann.
     *
     * @return true wenn der Spieler mit dem Objekt kollidiert, 
	 * false wenn der Spieler durchgehen kann.
     */
    public boolean getCollision() {
		if (this instanceof Obstacle) {
			return true;
		}
		return false;
	}
}
