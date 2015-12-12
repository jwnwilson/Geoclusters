package com.geoclusters;

import java.util.Date;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;
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

        // Create geo block
        Geoblock geoblock = new Geoblock(width, height);


        // Load csv data into geo block
        boolean loaded = geoblock.load_csv(csv_path);

        if(loaded == false){
            return;
        }

        // Get largest
        Geocluster cluster = geoblock.get_largest_cluster();

        // Output cluster data
        System.out.print("\n");
        System.out.print("Largest cluster:\n");
        System.out.print(cluster.output());

    }
}
