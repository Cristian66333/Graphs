package org.example.domain;

import java.util.UUID;

public class Student {
    private UUID id;
    private String name;
    private int failedSubjects;

    public Student(String name, int failedSubjects) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.failedSubjects = failedSubjects;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFailedSubjects() {
        return failedSubjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", failedSubjects=" + failedSubjects +
                '}';
    }
}
