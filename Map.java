/**
* Stellt ein Objekt Map dar.
*/
public class Map {
	
	private int n;
	private MapObject[][] map0;
	
	/**
	* Konstruktor Map
	* nimmt die Größe der Karte an.
	* @param n = Größe der Karte
	*/
	public Map(int n) {
		this.n = n;
		this.map0 = new MapObject[n][n];
	}
	/**
	* Platziert MapObject auf die Karte.
	* @param x = Zeilen-Index
	* @param y = Spalten-Index
	* @param obj = MapObject-Objekt
	*/
	public void placeMapItem(int x, int y, MapObject obj) {
		this.map0[x][y] = obj;
	}
	/**
	* Nimmt MapObject-Objekt von der Karte.
	* @param x = Zeilen-Index
	* @param y = Spalten-Index
	*/
	public void retrieveItem(int x, int y) {
		this.map0[x][y] = null;
	}
	/**
	* Überprüft, ob die Koordinaten des Spielers
	* bei einer Bewegung innerhalb der Map sind.
	* @param a = X-Koordinate des Spielers
	* @param b = Y-Koordinate des Spielers
	* @return true, falls sich Spieler innerhalb der Map bewegt,
	* false, fall nicht.
	*/
	public boolean checkCoordinates(int a, int b) {
		if ((a < n) && (a >= 0) && (b >= 0) && (b < n)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* Gibt das Objekt der Map zurück.
	* @param x = Zeilen-Index
	* @param y = Spalten-Index
	* @return MapObject
	*/
	public MapObject getObject(int x, int y) {
		return this.map0[x][y];
	}
	/**
	* Gibt das Inventar mit den vollen Namen der Objekte auf der Konsole.
	* @param x = X-Koordinate des Spielers
	* @param y = Y-Koordinate des Spielers
	*/
	public void printMap(int x, int y) {
		int line = 0;
		System.out.println("Map:");
		while (line < n - 1) {
			System.out.print(" - ~");
			line++;
		}
		System.out.print(" -");
		System.out.println("");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((j == 0) && (this.getObject(i, j) == null) && ((i == x) && (j == y))) {
					System.out.print("|P  ");
				}
				if ((j == n - 1) && (this.getObject(i, j) == null) && ((i == x) && (j == y))) {
					System.out.print(" P|");
				}
				if ((j == 0) && (this.getObject(i, j) == null) && ((i != x) || (j != y))) {
					System.out.print("|   ");
				}
				if ((j == n - 1) && (this.getObject(i, j) == null) && ((i != x) || (j != y))) {
					System.out.print("  |");
				}
				if (((j != 0) && (j != n - 1)) && (this.getObject(i, j) == null) && ((i == x) && (j == y))) {
					System.out.print(" P  ");
				}
				if (((j != 0) && (j != n - 1)) && (this.getObject(i, j) == null) && ((i != x) || (j != y))) {
					System.out.print("    ");
				}
				if ((j == 0) && (this.getObject(i, j) != null) && ((i == x) && (j == y))) {
					System.out.print("|P  ");
				}
				if ((j == n - 1) && (this.getObject(i, j) != null) && ((i == x) && (j == y))) {
					System.out.print(" P|");
				}
				if (((j != 0) && (j != n - 1)) && (this.getObject(i, j) != null) && ((i == x) && (j == y))) {
					System.out.print(" P  ");
				}
				if ((j == 0) && (this.getObject(i, j) != null) && ((i != x) || (j != y))) {
					System.out.print("|" + this.getObject(i, j).getSymbol() + "  ");
				}
				if ((j == n - 1) && (this.getObject(i, j) != null) && ((i != x) || (j != y))) {
					System.out.print(" " + this.getObject(i, j).getSymbol() + "|");
				}
				if (((j != 0) && (j != n - 1)) && (this.getObject(i, j) != null) && ((i != x) || (j != y))) {
					System.out.print(" " + this.getObject(i, j).getSymbol() + "  ");
				}
			}
			if (i < n - 1) {
				System.out.println("\n");
			}
		}
		line = 0;
		System.out.println("");
		while (line < n - 1) {
			System.out.print(" - ~");
			line++;
		}
		System.out.print(" -");
		System.out.println("");
	}	
}
