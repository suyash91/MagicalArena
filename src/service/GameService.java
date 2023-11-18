package service;

import model.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameService {

    DiceService Dice;

    public void play(){
        System.out.println("-----------WELCOME-----------");
        System.out.println("-----------------------------MAGICAL_ARENA---------------------------");
        Queue<Player> queue;
        Dice = new DiceService();


        Player player1 = new Player();
        Player player2 = new Player();


        PlayerService initializePlayer = new PlayerService();

        initializePlayer.playerService(player1);
        initializePlayer.playerService(player2);

        // enque in queue player with lower health followed by 2nd


        queue = setAttacker(player1, player2);
        //Start game until any player health <= 0
            while(true){
            Player attacker = queue.poll();
            int diceValue = Dice.rollDice();
            int attack = attackCalculate(attacker, diceValue);
            queue.add(attacker);

            printAttackerData(attacker,diceValue,attack);

            Player defender = queue.peek();

            diceValue = Dice.rollDice();

            int defense = defenseCalculate(defender, diceValue);
            printDefenderData(defender,diceValue,defense);
            int health = defender.getHealth();
            int damage = attack - defense;

            if(damage > 0){
                defender.setHealth(health - damage);
                System.out.println("total damage is "+ damage+ " on " +defender.getPlayerName());
            }
            if(health - damage <= 0) break;
            System.out.println("Health of "+defender.getPlayerName()+" "+defender.getHealth());

        }
        queue.poll();
        System.out.println("winner is "+ queue.peek().getPlayerName()+" Health left is "+ queue.peek().getHealth());
    }
    private int attackCalculate(Player p, int diceValue){
        return p.getAttack()*diceValue;
    }
    int defenseCalculate(Player p,int diceValue){
        return p.getStrength() * diceValue;
    }
    Queue<Player> setAttacker(Player player1, Player player2){
        Queue<Player> queue = new LinkedList<>();
        if(player1.getHealth() > player2.getHealth()){
            queue.add(player2);
            queue.add(player1);
        }else {
            queue.add(player1);
            queue.add(player2);
        }
        return queue;
    };

    void printAttackerData(Player p, int diceValue, int attack){
        System.out.print("Dice roll value by attacker "+ p.getPlayerName() +" is "+ diceValue +" ----- " );
        System.out.println("Attack by "+p.getPlayerName()+ " is "+ attack);
    }

    void printDefenderData(Player p, int diceValue, int defense){
        System.out.print("Dice roll value by defender "+ p.getPlayerName() +" is "+ diceValue +" ----- ");
        System.out.println("Defense by "+p.getPlayerName()+ " is "+ defense);
    }
}
