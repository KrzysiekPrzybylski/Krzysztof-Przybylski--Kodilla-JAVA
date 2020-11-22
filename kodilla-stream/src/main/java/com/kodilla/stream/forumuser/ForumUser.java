package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private final int postNumber;

    public ForumUser(int userID, String name, char sex, LocalDate birthDate, int postNumber) {
        this.userID = userID;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postNumber = postNumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostNumber() {
        return postNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postNumber=" + postNumber +
                '}';
    }
}
