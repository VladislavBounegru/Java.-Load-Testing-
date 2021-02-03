package com.bounegru;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String coordinates = "";
            String row;
            while ((row = reader.readLine()) != null) {
                coordinates += row;
            }
            String sphereString = coordinates.substring(coordinates.indexOf("sphere"));
            String lineString = coordinates.substring(coordinates.indexOf("{["));
            Line line = Line.getLine(lineString);
            Sphere sphere = Sphere.getSphere(sphereString);
            System.out.println(doSomeMath(sphere, line));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String doSomeMath(Sphere sphere, Line line) {
        double a = Math.pow(line.getEnd().getX() - line.getStart().getX(), 2) +
                Math.pow(line.getEnd().getY() - line.getStart().getY(), 2) +
                Math.pow(line.getEnd().getZ() - line.getStart().getZ(), 2);
        double b = -2 * ((line.getEnd().getX() - line.getStart().getX()) * (sphere.getCenter().getX() - line.getStart().getX()) +
                (line.getEnd().getY() - line.getStart().getY()) * (sphere.getCenter().getY() - line.getStart().getY()) +
                (line.getEnd().getZ() - line.getStart().getZ()) * (sphere.getCenter().getZ() - line.getStart().getZ()));
        double c = Math.pow(sphere.getCenter().getX() - line.getStart().getX(), 2) +
                Math.pow(sphere.getCenter().getY() - line.getStart().getY(), 2) +
                Math.pow(sphere.getCenter().getZ() - line.getStart().getZ(), 2) -
                Math.pow(sphere.getRadius(), 2);
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return "Коллизий не найдено";
        }
        double t1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
        double t2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
        String result = "";
        double x1 = line.getStart().getX() + (line.getDeltaX() * t1);
        double y1 = line.getStart().getY() + (line.getDeltaY() * t1);
        double z1 = line.getStart().getZ() + (line.getDeltaZ() * t1);
        result = "(" + x1 + ", " + y1 + ", " + z1 + ")\n";
        if (Double.compare(t1, t2) != 0) {
            double x2 = line.getStart().getX() + (line.getDeltaX() * t2);
            double y2 = line.getStart().getY() + (line.getDeltaY() * t2);
            double z2 = line.getStart().getZ() + (line.getDeltaZ() * t2);
            result += "(" + x2 + ", " + y2 + ", " + z2 + ")";
        }
        return result;
    }


}
