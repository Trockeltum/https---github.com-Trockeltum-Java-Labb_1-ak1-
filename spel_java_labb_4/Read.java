import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Read {

    public static List reader(String fileName) throws IOException {
        try {
            List list = reader("latestrun.txt");
                
            //list.forEach(System.out::println);
        } catch (IOException e) {
        }
        return Files.readAllLines(new File(fileName).toPath(), Charset.defaultCharset());
    }
}
