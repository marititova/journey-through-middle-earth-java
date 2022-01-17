/**
 * Represents an object that can be put down on a map.
 */
public interface MapObject {
    /**
     * Returns the full name of the object.
     *
     * @return Full name of the object.
     */
    String getName();

    /**
     * Returns the symbol which represents the object
     * on the map.
     *
     * @return Single character symbol to show for this object.
     */
    char getSymbol();

    /**
     * Describes if this object can be picked up by the player.
     *
     * @return True if the player can pick the object up, false otherwise.
     */
    boolean isLootable();

    /**
     * Determines if the object can be passed through by a player.
     *
     * @return True if the player collides with the object, false
     *         if the player can walk through.
     */
    boolean getCollision();
}
