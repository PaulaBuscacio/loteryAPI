package br.com.zup.lotteryAPI.service;

import br.com.zup.lotteryAPI.entity.Bet;
import br.com.zup.lotteryAPI.repository.BetRepository;
import br.com.zup.lotteryAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BetService {

    @Autowired
    BetRepository betRepository;

    @Autowired
    UserRepository userRepository;

    public Bet saveBet(Bet bet) {
        bet.setUser(userRepository.findByEmail(bet.getUserEmail()));
        bet.setLuckyNumbers(bet.getLuckyNumbers());


        return betRepository.save(bet);
    }



    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    public Bet getBetsByUserEmail(@PathVariable String userEmail) {
        return betRepository.findBetByUserEmail(userEmail);
    }



}
