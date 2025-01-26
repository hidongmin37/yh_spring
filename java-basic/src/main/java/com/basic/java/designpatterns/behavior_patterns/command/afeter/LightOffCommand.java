package com.basic.java.designpatterns.behavior_patterns.command.afeter;

import com.basic.java.designpatterns.behavior_patterns.command.before.Light;

public class LightOffCommand implements Command{

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        new LightOnCommand(light).execute();
    }
}
