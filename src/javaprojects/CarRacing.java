package javaprojects;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class CarRacing extends JPanel implements ActionListener, KeyListener {
	    private int carX = 200; // Car's initial X position
	    private int carY = 500; // Car's fixed Y position
	    private int obstacleX = 200; // Obstacle's initial X position
	    private int obstacleY = 0; // Obstacle's initial Y position
	    private int score = 0;
	    private boolean gameOver = false;
	    
	    public CarRacing() {
	        Timer timer = new Timer(50, this);
	        timer.start();
	        addKeyListener(this);
	        setFocusable(true);
	        setFocusTraversalKeysEnabled(false);
	    }
	    
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        setBackground(Color.BLACK);
	        
	        // Draw player's car
	        g.setColor(Color.BLUE);
	        g.fillRect(carX, carY, 50, 100);
	        
	        // Draw obstacle car
	        g.setColor(Color.RED);
	        g.fillRect(obstacleX, obstacleY, 50, 100);
	        
	        // Draw score
	        g.setColor(Color.WHITE);
	        g.setFont(new Font("Arial", Font.BOLD, 20));
	        g.drawString("Score: " + score, 10, 30);
	        
	        if (gameOver) {
	            g.setFont(new Font("Arial", Font.BOLD, 40));
	            g.setColor(Color.YELLOW);
	            g.drawString("GAME OVER!", 100, 300);
	        }
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (!gameOver) {
	            obstacleY += 10; // Move obstacle down
	            
	            // Reset obstacle when it goes off-screen
	            if (obstacleY > 600) {
	                obstacleY = 0;
	                obstacleX = (int) (Math.random() * 350); // Randomize obstacle position
	                score++;
	            }
	            
	            // Check for collision
	            if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(obstacleX, obstacleY, 50, 100))) {
	                gameOver = true;
	            }
	            
	            repaint();
	        }
	    }
	    
	    @Override
	    public void keyPressed(KeyEvent e) {
	        if (!gameOver) {
	            if (e.getKeyCode() == KeyEvent.VK_LEFT && carX > 0) {
	                carX -= 20;
	            }
	            if (e.getKeyCode() == KeyEvent.VK_RIGHT && carX < 350) {
	                carX += 20;
	            }
	            repaint();
	        }
	    }
	    
	    @Override
	    public void keyReleased(KeyEvent e) {}
	    @Override
	    public void keyTyped(KeyEvent e) {}
	    
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Car Racing Game 🚗💨");
	        CarRacing game = new CarRacing();
	        
	        frame.add(game);
	        frame.setSize(400, 600);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	}


