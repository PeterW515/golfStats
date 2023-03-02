//package com.pwgolf.golfStats;
//
//import com.pwgolf.golfStats.model.impl.PlayedHole;
//import com.pwgolf.golfStats.model.api.PlayedHoleRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.util.stream.Stream;
//
//@Component
//public class Initializer implements CommandLineRunner {
//    private final PlayedHoleRepository repository;
//    public Initializer(PlayedHoleRepository repository){
//        this.repository=repository;
//    }
//    @Override
//    public void run(String... strings){
//        Stream.of("1","2","3","4","5","6","7","8","9").forEach(holeNumber -> repository.save(new PlayedHole(holeNumber)));
//
//        //set first hole data
//        PlayedHole holeOne = repository.findByHoleNumber("1");
//        holeOne.setCourseName("Tup");
//        holeOne.setTees("Blue");
//        holeOne.setDatePlayed(new Date(2023,2,4));
//        holeOne.setPar(4);
//        holeOne.setFairwayInRegulation(true);
//        holeOne.setTeeShotDirection("Center");
//        holeOne.setGreenInRegulation(false);
//        holeOne.setUpAndDown(false);
//        holeOne.setPutts(2);
//        holeOne.setScore(7);
//
//        repository.save(holeOne);
//
//        repository.findAll().forEach(System.out::println);
//
//
//    }
//}
