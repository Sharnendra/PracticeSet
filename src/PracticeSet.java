import java.util.*;
import java.util.stream.Collectors;

public class PracticeSet {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, OriginData>> data = CollectionUtils.getOriginDataMap();
        Map<Integer, OriginData> secondData = Optional.ofNullable(data)
                .map(x -> x.entrySet().stream()
                        .map(y -> y.getValue())
                        .flatMap(z -> z.entrySet().stream())
                        .collect(Collectors.toMap(k -> k.getKey(), n -> n.getValue())))
                .orElse(null);

        OriginData d1 = secondData.get(1);
        String name = d1.getName();
        Boolean t1 = Optional.ofNullable(d1)
                .map(x -> x.getName())
                .filter(y -> y.equals("Rahul"))
                .map(z -> true)
                .orElse(false);

        Boolean t2 = Optional.ofNullable(name)
                .filter(y -> y.equals("Rahul"))
                .map(z -> true)
                .orElse(false);
        System.out.println(t2);
    }
}
