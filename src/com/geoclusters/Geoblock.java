package com.geoclusters;

import java.util.ArrayList;

/**
 * Created by noelwilson on 10/12/2015.
 */
public class Geoblock {
    Geocluster current_cluster;
    ArrayList<Geocluster> geoclusters = new ArrayList<Geocluster>();
    ArrayList<Geo> geos = new ArrayList<Geo>();
    int width, height;

    Geoblock(int w, int h){
        width = w;
        height = h;

        int total = width * height;

        // Create Geos
        for(int i=0;i<total;i++){
            geos.add(new Geo(i))
        }

        // Link Geos
        for(var w=0;w<width;w++){
            for(var h=0;h<height;h++){
                
            }
        }
    }
}
