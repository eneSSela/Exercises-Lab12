package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

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

    /**
     * Returns the size of the grid.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Checks if the cell is active.
     */
    @Override
    public boolean isActive(final int row, final int col) {
        return activeCells.contains(new Pair<>(row, col));
    }

    /**
     * Calculate the next operation on the grid.
     */
    @Override
    public void nextStep() {
        final List<Pair<Integer, Integer>> newCells = 
            IntStream.range(0, this.size)
                .boxed()
                .flatMap(x -> IntStream.range(0, this.size)
                        .mapToObj(y -> new Pair<>(x, y)))
                .filter(p -> !activeCells.contains(p))
                .filter(p -> activeCells.stream().anyMatch(a ->
                        Math.abs(p.x() - a.x()) <= 1
                        && Math.abs(p.y() - a.y()) <= 1
                        && !p.equals(a)))
                .toList();
        activeCells.addAll(newCells);
    }

    /**
     * Returns if the grid have to close.
     */
    @Override
    public boolean allActive() {
        return activeCells.size() == this.size * this.size;
    }

}
