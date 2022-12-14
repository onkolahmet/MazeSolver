import java.util.List;

public class Tile {

    private final int x;
    private final int y;
    private int manhattanDistanceToNearestGoal; // heuristic
    private final TileType type;

    private Tile east;
    private Tile south;
    private Tile west;
    private Tile north;

    public Tile(int x, int y, TileType type) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, TileType type, Tile east, Tile south, Tile west, Tile north) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileType getType() {
        return type;
    }

    public Tile getEast() {
        return east;
    }

    public Tile getSouth() {
        return south;
    }

    public Tile getWest() {
        return west;
    }

    public Tile getNorth() {
        return north;
    }

    public int getManhattanDistanceToNearestGoal() {
        return manhattanDistanceToNearestGoal;
    }

    public void setEast(Tile east) {
        this.east = east;
    }

    public void setSouth(Tile south) {
        this.south = south;
    }

    public void setWest(Tile west) {
        this.west = west;
    }

    public void setNorth(Tile north) {
        this.north = north;
    }

    public void setManhattanDistanceToNearestGoal(List<Tile> goalTiles) {
        int manhattanDistanceToNearestGoal = Integer.MAX_VALUE;

        for (Tile goalTile : goalTiles) {
            int currentDistance = Math.abs(goalTile.getX() - this.x) + Math.abs(goalTile.getY() - this.y);

            if (currentDistance < manhattanDistanceToNearestGoal)
                manhattanDistanceToNearestGoal = currentDistance;
        }

        this.manhattanDistanceToNearestGoal = manhattanDistanceToNearestGoal;
    }

}
