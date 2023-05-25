package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);

    Boolean existsByUserName(String userName);

}
