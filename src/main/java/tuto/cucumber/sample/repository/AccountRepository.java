package tuto.cucumber.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuto.cucumber.sample.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
