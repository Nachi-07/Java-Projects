import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SudokuGame {
    private static final int SIZE = 9;
    private static JTextField[][] cells = new JTextField[SIZE][SIZE];
    private static int[][] solution = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
            	cells[i][j] = new JTextField();

                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                
                // Randomly pre-fill some cells
                if (random.nextInt(100) < 30) { // 30% chance to pre-fill a number
                    cells[i][j].setText(String.valueOf(solution[i][j]));
                    cells[i][j].setEditable(false);
                    cells[i][j].setBackground(Color.LIGHT_GRAY);
                }
                
                panel.add(cells[i][j]);
            }
        }
        
        JButton checkButton = new JButton("Check Solution");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSolution();
            }
        });
        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(checkButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void checkSolution() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    int value = Integer.parseInt(cells[i][j].getText().trim());
                    if (value != solution[i][j]) {
                        JOptionPane.showMessageDialog(null, "Incorrect solution!");
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Congratulations! Correct solution!");
    }
}
