/**
 * Created by Spape on 25/10/2017.
 */
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}