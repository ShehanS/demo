package com.shehan.app.demo.models;

import akka.actor.Props;

public class GraphData {
    private double value;


    public GraphData(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
