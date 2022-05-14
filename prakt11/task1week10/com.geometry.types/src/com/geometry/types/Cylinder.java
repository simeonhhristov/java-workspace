package com.geometry.types;

public class Cylinder extends Circle {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
            return;
        }
        this.height = 1;
    }

    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        setHeight(height);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }

        if(!(o instanceof  Cylinder cylinder))
        {
            return 1;
        }

        int result = super.compareTo(o);

        if(result != 0)
        {
            return result;
        }
        return height - cylinder.height;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s, height: %d", super.toString(), height);
    }
}
