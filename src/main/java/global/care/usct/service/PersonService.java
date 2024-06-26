package global.care.usct.service;

import global.care.usct.controller.dto.CreatePersonDto;
import global.care.usct.model.Person;
import global.care.usct.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person save(CreatePersonDto personDto) {
    Person person = new Person(personDto);
    return personRepository.save(person);
  }

  public Person save(Person person) {
    return personRepository.save(person);
  }
}
