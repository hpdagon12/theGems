package model;

/**
 * Created by sasus on 15.06.14.
 */
import java.util.Iterator;

public class GameFieldLine implements Iterable<GameFieldCoord> {
    private GameFieldCoord starOftLine;
    private GameFieldCoord endOfLine;

    public GameFieldLine(GameFieldCoord startLine, GameFieldCoord endLine) {
        this.starOftLine = startLine;
        this.endOfLine = endLine;
    }

    public GameFieldCoord getStarOftLine() {
        return starOftLine;
    }

    public GameFieldCoord getEndOfLine() {
        return endOfLine;
    }

    public int length() {
        if (starOftLine.getX() == endOfLine.getX()) {
            return Math.abs(starOftLine.getY() - endOfLine.getY());
        } else {
            return Math.abs(starOftLine.getX() - endOfLine.getX());
        }
    }

    @Override
    public Iterator<GameFieldCoord> iterator() {
        return new LineIterator();
    }

    enum Direction {VerticalInc, HorizontalInc, VerticalDec, HorizontalDec}

    public Direction getDirection() {
        if (starOftLine.getX() == endOfLine.getX()) {
            if (starOftLine.getY() > endOfLine.getY()) {
                return Direction.VerticalInc;
            } else {
                return Direction.VerticalDec;
            }
        } else {
            if (starOftLine.getX() > endOfLine.getX()) {
                return Direction.HorizontalInc;
            } else {
                return Direction.HorizontalDec;
            }
        }
    }

    public class LineIterator implements Iterator<GameFieldCoord> {
        Direction direction;
        GameFieldCoord currentPoint;

        @Override
        public boolean hasNext() {
            return !currentPoint.equals(endOfLine);
        }

        @Override
        public GameFieldCoord next() {

                switch (direction) {
                    case VerticalInc:
                        return currentPoint = new GameFieldCoord(currentPoint.getX(), currentPoint.getY() + 1);
                    case HorizontalInc:
                        return currentPoint = new GameFieldCoord(currentPoint.getX() + 1, currentPoint.getY());
                    case VerticalDec:
                        return currentPoint = new GameFieldCoord(currentPoint.getX(), currentPoint.getY() - 1);
                    case HorizontalDec:
                        return currentPoint = new GameFieldCoord(currentPoint.getX() - 1, currentPoint.getY());
                    default: currentPoint = starOftLine;
                        return currentPoint;
                }

        }

        @Override
        public void remove() {

        }
        private boolean check(){

            return  true;
        }
    }

}