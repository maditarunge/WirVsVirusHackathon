import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Haversine {

    static final int R = 6371; // Radious of the earth

    public static void main(String[] args) {

        //test methods
        Coordinates coordinates1 = new Coordinates(52.28575, 8.90811);
        Coordinates coordinates2 = new Coordinates(52.28259, 8.87549);

        Double distance = calcHaversine(coordinates1, coordinates2);
        System.out.println("The distance between two lat and long is::" + distance);

        List<Coordinates> coordinates = Arrays.asList(coordinates1, coordinates2);

        getNeighbours(coordinates1, coordinates, (double) 2);
        getNeighbours(coordinates1, coordinates, (double) 3);

    }

    public static List<Coordinates> getNeighbours(Coordinates myCoordinates, List<Coordinates> coordinates, Double maxDist)
    {
        List<Coordinates> neighbours = new ArrayList<>();
        for(Coordinates c : coordinates)
        {
            if (!myCoordinates.equals(c) && calcHaversine(myCoordinates, c) <= maxDist) neighbours.add(c);
        }
        return neighbours;
    }

    public static Double calcHaversine(Coordinates coordinates1, Coordinates coordinates2)
    {
        Double latDistance = toRad(coordinates2.getLatitude()-coordinates1.getLatitude());
        Double lonDistance = toRad(coordinates2.getLongitude()-coordinates1.getLongitude());
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(coordinates1.getLatitude())) * Math.cos(toRad(coordinates2.getLatitude())) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

}
