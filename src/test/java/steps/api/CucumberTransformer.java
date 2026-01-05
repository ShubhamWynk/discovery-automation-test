package steps.api; // Use your actual step def package

import com.google.gson.Gson;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import java.lang.reflect.Type;

public class CucumberTransformer {

    private final Gson gson = new Gson();

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transform(Object fromValue, Type toValueType) {
        // This converts the Gherkin Map/String into your MultiSourceRequest object
        return gson.fromJson(gson.toJson(fromValue), toValueType);
    }
}