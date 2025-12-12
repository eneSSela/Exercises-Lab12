package it.unibo.es2;

/**
 * Interface of the Logics.
 */
public interface Logics {
 
    /**
     * Returns the value at the position (row, col).
     * 
     * @param row the specified row
     * @param col the specified column
     * @return the value at the specific position
     */
    String valueAt(int row, int col);

    /**
     * Change the state of the cell at the position (row, col).
     * 
     * @param row the specified row
     * @param col the specified column
     */
    void hit(int row, int col);

    /**
     * True if it is time to quit false otherwise.
     * 
     * @return wheter it is time to quit.
     */
    boolean toQuit();
}
