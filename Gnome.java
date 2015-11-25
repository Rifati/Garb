import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnome extends Actor {
    /**
     * Act - do whatever the Gnome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() {
        if (checkCollision() == false) {
            move(1);
            if(atWorldEdge()) {
                move(-1);
                setRotation(getRotation() + 180);
            }
            if(Greenfoot.getRandomNumber(100) <4 ) {
                setRotation(getRotation() - 180 + Greenfoot.getRandomNumber(360));
            }
        }
        
        checkCollision();
    }
    
    
    public boolean atWorldEdge() { 
        
        int x, y, i, j; //declaratie van i toegevoegd voor de helft van breedte van de afbeelding

        x = getX(); 
        y = getY();
        i = getImage().getWidth() / 2; //Vraag de breedte van de afbeelding op en deel deze door twee
        j = getImage().getHeight() / 2; //Vraag de hoogte van de afbeelding op en deel deze door twee
        
        if(x <= i) { //Aan de linkerkant van de wereld
            return true;
        }
        if(y <= j) { //Aan de bovenkant van de wereld
            return true;
        }
        if(x+i >= getWorld().getWidth()) { //Aan de rechterkant van de wereld
            return true;
        }
        if(y+j >= getWorld().getHeight()) { //Aan de onderkant van de wereld
            return true;
        }
        
        return false;
        
    }
    
    public boolean checkCollision() {
        Actor object = getOneObjectAtOffset(0, 0, Actor.class);
        if(object != null) {
            move(-10);
            setRotation(getRotation() + 90 + Greenfoot.getRandomNumber(180));
            return true;
        }
        else {return false;}
    }

}