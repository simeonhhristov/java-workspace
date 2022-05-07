package geometry;

public class Point {
    private int[] coordinates;
    private static final int COORDINATES_LENGTH = 2;

    public Point(int[] coordinates) {
        setCoordinates(coordinates);
    }

    public Point() {
        this(new int[]{0, 0});
    }

    public Point(Point point) {
        this(point.coordinates);
    }

    public int[] getCoordinates() {
        int[] copy = new int[coordinates.length];

        for (int i = 0; i < coordinates.length; i++) {
            copy[i] = coordinates[i];
        }

        return copy;
    }

    public void setCoordinates(int[] coordinates) {
        if (coordinates != null && coordinates.length >= COORDINATES_LENGTH) {
            this.coordinates = new int[COORDINATES_LENGTH];

            for (int i = 0; i < COORDINATES_LENGTH; i++) {
                this.coordinates[i] = coordinates[i];
            }
        } else {
            this.coordinates = new int[]{0, 0};
        }
    }

    public Point getPoint(){
        return new Point(this);
    }

    public void setPoint(Point point){
        if(point != null)
        {
            setCoordinates(point.coordinates);
            return;
        }

        setCoordinates(new int[]{0, 0});
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", coordinates[0], coordinates[1]);
    }
}

