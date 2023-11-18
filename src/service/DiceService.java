package service;

import java.util.Random;

public class DiceService {

    //TODO: Create dice interface strategy -> Single dice class should implement it
    public int rollDice(){
        Random ranNum = new Random();
        int randomNumber = ranNum.nextInt(6) + 1;
        return randomNumber;
    }
}
