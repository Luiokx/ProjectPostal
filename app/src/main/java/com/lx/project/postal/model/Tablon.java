package com.lx.project.postal.model;

public class Tablon {
    private int id;
    private String description;
    private int likeCount;
    private boolean liked;
    private ProfilePost profilePost;

    public Tablon(int id, String description, int likeCount,boolean liked, ProfilePost profilePost) {
        this.id = id;
        this.description = description;
        this.id = likeCount;
        this.liked = liked;
        this.profilePost = profilePost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public ProfilePost getProfilePost() {
        return profilePost;
    }

    public void setProfilePost(ProfilePost profilePost) {
        this.profilePost = profilePost;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
