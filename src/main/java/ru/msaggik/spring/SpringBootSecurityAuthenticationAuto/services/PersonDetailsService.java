package ru.msaggik.spring.SpringBootSecurityAuthenticationAuto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.msaggik.spring.SpringBootSecurityAuthenticationAuto.models.Person;
import ru.msaggik.spring.SpringBootSecurityAuthenticationAuto.repositories.PeopleRepository;
import ru.msaggik.spring.SpringBootSecurityAuthenticationAuto.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    // внедрение репозитория
    private final PeopleRepository peopleRepository;
    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    // загрузка пользователя по имени пользователя
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(s);

        // проверка поиска имени
        if (person.isEmpty()) // если такого имени пользователя не найдено,
            // то будет выброшено исключение
            throw new UsernameNotFoundException("User not found!");
        // иначе происходит возврат найденного значения
        return new PersonDetails(person.get());
    }
}
