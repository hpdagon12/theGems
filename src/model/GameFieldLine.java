package model;

/**
 * Created by sasus on 15.06.14.
 */
import java.util.Iterator;

public class GameFieldLine implements Iterable<GameFieldCoord> {
    private GameFieldCoord startLine;
    private GameFieldCoord endLine;

    public GameFieldLine(GameFieldCoord startLine, GameFieldCoord endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public GameFieldCoord getStartLine() {
        return startLine;
    }

    public GameFieldCoord getEndLine() {
        return endLine;
    }

    public int length() {
        if (startLine.getX() == endLine.getX()) {
            return Math.abs(startLine.getY() - endLine.getY());
        } else {
            return Math.abs(startLine.getX() - endLine.getX());
        }
    }

    @Override
    public Iterator<GameFieldCoord> iterator() {
        return new LineIterator();
    }

    enum Direction {VerticalInc, HorizontalInc, VerticalDec, HorizontalDec}

    public Direction getDirection() {
        if (startLine.getX() == endLine.getX()) {
            if (startLine.getY() > endLine.getY()) {
                return Direction.VerticalInc;
            } else {
                return Direction.VerticalDec;
            }
        } else {
            if (startLine.getX() > endLine.getX()) {
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
            return !currentPoint.equals(endLine);
        }

        @Override
        public GameFieldCoord next() {
            if (direction != null) {
                switch (direction) {
                    case VerticalInc:
                        return currentPoint = new GameFieldCoord(currentPoint.getX(), currentPoint.getY() + 1);
                    case HorizontalInc:
                        return currentPoint = new GameFieldCoord(currentPoint.getX() + 1, currentPoint.getY());
                    case VerticalDec:
                        return currentPoint = new GameFieldCoord(currentPoint.getX(), currentPoint.getY() - 1);
                    case HorizontalDec:
                        return currentPoint = new GameFieldCoord(currentPoint.getX() - 1, currentPoint.getY());
                }
            } else {
                direction = getDirection();
                return currentPoint = startLine;
            }
            return currentPoint;
        }

        @Override
        public void remove() {
        }
    }
}