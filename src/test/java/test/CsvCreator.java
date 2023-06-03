package test;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"name", "age"})
public class CsvCreator {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        // POJO (bean class)
        @JsonPropertyOrder({"name", "age"})
        class User {
            public String name;
            public int age;
            public User() {
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public int getAge() {
                return age;
            }
            public void setAge(int age) {
                this.age = age;
            }
        }

        // define objects
        User user1 = new User();
        user1.name = "foo";
        user1.age = 32;
        User user2 = new User();
        user2.name = "bar";
        user2.age = 27;
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        // create mapper and schema
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(User.class);
        schema = schema.withColumnSeparator('\t');

        // output writer
        ObjectWriter myObjectWriter = mapper.writer(schema);
        File tempFile = new File("users.csv");
        FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
        OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
        myObjectWriter.writeValue(writerOutputStream, users);
    }
}
