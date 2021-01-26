package br.com.zup.lotteryAPI.service;



public class LotteryService {

    public Integer setRandomNumber() {
        double randomNumber = Math.random();

        return (int) randomNumber;

    }


}
