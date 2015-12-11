package com.geoclusters;

import java.util.Date;
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

        // create geo block
        Geoblock geoblock = new Geoblock(width, height);

        // assign user blocks from csv
        try {
            CsvReader reader = new CsvReader(new FileReader("yourfile.csv"));
            reader.readHeaders();

            while (reader.readRecord())
            {
                int index = Integer.parseInt(reader.get("Index"));
                User user = new User(reader.get("Name"));
                Date date = new Date(reader.get("Date"));

                geoblock.assign_block(index, user, date);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // calculate clusters and get largest
        geoblock.get_clusters();
        Geocluster cluster = geoblock.get_largest_cluster();

        // output cluster data
        System.out.print(cluster.output());

    }
}
