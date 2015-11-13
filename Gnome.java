import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnome extends Actor
{
    /**
     * Act - do whatever the Gnome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
{
    	move(10);
if(Greenfoot.getRandomNumber(100) > 90) setRotation(getRotation() + 30);
if(atWorldEdge()) {
if(Greenfoot.getRandomNumber(10) > 5) {
 setRotation(getRotation() + 255);
    		}
else {
   setRotation(getRotation() - 255);
    		}
    	}
    }
 public boolean atWorldEdge()

{ 

 int x , i; //declaratie van i toegevoegd voor de helft van breedte van de afbeelding

 

 x = getX(); 

 i = getImage().getWidth() / 2; //Vraag de breedte van de afbeelding op en deel deze door twee

 if(x <= i) { //Aan de linkerkant van de wereld

 return true;

 }

 return false;

}}