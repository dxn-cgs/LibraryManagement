package libraryManager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.nio.file.*;
import java.util.List;

/**
 * Converter for LocalDate objects
 */
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
 * Converters for Member and Book objects
 */
class BookCreator implements InstanceCreator<Book> {
    public Book createInstance(Type type) {
        return new Book(0, "", "");
    }
}
class MemberCreator implements InstanceCreator<Member> {
    public Member createInstance(Type type) {
        return new Member(0, "");
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

    private final Path path;

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
            .registerTypeAdapter(Book.class, new BookCreator())
            .registerTypeAdapter(Member.class, new MemberCreator())
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
     *
     * @param type type of the data saved (e.g. Integer, Member.getClass())
     *             for collections/lists, you have to put a typeToken (see below)
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

    /**
     * loads the file and return the parsed result that is a collection (list, map, ...)
     * reference: https://google.github.io/gson/UserGuide.html#collections-examples
     * @param type a TypeToken object (use the link above for guide)
     * @return the parsed data
     */
    public <T> T load(TypeToken<T> type) {
        try {
            return gson.fromJson(Files.readString(path), type);
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
        return null;
    }
}