package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final int size;
    private final List<Integer> values = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            values.add(0);
        }
    }

    /**
     * Return the total number of buttons.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns a copy of the list of the current values of the buttons.
     */
    @Override
    public List<Integer> values() {
        return new ArrayList<>(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }
}
