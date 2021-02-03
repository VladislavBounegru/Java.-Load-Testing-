package com.bounegru;

import java.util.Arrays;

public class Line {
    private Coordinates start;
    private Coordinates end;

    public Line(Coordinates start, Coordinates end) {
        this.start = start;
        this.end = end;
    }

    public static Line getLine(String lineString) {
        if (lineString.contains("sphere")) {
            lineString = lineString.substring(0, lineString.indexOf(", sphere"));
        }
        lineString = lineString.replaceAll("\\[|\\]|\\{|\\}|\\s", "");

        double[] coordsDouble = Arrays.stream(lineString.split(",")).mapToDouble(Double::parseDouble).toArray();
        Coordinates lineStart = new Coordinates(coordsDouble[0], coordsDouble[1], coordsDouble[2]);
        Coordinates lineEnd = new Coordinates(coordsDouble[3], coordsDouble[4], coordsDouble[5]);

        return new Line(lineStart, lineEnd);
    }

    public Coordinates getStart() {
        return start;
    }

    public void setStart(Coordinates start) {
        this.start = start;
    }

    public Coordinates getEnd() {
        return end;
    }

    public void setEnd(Coordinates end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public double getDeltaX() {
        return end.getX() - start.getX();
    }

    public double getDeltaY() {
        return end.getY() - start.getY();
    }

    public double getDeltaZ() {
        return end.getZ() - start.getZ();
    }

}
