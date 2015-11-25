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
        public boolean isDead = false;
        GreenfootImage noImg = new GreenfootImage(1, 1);
        
        
        
        public Garp()
        
        {
            imageLeft = new GreenfootImage("GarpLeft.png");
            
            
            imageRight = new GreenfootImage("GarpRight.png");
            
            setImage(imageRight); 
            
            
        }
        
        public void act() 
        {
            if (checkdeath() == false) {
                Actor diamond;
                
                diamond = getOneObjectAtOffset(0, 0, diamonds.class);
                checkExploded();
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
    }
    
    public boolean checkRock() {
        Actor rock = getOneObjectAtOffset(0, 0, Rock.class);
        if(rock != null) {
            return true;
        }
        else {return false;}
    }
public boolean checkdeath() {
        Actor gnome = getOneObjectAtOffset(0, 0, Gnome.class);
        if(gnome != null) {
            getWorld().removeObject(this);
            return true;
        }
        else {return false;}
    }
        public void checkExploded() {
        Actor bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if (bomb != null) {
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(bomb);
            setImage(noImg);
            isDead = true;
        }
        
}
    }