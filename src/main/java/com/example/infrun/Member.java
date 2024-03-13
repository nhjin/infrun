package com.example.infrun;

public enum Member {
    ;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    Member(Long id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    private Long id;
    private String name;
    private String grade;


}
