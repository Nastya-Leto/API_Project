
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@JsonPropertyOrder({"name", "age"})
public class Person {

    public String name;
    public int age;

        void Person (String name, int age) {

        this.name = name;
        this.age = age;

    }

    public static class App {
        public void main(String[] args) throws IOException {
            List<Person> people = new ArrayList<>();
            //people.add(new Person("Ivan", 20));
            //people.add(new Person("Anna", 21));

            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(Person.class)
                    .withColumnSeparator(';')
                    .withoutQuoteChar()
                    .withHeader();
            ObjectWriter writer = mapper.writer(schema);
            writer.writeValue(new FileWriter("test.csv", StandardCharsets.UTF_8), people);
        }
    }
}
