import Component.*;
import GUI.*;
import LeaderBoard.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
            Game game = new Game();

            JFrame window = new JFrame("2048");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.add(game);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            game.start();
        }
}
