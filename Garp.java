import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MARIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor

{
  private GreenfootImage imageLeft;

  private GreenfootImage imageRight;




  public Garp()

  {
    imageLeft = new GreenfootImage("GarpLeft.png");


    imageRight = new GreenfootImage("GarpRight.png");
   
    setImage(imageRight); 
    
    
  }

public void act() 
{
    Actor diamond;

    diamond = getOneObjectAtOffset(0, 0, diamonds.class);
    if(diamond != null) { //Als Garp een diamant ziet
        getWorld().removeObject(diamond); //Verwijder de diamant van de wereld
        
    }
    
    
        {if(Greenfoot.isKeyDown("right")) {
    if(getImage() == imageLeft) {

        setImage(imageRight);

    }
    setRotation(0);
    move(5);

}
    if(Greenfoot.isKeyDown("left")) {
        if(getImage() == imageRight) {

            setImage(imageLeft);

        }
        setRotation(180);

        move(5);

    }
    if(Greenfoot.isKeyDown("up")) {
        if(getImage() == imageLeft) {

            setImage(imageRight);

        }
        setRotation(-90);

        move(5);

    }

    if(Greenfoot.isKeyDown("down")) {
        if(getImage() == imageLeft) {

            setImage(imageRight);

        }
        setRotation(90);

        move(5);    
    
    
    
    
    }



        }
    

       if (checkRock() == true) {move(-5);} 
       

    }
    
    public boolean checkRock() {
        Actor rock = getOneObjectAtOffset(0, 0, Rock.class);
        if(rock != null) {
            return true;
        }
        else {return false;}
    }

} 
    