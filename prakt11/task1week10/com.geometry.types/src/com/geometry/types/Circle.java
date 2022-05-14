package com.geometry.types;

public class Circle extends Point{

    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if(radius > 0)
        {
            this.radius = radius;
            return;
        }

        this.radius = 1;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null)
        {
            return 1;
        }
        if(!(o instanceof Circle circle))
        {
            return 1;
        }

        int result = super.compareTo(circle);

        if(result != 0)
        {
            return result;
        }
        return radius - circle.radius;
    }

    @Override
    public String toString() {
        return String.format("%s, radius: %d", super.toString(), radius);
    }
}
