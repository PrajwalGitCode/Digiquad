import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Input and output file paths
            String xmlFilePath = "E:\\test\\sample1.xml";
            String jsonFilePath = "output.json";

            // Read XML file content
            String xmlContent = new String(Files.readAllBytes(Paths.get(xmlFilePath)));

            // Convert XML to JSON
            JSONObject json = XML.toJSONObject(xmlContent);

            // Write JSON to file
            Files.write(Paths.get(jsonFilePath), json.toString(4).getBytes());

            System.out.println("Conversion successful! JSON saved at: " + jsonFilePath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
