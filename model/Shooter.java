package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Shooter extends GameElement {

    public static final int UNIT_MOVE = 10; //move by ten pixels

    private ArrayList<GameElement> components = new ArrayList<>(); // our shooter is 4 squares, thus the need for the array.
    private ArrayList<GameElement> weapons = new ArrayList<>();


    public Shooter(int x, int y){
        super(x, y, 0, 0);

        var size = ShooterElement.SIZE;
        var s1 = new ShooterElement(x - size, y - size, Color.white, false); // here, we put the squares together by substracting size. This makes sure our squares are where they need to be.
        var s2 = new ShooterElement(x, y - size, Color.white, false);
        var s3 = new ShooterElement(x - size, y, Color.white, false);
        var s4 = new ShooterElement(x, y, Color.white, false);
        components.add(s1);
        components.add(s2);
        components.add(s3);
        components.add(s4);
    }

    public void moveLeft(){
        super.x -= UNIT_MOVE; // moving the shooter
        for (var c: components){ //moving each square
            c.x -= UNIT_MOVE;
        }
    }

    public void moveRight(){
        super.x += UNIT_MOVE; // moving the shooter
        for (var c: components){ //moving each square
            c.x += UNIT_MOVE;
        }
    }

    @Override
    public void render(Graphics2D g2) {
      
        for(var c: components){
            c.render(g2);
        }
        for (var w: weapons)
            w.render(g2);

    }

    @Override
    public void animate() { 
        for (var w: weapons)
            w.animate();
    }

    public ArrayList<GameElement> getWeapons() {
        return weapons;
    }
    
}
