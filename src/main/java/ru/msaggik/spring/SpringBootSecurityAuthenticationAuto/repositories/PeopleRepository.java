package ru.msaggik.spring.SpringBootSecurityAuthenticationAuto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.msaggik.spring.SpringBootSecurityAuthenticationAuto.models.Person;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    // поиск пользователя по имени
    Optional<Person> findByUsername(String username);
}
