package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Implementation of the Logics using streams.
 */
public class LogicsImpl implements Logics {

    private final int size;
    private final List<Pair<Integer, Integer>> activeCells = new ArrayList<>();

    /**
     * Constructor.
     * 
     * @param size the grid size
     */
    @SuppressFBWarnings(
        value = "DMI_RANDOM_USED_ONLY_ONCE",
        justification = "False positive, see: https://github.com/spotbugs/spotbugs/issues/3830"
    )
    public LogicsImpl(final int size) {
        this.size = size;
        final Random rand = new Random(0);
        while (activeCells.size() < 3) {
            final int row = rand.nextInt(size);
            final int column = rand.nextInt(size);
            final Pair<Integer, Integer> cell = new Pair<>(row, column);
            if (!activeCells.contains(cell)) {
                activeCells.add(cell);
            }
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isActive(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }

    @Override
    public void nextStep() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextStep'");
    }

    @Override
    public boolean allActive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allActive'");
    }
    
}
