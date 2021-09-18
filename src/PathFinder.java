import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PathFinder {

    public static String findPath(int xStart, int yStart, int[][] matrix) {
        PathPoint endPoint = findEndPoint(xStart, yStart, Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new));
        return buildPath(endPoint);
    }

    private static String buildPath(PathPoint endPoint) {
        if(endPoint == null) {
            return "There is no path in this labyrinth";
        }
        StringBuilder result = new StringBuilder();
        PathPoint parent = endPoint;
        while(parent != null) {
            result.append("\n" + parent.getY() + "," + parent.getX());
            parent = parent.getParent();
        }
        return result.reverse().toString();
    }

    private static PathPoint findEndPoint(int xStart, int yStart, int[][] matrix) {
        Deque<PathPoint> queue = new LinkedList<>();
        PathPoint endPoint = null;

        queue.add(new PathPoint(xStart, yStart, null));
        while(!queue.isEmpty()) {
            PathPoint point = queue.poll();
            if(point.getX() == matrix.length - 1 || point.getY() == matrix[0].length - 1) {
                endPoint = point;
                queue.clear();
            } else {
                //left
                if (point.getX() > 0 && matrix[point.getX() - 1][point.getY()] == 0) {
                    queue.add(new PathPoint(point.getX() - 1, point.getY(), point));
                    matrix[point.getX() - 1][point.getY()] = -1;
                }
                //right
                if (matrix[point.getX() + 1][point.getY()] == 0) {
                    queue.add(new PathPoint(point.getX() + 1, point.getY(), point));
                    matrix[point.getX() + 1][point.getY()] = -1;
                }
                //bottom
                if (matrix[point.getX()][point.getY() + 1] == 0) {
                    queue.add(new PathPoint(point.getX(), point.getY() + 1, point));
                    matrix[point.getX()][point.getY() + 1] = -1;
                }
                //top
                if (point.getY() > 0 && matrix[point.getX()][point.getY() - 1] == 0) {
                    queue.add(new PathPoint(point.getX(), point.getY() - 1, point));
                    matrix[point.getX()][point.getY() - 1] = -1;
                }
            }
        }

        return endPoint;
    }
}
