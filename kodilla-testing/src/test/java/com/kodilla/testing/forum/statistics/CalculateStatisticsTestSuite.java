package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistic.CalculateStatistics;
import com.kodilla.testing.forum.statistic.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateStatisticsTestSuite {

    private static int testCounter = 0;

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Prepering to execute Test # " + testCounter);
    }



    @Test
    void testReturn0Post() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        int post = 0;
        when(statisticsMock.postsCount()).thenReturn(post);

        //When
        int numberPosts = calculateStatistics.getNumberPosts(statisticsMock);

        //Then
        assertEquals(0, numberPosts);
    }

    @Test
    void testReturn1000Post() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        int posts = 1000;
        when(statisticsMock.postsCount()).thenReturn(posts);

        //When
        int numberPosts = calculateStatistics.getNumberPosts(statisticsMock);

        //Then
        assertEquals(1000, numberPosts);
    }

    @Test
    void testReturn0Comment() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        int comments = 0;
        when(statisticsMock.commentsCount()).thenReturn(comments);

        //When
        int numberComments = calculateStatistics.getNumberComments(statisticsMock);

        //Then
        assertEquals(0, numberComments);
    }

    @Test
    void testReturn1000Comment() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        int comments = 1000;
        when(statisticsMock.commentsCount()).thenReturn(comments);

        //When
        int numberComments = calculateStatistics.getNumberComments(statisticsMock);

        //Then
        assertEquals(1000, numberComments);
    }

    @Test
    void testReturnCommentNumberIsLessThenPostNumber() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        int posts = 200;
        int comments = 100;
        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);

        //When
        int postNumber = calculateStatistics.getNumberPosts(statisticsMock);
        int commentNumber = calculateStatistics.getNumberComments(statisticsMock);


        //Then
        assertEquals(100, commentNumber);
        assertEquals(200, postNumber);
    }

    @Test
    void testReturnPostNumberIsLessThenCommentNumber() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        int posts = 100;
        int comments = 200;
        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);

        //When
        int postNumber = calculateStatistics.getNumberPosts(statisticsMock);
        int commentNumber = calculateStatistics.getNumberComments(statisticsMock);


        //Then
        assertEquals(200, commentNumber);
        assertEquals(100, postNumber);
    }

    @Test
    void testUsersNumberIs0() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(users);

        //When
        int userNumbers0 = calculateStatistics.userCount(statisticsMock);

        //Then
        assertEquals(0, userNumbers0);
    }

    @Test
    void testUsersNumberIs100() {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> users = new ArrayList<>();
            for (int i=1; i<=100; i++) {
                users.add("User" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(users);

        //When
        int userNumbers100 = calculateStatistics.userCount(statisticsMock);

        //Then
        assertEquals(100, userNumbers100);
    }
}

