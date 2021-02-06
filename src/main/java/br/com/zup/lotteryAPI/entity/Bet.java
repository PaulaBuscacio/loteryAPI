package br.com.zup.lotteryAPI.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Bet  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long betId;
    private String luckyNumbers;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JoinColumn(name="userEmail", referencedColumnName = "email")
    private String userEmail;


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetIdId(Long id) {
        this.betId = id;
    }

    public String getLuckyNumbers() {
        return luckyNumbers;
    }


    public void setLuckyNumbers(String luckyNumbers) {
        luckyNumbers = setRandomNumber();
        this.luckyNumbers = luckyNumbers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static String setRandomNumber() {
       List randomNumbers = new ArrayList();
        String resultArrayToString = new String();
       while (randomNumbers.size() < 6) {
           Integer  randomNumber = (int) (Math.random() *60) + 1;
           randomNumbers.add(randomNumber);

            resultArrayToString = (String) randomNumbers.stream()
                   .map(number -> String.valueOf(number))
                   .collect(Collectors.joining(", ","{", "}"));
       }

        return resultArrayToString;

    }

}
