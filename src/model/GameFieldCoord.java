package model;

public class GameFieldCoord {
    private int x, y;

    public GameFieldCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            GameFieldCoord a = (GameFieldCoord) obj;
            return obj != null && (obj == this || this.x == a.x && this.y == a.y);
        }
        catch (Exception e) {
            return false;
        }
    }
}