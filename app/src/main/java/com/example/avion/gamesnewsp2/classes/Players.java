package com.example.avion.gamesnewsp2.classes;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Players {

    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("biografia")
    @Expose
    private String biografia;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("__v")
    @Expose
    private Integer v;


    public Players(String avatar, String id, String name, String biografia, String game) {
        this.avatar = avatar;
        this.id = id;
        this.name = name;
        this.biografia = biografia;
        this.game = game;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}



