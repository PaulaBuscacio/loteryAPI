package br.com.zup.lotteryAPI.repository;

import br.com.zup.lotteryAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
