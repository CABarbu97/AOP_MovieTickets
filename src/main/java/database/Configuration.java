package database;

import io.jsondb.JsonDBTemplate;
import model.Movie;
import model.Order;
import model.Ticket;

public class Configuration {
    private static String dbFilesLocation = "src/main/resources/database/";
    private static String baseScanPackage = "model";
    private static JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);

    public Configuration() {
    }

    public static JsonDBTemplate getJsonDBTemplate() {
        return jsonDBTemplate;
    }

    public static void setJsonDBTemplate(JsonDBTemplate jsonDBTemplate) {
        Configuration.jsonDBTemplate = jsonDBTemplate;
    }

    public static void createDBs()
    {
        if(!jsonDBTemplate.collectionExists(Movie.class))
            jsonDBTemplate.createCollection(Movie.class);
        if(!jsonDBTemplate.collectionExists(Order.class))
            jsonDBTemplate.createCollection(Order.class);
        if(!jsonDBTemplate.collectionExists(Ticket.class))
            jsonDBTemplate.createCollection(Ticket.class);
    }
}
