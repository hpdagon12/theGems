package model;

/**
 * Created by sasus on 15.06.14.
 */
import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final int MINIMAL_SEQ_LENGTH = 3;

    private Gem[][] gems;

    public GameService(int rows, int colls) {
        gems = new Gem[rows][colls];

        for (int y = 0; y < gems.length; y++) {
            for (int x = 0; x < gems[y].length; x++) {
                gems[y][x] = new Gem();
            }
        }
    }

    private void process() {
        for(GameFieldLine line : findSequences()) {
            remove(line);
        }

        for (int y = 0; y < gems.length; y++) {
            for (int x = 1; x < gems[y].length; x++) {
                if (gems[y][x] == null)
                    fill(new GameFieldCoord(x, y));
            }

        }
    }

    private void fill(GameFieldCoord c) {
        gems[c.getY()][c.getX()] = new Gem();
    }

    private List<GameFieldLine> findSequences() {
        List<GameFieldLine> result = new ArrayList<GameFieldLine>();
        int currentSeqLength = 1;
        GameFieldCoord startCoord = new GameFieldCoord(0, 0);
        GameFieldCoord endCoord = startCoord;

        for (int y = 0; y < gems.length; y++) {
            for (int x = 1; x < gems[y].length; x++) {
                if (gems[y][x - 1].getColor().equals(gems[y][x].getColor())) {
                    currentSeqLength++;
                    endCoord = new GameFieldCoord(x, y);
                } else {
                    if (currentSeqLength >= MINIMAL_SEQ_LENGTH) {
                        result.add(new GameFieldLine(startCoord, endCoord));
                    }

                    startCoord = new GameFieldCoord(x, y);
                    endCoord = startCoord;

                    currentSeqLength = 1;
                }
            }

            if (currentSeqLength >= MINIMAL_SEQ_LENGTH) {
                result.add(new GameFieldLine(startCoord, endCoord));
            }
        }

        currentSeqLength = 1;
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 1; y < gems.length; x++)
                if (gems[y - 1][x].getColor().equals(gems[y][x].getColor())) {
                    currentSeqLength++;
                    endCoord = new GameFieldCoord(x, y);
                } else {
                    if (currentSeqLength >= MINIMAL_SEQ_LENGTH) {
                        result.add(new GameFieldLine(startCoord, endCoord));
                    }

                    startCoord = new GameFieldCoord(x, y);
                    endCoord = startCoord;

                    currentSeqLength = 1;
                }

            if (currentSeqLength >= MINIMAL_SEQ_LENGTH) {
                result.add(new GameFieldLine(startCoord, endCoord));
            }
        }

        return result;
    }

    private void swapGems(int aRow, int aColl, int bRow, int bColl) {
        Gem tmp = gems[aRow][aColl];
        gems[aRow][aColl] = gems[bRow][bColl];
        gems[bRow][bColl] = tmp;
    }

    private void remove(int x, int y){
        gems[y][x] = null;
        for (int i = y; i > 0; i--) {
            swapGems(x, y, x, i-1);
        }
    }

    private void remove(GameFieldLine line) {
        for(GameFieldCoord c: line) {
            remove(c.getX(), c.getY());
        }
    }

    public boolean swap(int aRow, int aColl, int bRow, int bColl) {
        swapGems(aRow, aColl, bRow, bColl);

        if (findSequences().size() == 0) {
            swapGems(aRow, aColl, bRow, bColl);
            return false;
        }

        process();
        return true;
    }
    public Gem get(int x, int y){
        return gems[y][x];
    }
    public int getRowsCount(){
        return gems.length;
    }
    public int getCollsCount(){
        return gems[0].length;
    }

}