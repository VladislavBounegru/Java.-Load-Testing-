package com.bounegru;

import java.util.Arrays;
import java.util.List;

public class Sphere {
    private Coordinates center;
    private Double radius;

    public Sphere(Coordinates center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    public static Sphere getSphere(String sphereString) {
        if (sphereString.contains("line")) {
            sphereString = sphereString.substring(0, sphereString.indexOf(", line"));
        }
        int endRadius = sphereString.indexOf('}');
        if (sphereString.indexOf("center") > sphereString.indexOf("radius")) {
            endRadius = sphereString.indexOf(',');
        }
        String centerString = sphereString.substring(sphereString.indexOf('[') + 1, sphereString.indexOf(']'));
        String radiusString = sphereString.substring(sphereString.indexOf("radius: ") + 8, endRadius);
        double[] coordsDouble = Arrays.stream(centerString.split(", ")).mapToDouble(Double::parseDouble).toArray();
        Coordinates radiusCoordinates = new Coordinates(coordsDouble[0], coordsDouble[1], coordsDouble[2]);
        return new Sphere(radiusCoordinates, Double.parseDouble(radiusString));
    }

    public Coordinates getCenter() {
        return center;
    }

    public void setCenter(Coordinates center) {
        this.center = center;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
  