package org.example;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class Game{

    private int grid_x;
    private int grid_y;

    private int treasure_x, treasure_y;

    private Player player;
    private Monster[] monsters;

    Random rand = new Random();

    public Game(){
        this.grid_x = 0;
        this.grid_y = 0;
    }
    public Game(int grid_x, int grid_y){
        this.grid_x = grid_x;
        this.grid_y = grid_y;
    }

    public int setRandomX(){
        return rand.nextInt(this.grid_x) + 1;
    }
    public int setRandomY(){
        return rand.nextInt(this.grid_y) + 1;
    }
    public void setUpGame(String player_name){
        // set treasure position
        this.treasure_x = setRandomX();
        this.treasure_y = setRandomY();
        //System.out.println("Treasure position: [" + this.treasure_x+", "+this.treasure_y+"]");

        // initialise monsters
        int monster_x, monster_y;

        do{
            monster_x = setRandomX();
            monster_y = setRandomY();
        }while (monster_x == treasure_x && monster_y== treasure_y);

        Monster dragon = new Dragon(monster_x, monster_y);
        System.out.println("Dragon position: [" + dragon.getX_pos()+", "+dragon.getY_pos()+"]");

        do{
            monster_x = setRandomX();
            monster_y = setRandomY();
        }while ((monster_x == treasure_x && monster_y== treasure_y)|| (monster_x == dragon.getX_pos() && monster_y== dragon.getY_pos()));

        Monster vampire = new Vampire(monster_x, monster_y);
        System.out.println("Vampire position: [" + vampire.getX_pos()+", "+vampire.getY_pos()+"]");

        do{
            monster_x = setRandomX();
            monster_y = setRandomY();
        }while ((monster_x == treasure_x && monster_y== treasure_y) || (monster_x == dragon.getX_pos() && monster_y== dragon.getY_pos()) || (monster_x == vampire.getX_pos() && monster_y== vampire.getY_pos()));

        Monster werewolf = new Werewolf(setRandomX(), setRandomY());
        System.out.println("Werewolf position: [" + werewolf.getX_pos()+", "+werewolf.getY_pos()+"]");

        // initialise monsters array
        monsters = new Monster[]{dragon, vampire, werewolf};

        //set Player position
        this.player = new Player(player_name);
        do{
            this.player.setPosition(setRandomX(), setRandomY());
        }while ((player.getX_pos() == treasure_x && player.getY_pos()== treasure_y) || (player.getX_pos() == dragon.getX_pos() && player.getY_pos()== dragon.getY_pos()) || (player.getX_pos() == vampire.getX_pos() && player.getY_pos()== vampire.getY_pos()) || (player.getX_pos() == werewolf.getX_pos() && player.getY_pos()== werewolf.getY_pos()));

        System.out.println("Player position: [" + player.getX_pos()+", "+player.getY_pos()+"]");
    }

    public void movePlayer(char keyPressed){
        player.move(keyPressed, this.grid_x, this.grid_y);
        System.out.println("Player position: [" + player.getX_pos()+", "+player.getY_pos()+"]");
    }

    public void stepsFromTreasure(){
        int horizontal_diff = Math.abs(treasure_x - player.getX_pos());
        int vertical_diff = Math.abs(treasure_y - player.getY_pos());
        System.out.println("\nYou are " + horizontal_diff + " horizontal and " + vertical_diff + " vertical moves away from the treasure!");
        System.out.println("Choose you next move, use w(up), a(left), s(down), d(right)");
    }

    public boolean checkMonsters(){
        for (Monster monster : monsters){
            if (player.getX_pos() == monster.getX_pos() && player.getY_pos() == monster.getY_pos()){
                monster.displayGreetings();
                System.out.println("You have been caught by the " +monster.getMonsterName()+"!");
                return true;
            }
        }
        return false;
    }

    public boolean reachedTreasure(){
        if (this.player.getX_pos() == this.treasure_x && this.player.getY_pos() == this.treasure_y){
            System.out.println("Congrats "+player.getName()+ "! You have won the treasure!");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("Hi, Welcome to Sprint2 Hunt for the Treasure!");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter you name");
        String player_name = input.nextLine();

        System.out.println("Enter the x dimension for the grid");
        int size_x = input.nextInt();

        System.out.println("Enter the y dimension for the grid");
        int size_y = input.nextInt();

        Game game = new Game(size_x, size_y);
        game.setUpGame(player_name);

        char move;

        while (!game.reachedTreasure() && !game.checkMonsters()){
            game.stepsFromTreasure();
            move = input.next().charAt(0);
            game.movePlayer(move);
        }
    }
}