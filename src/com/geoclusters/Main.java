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

        // create geo block
        Geoblock geoblock = new Geoblock(width, height);

        // assign user blocks from csv
        try {
            CsvReader reader = new CsvReader(new FileReader(csv_path));
            reader.readHeaders();

            while (reader.readRecord())
            {
                int index = Integer.parseInt(reader.get("Index"));
                User user = new User(reader.get("Name"));
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date;
                try {
                    date = format.parse(reader.get("Date"));
                }
                catch(ParseException e){
                    System.out.print("Unable to parse date: " + reader.get("Date"));
                    continue;
                }

                geoblock.assign_block(index, user, date);
                System.out.print("Block: " + Integer.toString(index) + " assigned to user: " + user.name + " with date " +
                date.toString() + "\n");
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
        System.out.print("\n");
        System.out.print("Largest cluster:\n");
        System.out.print(cluster.output());

    }
}
