package com.kodilla.testing.forum.statistic;

public class CalculateStatistics {

    private Statistics statistics;

    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public int userCount(Statistics statistics) {
        return statistics.usersNames().size();
    }
    public int getNumberPosts(Statistics statistics) {
        return statistics.postsCount();
    }
    public int getNumberComments(Statistics statistics) {
        return statistics.commentsCount();
    }
    public double avrNumberPostsPerUserCount(Statistics statistics) {
        return statistics.postsCount() / userCount(statistics);
    }
    public double avrNumberCommentsPerUserCount(Statistics statistics) {
        return statistics.commentsCount() / userCount(statistics);
    }
    public double avrNumberCommentsPerPosts(Statistics statistics) {
        return statistics.commentsCount() / statistics.postsCount();
    }
    public void calculateAdvStatistics(Statistics statistics) {
        CalculateStatistics result = new CalculateStatistics(statistics);
        result.userCount(statistics);
        result.getNumberComments(statistics);
        result.getNumberPosts(statistics);
        avrNumberCommentsPerPosts(statistics);
        avrNumberPostsPerUserCount(statistics);
        avrNumberCommentsPerUserCount(statistics);
    }
    public String showStatistics(Statistics statistics) {
        return "CalculateStatistics: " +
                " - numberPosts = " + getNumberPosts(statistics) +
                " - numberComments = " + getNumberComments(statistics) +
                " - numberUsers = " + userCount(statistics) +
                " - avrNumberPostsPerUser = " + avrNumberPostsPerUserCount(statistics) +
                " - avrNumberCommentsPerUser = " + avrNumberCommentsPerUserCount(statistics) +
                " - avrNumberCommentsPerPost = " + avrNumberCommentsPerPosts(statistics);
    }
}
