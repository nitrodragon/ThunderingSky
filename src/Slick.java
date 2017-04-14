import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Slick extends StateBasedGame {

    public static final String gamename = "Thundering Sky";
    public static final int play = 0;
    public static final int xSize = 400;
    public static final int ySize = 300;

    public Slick(String gamename){
        super(gamename);
        this.addState(new Play());
    }

    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(play).init(gc, this);
        this.enterState(play);
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer(new Slick(gamename));
//            appgc.setShowFPS(false);
            appgc.setVSync(true);
            appgc.setDisplayMode(xSize, ySize, false);
            appgc.setTargetFrameRate(60);
            appgc.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }
}