package com.java_basic.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class GithubIssue implements Cloneable {

    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String title;

    @Getter
    private GithubRepository repository;

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }


    public String getUrl() {
        return String.format("https://github.com/%s/%s/issues/%d",
                repository.getUser(),
                repository.getName(),
                this.getId());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 얕은 복사
    }


}
