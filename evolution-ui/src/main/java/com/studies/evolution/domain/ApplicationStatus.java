package com.studies.evolution.domain;

public enum ApplicationStatus {

    AWAITING,
    RUNNING,
    FINISHED;


    public String getName() {
        return this.name().toLowerCase();
    }

}
