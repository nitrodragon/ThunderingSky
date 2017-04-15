import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

    Rectangle rect = new Rectangle(50, 50, 100,100);

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.draw(rect);
    }

    public void update(GameContainer gc, StateBasedGame sbg,int DELTA) throws SlickException {

    }

    @Override
    public int getID() {
        return 2;
    }
}
