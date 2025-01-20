import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonGenerator {
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            ArrayList<String> a = new ArrayList<>();

            while (true) {

                String ID = SafeInput.getNonZeroLenString(in, "What is the ID?");
                String FirstName = SafeInput.getNonZeroLenString(in, "What is the First Name?");
                String LastName = SafeInput.getNonZeroLenString(in, "What is the Last Name?");
                String Title = SafeInput.getNonZeroLenString(in, "What is your Title?");
                int YearOfBirth = SafeInput.getInt(in, "What is your Year of Birth?");


                String record = ID + "," + FirstName + "," + LastName + "," + Title + "," + YearOfBirth;
                a.add(record);


                String continueInput = SafeInput.getNonZeroLenString(in, "Do you want to add another person?");
                if (continueInput.equalsIgnoreCase("no")) {
                    break;
                }
            }

            String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name: ");
            PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".txt"));

            for (String record : a) {
                writer.println(record);
            }
            writer.close();

            System.out.println("text saved to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}





