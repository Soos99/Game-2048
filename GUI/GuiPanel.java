package GUI;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GuiPanel {

    private ArrayList<GuiButton> buttons;

    public GuiPanel(){
        buttons = new ArrayList<GuiButton>();
    }

    public void update(){
		int size = buttons.size();
        for (int i = 0; i < size; i++){
			if (i < buttons.size())
			buttons.get(i).update();
			size = buttons.size();
		}
    }

    public void render(Graphics2D g){
		int size = buttons.size();
        for (int i = 0; i < size; i++){
			if (i < buttons.size())
			buttons.get(i).render(g);
			size = buttons.size();
		}
    }

    public void add(GuiButton button){
        buttons.add(button);
    }

    public void remove(GuiButton button){
        buttons.remove(button);
    }

    public void mousePressed(MouseEvent e){
		int index = 0;
        while (index < buttons.size()){
			buttons.get(index).mouseReleased(e);
			index++;
		}
    }

    public void mouseReleased(MouseEvent e){
		int size = buttons.size();
		for (int i = 0; i < size; i++){
			if (i < buttons.size())
			buttons.get(i).mouseReleased(e);
			size = buttons.size();
		}
    }

    public void mouseDragged(MouseEvent e){
		int size = buttons.size();
        for (int i = 0; i < size; i++){
			if (i < buttons.size())
			buttons.get(i).mouseDragged(e);
			size = buttons.size();
		}
    }

    public void mouseMoved(MouseEvent e){
		int size = buttons.size();
        for (int i = 0; i < size; i++){
			if (i < buttons.size())
			buttons.get(i).mouseMoved(e);
			size = buttons.size();
		}
    }
}
