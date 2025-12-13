package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        final Logics logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        final JButton nextButton = new JButton(">");
        this.getContentPane().add(nextButton, BorderLayout.SOUTH);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final JButton button = new JButton(" ");
                this.cells.add(button);
                panel.add(button);
            }
        }

        updateButtons(logics);

        nextButton.addActionListener(e -> {
            logics.nextStep();
            updateButtons(logics);
            if (logics.allActive()) {
                dispose();
            }
        });
        pack();
        this.setVisible(true);
    }

    private void updateButtons(final Logics logics) {
        final int width = (int) Math.sqrt(cells.size());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final int index = i * width + j;
                final JButton button = cells.get(index);
                button.setText(logics.isActive(i, j) ? "*" : " ");
            }
        }
    }
}
