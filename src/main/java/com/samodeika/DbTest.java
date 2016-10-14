package com.samodeika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DbTest implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DbTest.class);

    BugRepository bugRepository;

    @Autowired
    public void setBugRepository(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Hello Spring JPA");

        saveBug();

        readFromDatabase();
        System.out.println("Finished");
    }

    public void saveBug() {
        log.info("Save a bug to database:");
        Calendar cal = Calendar.getInstance();
        bugRepository.save(new Bug("First bug", "First bug", cal.getTime()));
    }

    public void readFromDatabase(){
        log.info("Read all bugs with findAll():");
        Iterable<Bug> bugList = bugRepository.findAll();
        for (Bug bug : bugList) {
            System.out.println(bug.toString());
        }
    }
}
