/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulgame;

import java.awt.Graphics;

/**
 *
 * @author Nenden
 */
public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected double vel_x;
    protected double vel_y;
    protected int num;
    protected int size;

    public GameObject(int x, int y, ID id, int num, int size) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.num = num;
        this.size = size;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getVel_x() {
        return vel_x;
    }

    public void setVel_x(double vel_x) {
        this.vel_x = vel_x;
    }

    public double getVel_y() {
        return vel_y;
    }

    public void setVel_y(double vel_y) {
        this.vel_y = vel_y;
    }

}
