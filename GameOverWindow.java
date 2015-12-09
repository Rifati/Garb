import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class GameOverWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWindow extends Score {
    
    private long startTime;
    private GreenfootImage image = new GreenfootImage(1, 1);
    boolean victory = false;
    boolean stopped = false;
    
    public GameOverWindow() {
        startTime = System.currentTimeMillis();
        setImage(image);
    }

    /**
     * Act - do whatever the GameOverWindow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (stopped == false && isGameOver() == true) {
            stopped = true;
            drawGameOverWindow();
            Greenfoot.stop();
        }
    }
    
    public boolean isGameOver() {
        if (getWorld().getObjects(Garp.class).get(0).isDead() == true
        || getWorld().getObjects(GemScore.class).get(0).returnScore() == 10) {
            return true;
        }
        else {return false;}
    }
    
    public String elapsedTime() {
        long duration = (System.currentTimeMillis()-startTime)/1000;
        int hh = (int)(duration/3600);
        int mm = (int)(duration%3600/60);
        int ss = (int)(duration%60);
        String elapsedTime = String.format("Elapsed time: %02d:%02d:%02d", hh, mm, ss);
        return elapsedTime;
    }
    
    public void drawGameOverWindow() {
        String gameOverMessage = "";
        int score = getWorld().getObjects(GemScore.class).get(0).returnScore();
        if (score == 10) {victory = true;}
        if (victory == true) {gameOverMessage = "You are victorious!";}
        else {gameOverMessage = "You are dead";}
        
        //set image background
        GreenfootImage background = new GreenfootImage(600, 300);
        if (victory == true) {background.setColor(new Color(0, 255, 100));}
        else {background.setColor(new Color(255, 0, 100));}
        background.setTransparency(75);
        background.fillRect(0, 0, 600, 300);
        image.drawImage(background, 0, 0);
        image.scale(600, 300);
        
        /*----------* draw strings into image *----------*/
        image.setFont(new Font("Arial", Font.BOLD, 20));
        String text1 = elapsedTime();
        Dimension dim1 = getTextDimensions(image, text1);
        image.setColor(new Color(200, 200, 200));
        image.drawString(text1, image.getWidth()/2-(int)(dim1.getWidth()/2)+1, image.getHeight()/2-79);
        image.setColor(new Color(0, 0, 0));
        image.drawString(text1, image.getWidth()/2-(int)(dim1.getWidth()/2), image.getHeight()/2-80);
        
        String text2 = "Gems collected: "+ score;
        Dimension dim2 = getTextDimensions(image, text2);
        image.setColor(new Color(200, 200, 200));
        image.drawString(text2, image.getWidth()/2-(int)(dim2.getWidth()/2)+1, image.getHeight()/2-49);
        image.setColor(new Color(0, 0, 0));
        image.drawString(text2, image.getWidth()/2-(int)(dim2.getWidth()/2), image.getHeight()/2-50);
        
        image.setFont(new Font("Arial", Font.BOLD, 48));
        String text3 = gameOverMessage;
        Dimension dim3 = getTextDimensions(image, text3);
        image.drawString(text3, image.getWidth()/2-(int)(dim3.getWidth()/2)+1, image.getHeight()/2+11);
        if (victory == true) {image.setColor(new Color(100, 255, 0));}
        else {image.setColor(new Color(255, 100, 0));}
        image.drawString(text3, image.getWidth()/2-(int)(dim3.getWidth()/2)-1, image.getHeight()/2+9);
        
        image.setFont(new Font("Arial", Font.BOLD, 16));
        String text4 = randomJoke();
        Dimension dim4 = getTextDimensions(image, text4);
        image.setColor(new Color(200, 200, 200));
        image.drawString(text4, image.getWidth()/2-(int)(dim4.getWidth()/2)+1, image.getHeight()/2+76);
        image.setColor(new Color(0, 0, 0));
        image.drawString(text4, image.getWidth()/2-(int)(dim4.getWidth()/2), image.getHeight()/2+75);
        /*-----------------------------------------------*/
        
        setImage(image);
    }
    
    public String randomJoke() {
        String text = "";
        String[] victoryJoke = {
            "Calm down bro its just a game",
            "Are you a pro asian player",
            "Nice cheats.",
            "Not bad try to be faster next time",
            "Awsome skills",
            "You completed the game you collected all the diamonds like a boss",
            "",
            ""
        };
        String[] failureJoke = {
            "Walk it off.",
            "I bet you wouldnt last 5 secs.",
            "Rifati pwned you.",
            "Maybe you should start playing league of legends.",
            "Go and play flappy bird its easier for your standards*cough* scrub.",
            "When the game is over it is really just beginning.",
            "you think this is game over wait untill you get married bro XD",
            "For shame.",
            "up,down,left,right,select,start thats the konami code for extralives use it next time noob.",
        };

        if (victory == true) {text = victoryJoke[(int)(Math.random()*victoryJoke.length)];}
        else {text = failureJoke[(int)(Math.random()*failureJoke.length)];}
        return text;
    }
    
}