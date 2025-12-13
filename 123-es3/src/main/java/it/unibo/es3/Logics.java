package it.unibo.es3;

/**
 * Interface of the Logics.
 */
public interface Logics {

    /**
     * Returns the size of the grid.
     * 
     * @return the grid size
     */
    int size();

    /**
     * Checks if the cell at (row, col) is active.
     * 
     * @param row the row index
     * @param col the column index
     * @return true if active, false otherwise
     */
    boolean isActive(int row, int col);

    /**
     * Advance the grid to the next step.
     */
    void nextStep();

    /**
     * Check if all cells are active.
     * 
     * @return true if all active, false otherwise
     */
    boolean allActive();
}
