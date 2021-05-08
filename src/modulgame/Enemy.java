/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulgame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.math.*;

/**
 *
 * @author Nenden
 */
public class Enemy extends GameObject {

    int num;
    private ArrayList<GameObject> players = new ArrayList<>();
    private Random rng;
    private int speed;

    public Enemy() 
    {
       
    }

    public void addPlayer(Player player) 
    {
        this.players.add(player);
    }

    public void removePlayer(Player player) 
    {
        this.players.remove(player);
    }

    @Override
    public void tick() 
    {
        x += vel_x;
        y += vel_y;

        if ((x != Game.clamp(x, 0, Game.WIDTH - 80)) || (y != Game.clamp(y, 0, Game.HEIGHT - 100))) 
        {
            x = Game.clamp(x, 0, Game.WIDTH - 70);
            y = Game.clamp(y, 0, Game.HEIGHT - 90);
            GameObject player = players.get(rng.nextInt(players.size()));
            double dist = Math.pow((player.getX() - x), 2) + Math.pow((player.getY() - y), 2);
            double vel = Math.sqrt(dist);
            vel = ((vel > 0) ? vel : 1.0)/speed;
            vel_x = (int) ((player.getX() - x) / vel);
            vel_y = (int) ((player.getY() - y) / vel);
        }
    }

    @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }
}
