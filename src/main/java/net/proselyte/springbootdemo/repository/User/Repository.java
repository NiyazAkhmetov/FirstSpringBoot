package net.proselyte.springbootdemo.repository.User;

import net.proselyte.springbootdemo.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<User, Long> {
    List<User> findByLastName(String lastName);
}
