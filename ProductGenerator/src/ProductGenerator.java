import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();


        try {
            while (true) {


                String ID = SafeInput.getNonZeroLenString(in, "What is the ID?");
                String Name = SafeInput.getNonZeroLenString(in, "What is the Name?");
                String Description = SafeInput.getNonZeroLenString(in, "What is the description?");
                double Costdub = SafeInput.getDouble(in, "What is the cost?");
                String Cost = Double.toString(Costdub);

                String record = ID + "," + Name + "," + Description + "," + Cost;
                records.add(record);

                boolean Continue = SafeInput.getYNConfirm(in, "Would you like to add another item?");

                if (!Continue) {
                    break;
                }
            }

            String FileName = SafeInput.getNonZeroLenString(in, "What would you like to name your file?");
            PrintWriter pw = new PrintWriter(new FileWriter(FileName + ".txt"));

            for (String record : records) {
                pw.println(record);
            }
            pw.close();
            System.out.println("Data Saved to " + FileName);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}

