package com.ssafy.happyhouse.model.dto;

public class Notice {
    int idx;
    String title;
    String content;

    public Notice() {
        super();
    }

    public Notice(int idx, String title, String content) {
        this.idx = idx;
        this.title = title;
        this.content = content;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
