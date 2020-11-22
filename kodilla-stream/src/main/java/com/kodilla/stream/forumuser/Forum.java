package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private  final List<ForumUser> theForumList = new ArrayList<>();

    public Forum() {
        theForumList.add(new ForumUser(2, "kris", 'M', LocalDate.of(1999,07,04), 0));
        theForumList.add(new ForumUser(3, "Tom",'M', LocalDate.of(2000,03,11), 3));
        theForumList.add(new ForumUser(4, "Katya", 'F', LocalDate.of(1989,04,22), 10));
        theForumList.add(new ForumUser(5, "Xena", 'F', LocalDate.of(2008,8,21), 20));
        theForumList.add(new ForumUser(6, "Kara", 'F', LocalDate.of(1969,9,13), 0));
        theForumList.add(new ForumUser(7, "Jake", 'M', LocalDate.of(1991,01,15), 51));
        theForumList.add(new ForumUser(8, "Dick", 'M', LocalDate.of(1992,02,16), 4));
        theForumList.add(new ForumUser(9, "Hans", 'M', LocalDate.of(2005,03,25), 8));
        theForumList.add(new ForumUser(1, "Ragnar", 'M', LocalDate.of(2010,11,05), 0));

    }
    public List<ForumUser> getUserList() {

        return new ArrayList<>(theForumList);
        }

    }
