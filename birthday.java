import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        String fileName = args[0];

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String nameStr = line.replaceAll("[\\w]", "").trim();
                String[] digitalParts = line.substring(nameStr.length()).trim().split(" ");
                int day = Integer.parseInt(digitalParts[0]);
                int month = Integer.parseInt(digitalParts[1]);
                int year = Integer.parseInt(digitalParts[2]);
                Date date = (Date) new GregorianCalendar(year, month-1, day).getTime();

                PEOPLE.add(new Person(nameStr, date));
            }
        }
        for (Person p :PEOPLE)
        System.out.println(p.getName()+" "+p.getBirthday());
    }
}