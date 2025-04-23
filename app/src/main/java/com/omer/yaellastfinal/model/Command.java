package com.omer.yaellastfinal.model;

public class Command {
    Jar sourceJar;
    Jar targetJar;

    public Command(Jar sourceJar, Jar targetJar) {
        this.sourceJar = sourceJar;
        this.targetJar = targetJar;
    }

    public Jar getSourceJar() {
        return sourceJar;
    }

    public void setSourceJar(Jar sourceJar) {
        this.sourceJar = sourceJar;
    }

    public Jar getTargetJar() {
        return targetJar;
    }

    public void setTargetJar(Jar targetJar) {
        this.targetJar = targetJar;
    }
}
