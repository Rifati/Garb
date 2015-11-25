import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
private GreenfootSound sound = new GreenfootSound("Zelda.mp3");
public void started()
{
 sound.playLoop();
}
public void stopped() 
 {
 sound.stop();
 }
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        addObject(new Garp(), 50, 50);
        addObject(new Gnome(), 350, 250);       
        for(int teller = 0; teller < 10; teller ++) {
addObject(new diamonds(), Greenfoot.getRandomNumber(700), 
Greenfoot.getRandomNumber(500));
}
        for(int teller = 0; teller < 10; teller ++) {
addObject(new Rock(), Greenfoot.getRandomNumber(700), 
Greenfoot.getRandomNumber(500));
}
        for(int teller = 0; teller < 4; teller ++) {
addObject(new Bomb(), Greenfoot.getRandomNumber(700), 
Greenfoot.getRandomNumber(500));
}
    }
}
