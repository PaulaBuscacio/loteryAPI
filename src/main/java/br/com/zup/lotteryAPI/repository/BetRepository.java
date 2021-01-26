package br.com.zup.lotteryAPI.repository;

import br.com.zup.lotteryAPI.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {

   Bet findBetByUserEmail(String userEmail);

}
