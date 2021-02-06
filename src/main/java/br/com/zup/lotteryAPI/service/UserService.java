package br.com.zup.lotteryAPI.service;

import br.com.zup.lotteryAPI.entity.Bet;
import br.com.zup.lotteryAPI.entity.User;
import br.com.zup.lotteryAPI.repository.BetRepository;
import br.com.zup.lotteryAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BetRepository betRepository;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }



}
