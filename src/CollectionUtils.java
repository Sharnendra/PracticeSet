import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static Map<Integer, Map<Integer, OriginData>> getOriginDataMap() {
        Map<Integer, Map<Integer, OriginData>> originDataMap = new HashMap<>();
        originDataMap.put(1, getObjectMap().entrySet().stream()
                .filter(x -> x.getKey() % 2 != 0 && x.getKey() < 5)
                .collect(Collectors.toMap(x-> x.getKey(), y -> y.getValue())));
        originDataMap.put(2, getObjectMap().entrySet().stream()
                .filter(x -> x.getKey() % 2 == 0 && x.getKey() < 5)
                .collect(Collectors.toMap(x-> x.getKey(), y -> y.getValue())));
        originDataMap.put(3, getObjectMap().entrySet().stream()
                .filter(x -> x.getKey() == 5)
                .collect(Collectors.toMap(x-> x.getKey(), y -> y.getValue())));
        originDataMap.put(4, getObjectMap().entrySet().stream()
                .filter(x -> x.getKey() % 2 == 0 && x.getKey() > 5)
                .collect(Collectors.toMap(x-> x.getKey(), y -> y.getValue())));
        originDataMap.put(5, getObjectMap().entrySet().stream()
                .filter(x -> x.getKey() % 2 != 0 && x.getKey() > 5 && x.getKey() < 11)
                .collect(Collectors.toMap(x-> x.getKey(), y -> y.getValue())));
    originDataMap.put(6, getObjectMap().entrySet().stream()
                .filter(x -> x.getKey() == 11)
                .collect(Collectors.toMap(x-> x.getKey(), y -> y.getValue())));
        return originDataMap;
    }

    private static Map<Integer, OriginData> getObjectMap() {
        Map<Integer, OriginData> objectMap = new HashMap<>();
        objectMap.put(1,getOriginData("Rahul"));
        objectMap.put(2,getOriginData("Rajiv"));
        objectMap.put(3,getOriginData("Sharnendra"));
        objectMap.put(4,getOriginData("Mahint"));
        objectMap.put(5,getOriginData("Kailash"));
        objectMap.put(6,getOriginData("Sailesh"));
        objectMap.put(7,getOriginData("David"));
        objectMap.put(8,getOriginData("Korta"));
        objectMap.put(9,getOriginData("Simran"));
        objectMap.put(10,getOriginData("Tarun"));
        objectMap.put(11,getOriginData("Varun"));
        return objectMap;
    }
    private static OriginData getOriginData(String name) {
        return new OriginData(name);
    }
}

class OriginData {
    private String name;

    OriginData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginData that = (OriginData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
