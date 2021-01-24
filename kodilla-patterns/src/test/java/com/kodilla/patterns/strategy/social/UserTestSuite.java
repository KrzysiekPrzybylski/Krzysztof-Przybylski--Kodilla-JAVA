package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.CorporateCustomer;
import com.kodilla.patterns.strategy.Customer;
import com.kodilla.patterns.strategy.IndividualCustomer;
import com.kodilla.patterns.strategy.IndividualYoungCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;


public class UserTestSuite {

    @BeforeEach
    void info() {
        System.out.println("New Test");
    }
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User jan = new Millenials("Facebook");
        User ola = new ZGeneration("Twitter");
        User stefan = new YGeneration("Snapchat");

        //When
        String janLikes = jan.sharePost();
        System.out.println("jan likes:  " + janLikes);
        String olaLikes = ola.sharePost();
        System.out.println("ola likes:  " + olaLikes);
        String stefanLikes = stefan.sharePost();
        System.out.println("stefan likes:  " + stefanLikes + "\n");


        //Then
        assertEquals("Facebook", janLikes);
        assertEquals("Twitter", olaLikes);
        assertEquals("Snapchat", stefanLikes);

    }
    @Test
    void testIndividualSharingStrategy() {
        //Given
        User jan = new Millenials("Facebook");
        //When
        String janLikes = jan.sharePost();
        System.out.println("jan likes:  " + janLikes);
        jan.setSocialMedium(new SnapchatPublisher());
        janLikes = jan.sharePost();
        System.out.println("jan likes now:  " + janLikes);


        //Then
        assertEquals("Snapchat", janLikes);

    }
}
