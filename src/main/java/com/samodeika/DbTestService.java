package com.samodeika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class DbTestService {

    BugRepository bugRepository;

    @Autowired
    public void setBugRepository(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public void saveSomething() {
        Calendar cal = Calendar.getInstance();
        bugRepository.save(new Bug("First bug", "First bug", cal.getTime()));
    }

    public void readFromDatabase(){
        Iterable<Bug> bugList = bugRepository.findAll();
        for (Bug bug : bugList) {
            System.out.println(bug.toString());
        }
        System.out.println("Read finished");
    }

}
