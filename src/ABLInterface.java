import java.util.function.Function;

public interface ABLInterface <T, R>{
    R getFeature (T t);

    default Function<T, R> getAdd(T t){
        return null;
    }
};
