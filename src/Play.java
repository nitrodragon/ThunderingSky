import org.newdawn.slick.*;
import org.newdawn.slick.command.*;
import org.newdawn.slick.state.*;
import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;

public class Play extends BasicGameState implements InputProviderListener {

    private float frame = 0;
    private TrueTypeFont ttf;
    private InputProvider provider;
    private BasicCommand up = new BasicCommand("up");
    private BasicCommand down = new BasicCommand("down");
    int msg = 0;

    Play() {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        provider = new InputProvider(gc.getInput());
        provider.addListener(this);
        Font font = new Font("Helvetica", Font.BOLD, 24);
        ttf = new TrueTypeFont(font, true);
        provider.bindCommand(new KeyControl(Input.KEY_UP), up);
        provider.bindCommand(new KeyControl(Input.KEY_DOWN), down);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        frame += 0.1;
        ttf.drawString( 20, (float)Math.sin(frame) * 10 + 150, "Defence: " + Integer.toString(msg));
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
    }

    @Override
    public void controlPressed(Command command) {
        if (command.toString().equals("[Command=up]")) {
            msg++;
        } else {
            msg--;
        }
        if (msg < 0) {
            msg = 0;
        } else if (msg > 3) {
            msg = 3;
        }
    }

    @Override
    public void controlReleased(Command command) {

    }

    public int getID() {
        return 0;
    }
}