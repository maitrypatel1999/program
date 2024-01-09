package com;

import com.entity.*;
import com.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class App  implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Autowired
  ClientRepository clientRepository;
  @Autowired
  PersonRepository personRepository;
  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  AccountRepository accountRepository;
  @Autowired
  AccountGroupRepository accountGroupRepository;
  @Autowired
  TransactionRepository transactionRepository;
  @Autowired
  TutorialRepository tutorialRepository;


  @Override
  public void run(String... args) throws Exception {
//    personRepository.save(new Person(null, "Roshan", "Patel", "228 Wellington Pl, Edison, NJ 08817", "732-325-8298" ));
//    personRepository.save(new Person(null, "Maitry", "Patel", "20 Indian Ln, Burlngton, NJ 08016", "732-111-2222" ));
//    personRepository.save(new Person(null, "Rupak", "Trivedi", "228 Wellington Pl, Edison, NJ 08817", "732-325-8298" ));
//    personRepository.save(new Person(null, "Moksha", "Kahodariya", "20 Indian Ln, Burlngton, NJ 08016", "732-111-2222" ));
//
//    employeeRepository.save(new Employee(null, "Roshan", "228 Wellington Pl, Edison, NJ 08817", "732-325-8298", "SALES", 100000D ));
//    employeeRepository.save(new Employee(null, "Maitry", "20 Indian Ln, Burlngton, NJ 08016", "732-111-2222", "ACCOUNTING", 120000D ));
//    employeeRepository.save(new Employee(null, "Rupak", "228 Wellington Pl, Edison, NJ 08817", "732-325-8298", "SALES", 200000D ));
//    employeeRepository.save(new Employee(null, "Moksha", "20 Indian Ln, Burlngton, NJ 08016", "732-111-2222", "ACCOUNTING", 90000D ));

    tutorialRepository.save(new Tutorial(1l, "Book1", "Book1 Desc", true));
    tutorialRepository.save(new Tutorial(2l, "Book2", "Book2 Desc", false));

    clientRepository.save(new Client(1l, "Roshan", 1234l, "228 Wellington" ));
    clientRepository.save(new Client(2l, "Maitry", 5678l, "20 Indian" ));

    accountGroupRepository.save(new AccountGroup(1l, 1l, "TD", 1l ));
    accountGroupRepository.save(new AccountGroup(2l, 1l, "Chase", 2l));

    accountGroupRepository.save(new AccountGroup(3l, 2l, "TD", 1l ));
    accountGroupRepository.save(new AccountGroup(4l, 2l, "Chase", 2l));

    accountRepository.save(new Account(1l, 1l, 1l, 12345l, "Roshan TD", "Roshan Checking TD", "Checking", 10000D ));
    accountRepository.save(new Account(2l, 1l, 1l, 12346l, "Roshan TD Savings", "Roshan Savings TD", "Saving", 2000D ));
    accountRepository.save(new Account(3l, 1L, 2l, 67890l, "Roshan Chase", "Roshan Savings Chase", "Saving", 238900D ));

    accountRepository.save(new Account(4l, 2l, 3l, 121211L, "Maitry TD", "Maitry Checking TD", "Checking", 100D ));
    accountRepository.save(new Account(5l, 2L, 4l, 343334L, "Maitry Chase", "Maitry Savings Chase", "Checking", 250D ));

    transactionRepository.save(new Transaction(1l, 1l, 1l, 1000d, new Date()));
    transactionRepository.save(new Transaction(2l, 1l, 2l, 1500d, new Date()));
    transactionRepository.save(new Transaction(3l, 1l, 3l, 30000d, new Date()));
    transactionRepository.save(new Transaction(4l, 1l, 1l, 4000d, new Date()));
    transactionRepository.save(new Transaction(5l, 1l, 2l, 8000d, new Date()));

    transactionRepository.save(new Transaction(6l, 2l, 4l, 9000d, new Date()));
    transactionRepository.save(new Transaction(7l, 2l, 5l, 2500d, new Date()));
    transactionRepository.save(new Transaction(8l, 2l, 4l, 2000d, new Date()));
    transactionRepository.save(new Transaction(9l, 2l, 5l, 3000d, new Date()));

  }
}
