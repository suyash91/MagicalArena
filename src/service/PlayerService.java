package service;

import model.Player;

import java.util.Scanner;

public class PlayerService {
     void playerService(Player player){
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player  Name, Strength, Health, Attack");
        player.setPlayerName(sc.nextLine());
        player.setStrength(Integer.parseInt(sc.nextLine()));
        player.setHealth(Integer.parseInt(sc.nextLine()));
        player.setAttack(Integer.parseInt(sc.nextLine()));

    };


}
