package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Implementation of the Logics Interface.
 */
public class LogicsImpl implements Logics {

    private final List<List<Boolean>> grid = new ArrayList<>();

    /**
     * Constructor that builds the grid.
     * 
     * @param n the number of slots
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

    /**
     * Returns the value at the position (row, col).
     */
    @Override
    public String valueAt(final int row, final int col) {
        return grid.get(row).get(col) ? "*" : "";
    }

    /**
     * Change the value of the cell at the position (row, col).
     */
    @Override
    public void hit(final int row, final int col) {
        grid.get(row).set(col, !grid.get(row).get(col));
    }

    /**
     * Checks if the row or column are full.
     */
    @Override
    public boolean toQuit() {

        final boolean rowFull = grid.stream()
            .anyMatch(r -> r.stream().allMatch(b -> b));

        final boolean columnFull = IntStream.range(0, grid.size())
            .anyMatch(c ->
                grid.stream().allMatch(r -> r.get(c))
            );

        return rowFull || columnFull;
    }
}
