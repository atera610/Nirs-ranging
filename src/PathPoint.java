public class PathPoint {
    private int x;
    private int y;
    private PathPoint parent;

    public PathPoint(int x, int y, PathPoint parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PathPoint getParent() {
        return parent;
    }
}
