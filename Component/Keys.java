package Component;
import LeaderBoard.*;
import GUI.*;
import java.awt.event.KeyEvent;

public class Keys {

    public static boolean[] pressed = new boolean[256];
    public static boolean[] prev = new boolean[256];
    public static void update(){
        for(int i = 0; i < 4; i++){
            if(i == 0) {
                prev[KeyEvent.VK_LEFT] = pressed[KeyEvent.VK_LEFT];
                prev[KeyEvent.VK_A] = pressed[KeyEvent.VK_A];
            }
            if(i == 1) {
                prev[KeyEvent.VK_RIGHT] = pressed[KeyEvent.VK_RIGHT];
                prev[KeyEvent.VK_D] = pressed[KeyEvent.VK_D];
            }
            if(i == 2){
                prev[KeyEvent.VK_W] = pressed[KeyEvent.VK_W];
                prev[KeyEvent.VK_UP] = pressed[KeyEvent.VK_UP];
            }
            if(i == 3){
                prev[KeyEvent.VK_DOWN] = pressed[KeyEvent.VK_DOWN];
                prev[KeyEvent.VK_S] = pressed[KeyEvent.VK_S];
            }
        }
    }
    public static void keyPressed(KeyEvent e){
        pressed[e.getKeyCode()] = true;
    }
    public static void keyReleased(KeyEvent e){
        pressed[e.getKeyCode()] = false;
    }
}
