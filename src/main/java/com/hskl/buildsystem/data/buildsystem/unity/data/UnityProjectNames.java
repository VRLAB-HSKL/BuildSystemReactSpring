package com.hskl.buildsystem.data.buildsystem.unity.data;

public class UnityProjectNames {

    private int index;

    private String ProjectName;

    public UnityProjectNames() {

    }

    public UnityProjectNames(int index, String projectName) {
        this.index = index;
        ProjectName = projectName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    @Override
    public String toString() {
        return "UnityProjectNames{" +
                "index=" + index +
                ", ProjectName='" + ProjectName + '\'' +
                '}';
    }
}
