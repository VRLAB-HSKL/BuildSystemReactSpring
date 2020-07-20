package com.hskl.buildsystem.data.buildsystem.unity.data;

/**
 * This class reflects the JSON format to be transferred
 */
public class UnityProjectNames {

    //index as counter
    private int index;

    //unity project name
    private String ProjectName;

    /**
     * ctor
     */
    public UnityProjectNames() {

    }

    /**
     * ctor with params
     * @param index as counter
     * @param projectName as unity project name
     */
    public UnityProjectNames(int index, String projectName) {
        this.index = index;
        ProjectName = projectName;
    }

    /**
     * Get Index
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Set Index
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * get project name
     * @return ProjectName - unity project name
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * set project name
     * @param projectName
     */
    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    /**
     * default toString()
     * @return class as string
     */
    @Override
    public String toString() {
        return "UnityProjectNames{" +
                "index=" + index +
                ", ProjectName='" + ProjectName + '\'' +
                '}';
    }
}
