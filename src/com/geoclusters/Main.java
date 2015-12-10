package com.geoclusters;

public class Main {

    public static void main(String[] args) {
        String csv_path;
        int width, height;

        if (args.length = 3){
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

        CSVReader csv_Reader = new CSVReader(new FileReader("yourfile.csv"));
        List myEntries = reader.readAll();

        Geoblock geoblock = new Geoblock(width, height);

    }
}
