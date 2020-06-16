package com.hskl.buildsystem.data.buildsystem.ui.data;

/**
 * This class represents the status like in progress or stable
 */
public class Status {

    //in progress status
    private boolean inProgress;

    //stable status
    private boolean stable;

    /**
     * ctor
     */
    public Status() {

    }

    /**
     * get inprogress status
     * @return inProgress
     */
    public boolean isInProgress() {
        return inProgress;
    }

    /**
     * set inporgress status
     * @param inProgress
     */
    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    /**
     * get stable status
     * @return
     */
    public boolean isStable() {
        return stable;
    }

    /**
     * set stable status
     * @param stable
     */
    public void setStable(boolean stable) {
        this.stable = stable;
    }

    /**
     * toString method
     * @return class in string format
     */
    @Override
    public String toString() {
        return "Status{" +
                "inProgress=" + inProgress +
                ", stable=" + stable +
                '}';
    }
}
