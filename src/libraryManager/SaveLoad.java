package libraryManager;

import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.nio.file.*;

class LocalDateSerializer implements JsonSerializer<LocalDate> {
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}

class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
    }
}

/**
 * Class:
 * Author: Mr Nam
 * LastEdited:
 * Description: Saves and loads arbitrary object states using the Gson module
 */
public class SaveLoad {
    public Gson gson;

    private Path path;

    /**
     * Constructor
     * @param filename the name of the save file
     */
    public SaveLoad(String filename) {
        this.gson = new GsonBuilder()
            .setPrettyPrinting() // human-readable format
            .serializeNulls() // include null data in save
            .registerTypeAdapter(LocalDate.class, new LocalDateSerializer()) // for saving dates
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer()) // for loading dates
            .create();
        this.path = Paths.get(filename);
    }

    /**
     * saves the specified object
     * @param data the object to save
     * @param <T> type of the object
     */
    public <T> void save(T data) {
        try {
            Files.writeString(path, gson.toJson(data));
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());

        }
    }

    /**
     * loads the file and return the parsed result
     * @param type type of the data saved (e.g. BookList.class)
     * @return the parsed data
     */
    public <T> T load(Type type) {
        try {
            return gson.fromJson(Files.readString(path), type);
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
        return null;
    }
}