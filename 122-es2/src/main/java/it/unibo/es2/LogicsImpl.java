package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics Interface.
 */
public class LogicsImpl implements Logics {

    private final List<List<Boolean>> grid = new ArrayList<>();

    /**
     * Constructor that builds the grid.
     */
    public LogicsImpl(final int n) {
        for (int i = 0; i < n; i++) {
            final List<Boolean> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(false);
            }
            grid.add(row);
        }
    }

    @Override
    public String valueAt(int row, int col) {
        return grid.get(row).get(col) ? "*" : "";
    }

    @Override
    public void hit(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hit'");
    }

    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }
    
}
