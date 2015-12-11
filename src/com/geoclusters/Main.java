package com.geoclusters;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.csvreader.CsvReader;

public class Main {

    public static void main(String[] args) {
        String csv_path;
        int width, height;

        if (args.length == 3){
            try {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
                csv_path = args[2];
            }catch(NumberFormatException e){
                System.out.println("width and height must be integers");
                return;
            }
        }
        else{
            System.out.println("Geoblock width, height and csv file path required.");
            return;
        }

        try {
            CsvReader reader = new CsvReader(new FileReader("yourfile.csv"));
            reader.readHeaders();

            while (reader.readRecord())
            {
                String index = reader.get("Index");
                String name = reader.get("Name");
                String date = reader.get("Date");

            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Geoblock geoblock = new Geoblock(width, height);

    }
}
