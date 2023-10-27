package org.example;

public abstract class Monster{
    private int x_pos, y_pos;

    public Monster(int x_pos, int y_pos){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public abstract String getMonsterName();
    public abstract void displayGreetings();
}

class Dragon extends Monster{
    public Dragon(int x_pos, int y_pos){
        super(x_pos, y_pos);
    }

    @Override
    public String getMonsterName(){
        return "Dragon Smaug";
    }
    @Override
    public void displayGreetings(){
        // -Smaug, the dragon from The Hobbit
        System.out.println("Well, thief! I smell you, I hear your breath, I feel your air. Where are you? Come now, don't be shy... step into the light");
    }
}

class Vampire extends Monster{
    public Vampire(int x_pos, int y_pos){
        super(x_pos, y_pos);
    }
    @Override
    public String getMonsterName(){
        return "Vampire Count Dracula";
    }
    @Override
    public void displayGreetings(){
        // -Count Dracula
        System.out.println("Welcome to my house! Enter freely and of your own will!");
    }
}

class Werewolf extends Monster{
    public Werewolf(int x_pos, int y_pos){
        super(x_pos, y_pos);
    }
    @Override
    public String getMonsterName(){
        return "Werewolf";
    }
    @Override
    public void displayGreetings(){
        // -Werewolf
        System.out.println("Hey there Little Red Riding Hood. You sure are looking good. You're everything a big bad wolf could want...");
    }
}