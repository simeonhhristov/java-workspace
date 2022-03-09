package shape;

public class Rectangle {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
        color = "yellow";
    }

    public Rectangle() {
        width = 1;
        height = 1;
        color = "yellow";
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width > 0){
            this.width = width;
        }
        else {
            this.width = 1;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height > 0){
            this.height = height;
        }
        else {
            this.height = 1;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color != null)
        {
            this.color = color;
        } else{
            this.color = "yellow";
        }

    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
