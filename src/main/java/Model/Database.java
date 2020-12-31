package Model;

import Model.Data.Data;
import Model.Tools.Packable;
import com.gilecode.yagson.YaGson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import Exception.*;

public class Database {

    private static YaGson yaGson = new YaGson();


    public static List<Packable<?>> loadList(Class<?> clazz) {

        String classSimpleName = clazz.getSimpleName();

        List<Packable<?>> list = new ArrayList<>();

        try (Stream<Path> pathStream = Files.walk(Paths.get(getStringPath(classSimpleName))).filter(Files::isRegularFile)) {

            pathStream.map(path -> {
                try {
                    return Files.readAllLines(path).get(0);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }).filter(Objects::nonNull).map(s -> yaGson.fromJson(s, Data.class))
                    .forEach(data -> {
                        try {
                            list.add(data.getInstance());
                        } catch (AccountDoesNotExistException | LogHistoryDoesNotExistException |FieldDoesNotExist e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void save(Packable<?> object, boolean New) {

        if (New) {

            try {
                Files.createFile(Paths.get(getStringObjPath(object)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        save(object);
    }

    public static void save(Packable<?>  object) {

        File file = new File(getStringObjPath(object));

        String packed = yaGson.toJson(object.pack()) ;


        FileWriter writer;
        try {
            writer = new FileWriter(file);

            writer.write(packed);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void remove(Packable<?>  object) {

        try {
            Files.delete(Paths.get(getStringObjPath(object)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getStringPath( String className) {
        return String.format("src/main/resources/DataBase/%s-src", (className.matches("^(Player|Admin)$")) ? "Account" : className);
    }

    private static String getStringObjPath( Packable<?> packable) {
        String className = packable.getClass().getSimpleName();
        return String.format("src/main/resources/DataBase/%s-src/%d.json"
                , (className.matches("^(Player|Admin)$")) ? "Account" : className
                , packable.getId()
        );
    }


}
