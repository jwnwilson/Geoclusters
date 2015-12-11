package com.geoclusters;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by noelwilson on 10/12/2015.
 */
public class Geoblock {
    Geocluster current_cluster;
    ArrayList<Geocluster> geoclusters;
    ArrayList<Geo> geos;
    int width, height;

    Geoblock(int init_w, int init_h){
        width = init_w;
        height = init_h;
        geoclusters = new ArrayList<Geocluster>();
        geos = new ArrayList<Geo>();

        int total = width * height;

        // Create Geos
        for(int i=0;i<total;i++){
            geos.add(new Geo(i));
        }

        // Link Geos
        for(int h=0;h<height;h++){
            for(int w=0;w<width;w++){
                int index = (width * h) + w;
                // assign left
                if(w > 0){
                    geos.get(index).set_link("left", geos.get(index-1) );
                }
                // assign right
                if(w < (width -1)){
                    geos.get(index).set_link("right", geos.get(index+1) );
                }
                // assign bottom
                if(h > 0){
                    geos.get(index).set_link("down", geos.get(index - width) );
                }
                // assign top
                if(h < (height - 1)){
                    geos.get(index).set_link("up", geos.get(index + width) );
                }
            }
        }

        System.out.print("Test");
    }

    void assign_block(int index, User user, Date date) {
        geos.get(index).assign_geo(user, date);
    }

    public Geocluster get_cluster(int index, Geocluster cluster){
        // check that block isn't already in a cluster

        // if block is assigned add to cluster and transverse edges

        // else return

        return null;
    }

    /**
     * Get clusters and save it in the Geoblock object
     */
    public void get_clusters(){

    }

    /**
     * Get the largest cluster after finding all clusters for this geoblock
     * @return
     */
    public Geocluster get_largest_cluster(){

        return null;
    }
}
