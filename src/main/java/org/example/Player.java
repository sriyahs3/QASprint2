package org.example;

public class Player{

    private String name;
    private int x_pos, y_pos;

    public Player(){
        this.name = "Default";
    }
    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getX_pos() {
        return x_pos;
    }
    public int getY_pos() {
        return y_pos;
    }
    public void setPosition(int x, int y){
        this.x_pos = x;
        this.y_pos = y;
    }

    public void move(char keyPressed, int max_x, int max_y){
        switch (keyPressed){
            // Up
            case 'w':
                if (this.y_pos == max_y)
                    System.out.println("You cannot move up! You are have reached the maximum Y position");
                else
                    this.y_pos ++;
                break;
            // left
            case 'a':
                if (this.x_pos == 1)
                    System.out.println("You cannot move left! You are have reached the minimum X position");
                else
                    this.x_pos --;
                break;
            // Down
            case 's':
                if (this.y_pos == 1)
                    System.out.println("You cannot move down! You are have reached the minimum Y position");
                else
                    this.y_pos --;
                break;
            // right
            case 'd':
                if (this.x_pos == max_x)
                    System.out.println("You cannot move right! You are have reached the maximum X position");
                else
                    this.x_pos ++;
                break;
            default:
                System.out.println("Invalid key pressed, please use w-a-s-d");
        }
    }
}