package com.qfedu.demo.soundsystem;

public class Music {

    private String title;
    private Integer duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("--在" + this.toString() + "中注入title");
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
        System.out.println("--在" + this.toString() + "中注入duration");
    }

    public Music() {
        super();
        System.out.println("Music的构造函数......" + this.toString());
    }

    public Music(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }
}
