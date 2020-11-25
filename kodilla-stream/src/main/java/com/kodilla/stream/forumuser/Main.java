package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Forum forum = new Forum();

        List<ForumUser> theResultListOfForum = forum.getUserList().stream()
                .filter(user-> Period.between(user.getBirthDate(), LocalDate.now()).getYears()>=20)
                .filter(user -> user.getPostNumber() >=1)
                .filter(user -> user.getSex() == 'M')
                .collect(Collectors.toList());

        Map<Integer,ForumUser> theResultMapOfForum = theResultListOfForum.stream()
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));



        System.out.println("# elements: " + theResultMapOfForum.size());
        theResultMapOfForum.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
