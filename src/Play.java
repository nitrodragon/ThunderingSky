import org.newdawn.slick.*;
import org.newdawn.slick.command.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;

public class Play extends BasicGameState implements InputProviderListener {

    private float frame = 0;
    private TrueTypeFont active;
    private TrueTypeFont inactive;
    private String[] statNames = {"Attack: ", "Defence: ", "Magic: ", "Speed: "};
    private int[] statValues = {0, 0, 0, 0};
    private BasicCommand up = new BasicCommand("up");
    private BasicCommand down = new BasicCommand("down");
    private BasicCommand left = new BasicCommand("left");
    private BasicCommand right = new BasicCommand("right");
    private BasicCommand enter = new BasicCommand("enter");
    private int pointer = 0;
    private Rectangle[] rect = new Rectangle[4];
    StateBasedGame sb;

    Play() {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        sb = sbg;
        InputProvider provider = new InputProvider(gc.getInput());
        provider.addListener(this);
        Font finactive = new Font("Helvetica", Font.PLAIN, 20);
        Font factive = new Font("Helvetica", Font.BOLD, 24);
        active = new TrueTypeFont(factive, true);
        inactive = new TrueTypeFont(finactive, true);
        provider.bindCommand(new KeyControl(Input.KEY_UP), up);
        provider.bindCommand(new KeyControl(Input.KEY_DOWN), down);
        provider.bindCommand(new KeyControl(Input.KEY_LEFT), left);
        provider.bindCommand(new KeyControl(Input.KEY_RIGHT), right);
        provider.bindCommand(new KeyControl(Input.KEY_ENTER), enter);

        for (int i = 0; i < rect.length; i++) {
            rect[i] = new Rectangle(100, 20 + (70 * i), statValues[i] * 40, 20);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        for (int i = 0; i < statNames.length; i++) {
            if (pointer == i) {
                // + (float)Math.sin(frame * 25)
                active.drawString(20, 20 + (70 * i), statNames[i] + statValues[i]);
            } else {
                inactive.drawString(20, 20 + (70 * i), statNames[i]);
            }
//            g.setColor(Color.white);
//            g.fill(rect[i]);
            if (statValues[i] > 0) g.draw(rect[i]);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        frame += 0.01;
    }

    @Override
    public void controlPressed(Command command) {
        if (command.toString().equals("[Command=down]")) {
            if (pointer < 3) pointer++;
        } else if (command.toString().equals("[Command=up]")){
            if (pointer > 0) pointer--;
        } else if (command.toString().equals("[Command=right]")) {
            if (statValues[pointer] < 3) {
                statValues[pointer]++;
                rect[pointer].setWidth(statValues[pointer] * 40);
            }
        } else if (command.toString().equals("[Command=left]")) {
            if (statValues[pointer] > 0) {
                statValues[pointer]--;
                rect[pointer].setWidth(statValues[pointer] * 40);
            }
        } else {
            Player player = new Player(statValues[0],statValues[1],statValues[2],statValues[3]);
            sb.enterState(2);
        }
    }

    @Override
    public void controlReleased(Command command) {

    }

    public int getID() {
        return 0;
    }
}