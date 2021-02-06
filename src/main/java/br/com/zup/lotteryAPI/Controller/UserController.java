package br.com.zup.lotteryAPI.Controller;


import br.com.zup.lotteryAPI.entity.Bet;
import br.com.zup.lotteryAPI.entity.User;
import br.com.zup.lotteryAPI.service.BetService;
import br.com.zup.lotteryAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/")

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BetService betService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);

    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {

      return userService.saveUser(user);
    }

    @GetMapping("/user/{email}")
    public User findByEmail(@PathVariable String email) {
       return  userService.findByEmail(email);
    }

    @GetMapping("/bets")
    public List<Bet> getAllBets() {
        return betService.getAllBets();
    }


    @PostMapping("/newBet/{userEmail}")
    public Bet saveBet(Bet bet) {

        return betService.saveBet(bet);
    }

}
