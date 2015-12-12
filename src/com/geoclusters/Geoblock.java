package com.geoclusters;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by noelwilson on 10/12/2015.
 */
public class Geoblock {
    Geocluster current_cluster;
    Geocluster largest_cluster;
    ArrayList<Geocluster> geoclusters;
    ArrayList<Geo> geos;
    int width, height;

    /**
     * Inti a Geo block with dimensions init_w  = width and init_h = height
     * @param init_w int width
     * @param init_h int height
     */
    public Geoblock(int init_w, int init_h){
        width = init_w;
        height = init_h;
        geoclusters = new ArrayList<Geocluster>();
        geos = new ArrayList<Geo>();

        int total = width * height;

        // Create Geos
        for(int i=0;i<total;i++){
            geos.add(new Geo(i, this));
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

    public ArrayList<Geo> get_geos(){
        return geos;
    }

    /**
     * Assign a Geo to a user
     * @param index Geo index in Geoblock
     * @param user User to assign to Geo
     * @param date Date to set in Geo
     */
    public void assign_block(int index, User user, Date date) {
        geos.get(index).assign_geo(user, date);
    }

    /**
     * Checks is Geo is already assigned to an existing Geocluster
     * @param g Geo object to check
     * @return boolean true / false
     */
    boolean in_clusters(Geo g){
        for(int i=0;i<geoclusters.size();i++){
            if(geoclusters.get(i).has(g)){
                return true;
            }
        }
        return false;
    }

    /**
     * Iterate through Geoblock and if the current block is a valid block to be added to a
     * Geoblock then create a new Geocluster and start recursive geocluster building throught the Geos
     * @param index Geoblock index to check for a valid Geocluster
     * @return Geocluster / null
     */
    public Geocluster get_cluster(int index){
        Geo g = geos.get(index);
        // check that block isn't already in a cluster
        if( in_clusters(g) == false && g.user != null) {
            // if block is assigned add to cluster and transverse edges
            Geocluster cluster = new Geocluster();
            geoclusters.add(cluster);
            // pass cluster to block and add connected blocks if they have value and
            // not part of another cluster
            g.get_cluster(cluster);

            return cluster;
        }
        // else return
        return null;
    }

    /**
     * Get clusters and save it in the Geoblock object
     */
    public void get_clusters(){
        int total = width * height;
        for(int i=0;i<total;i++){
            get_cluster(i);
        }
    }

    /**
     * Get the largest cluster after finding all clusters for this geoblock
     * @return GeoCluster largest geocluster
     */
    public Geocluster get_largest_cluster(){
        Geocluster largest_gc = null;
        for(int i=0;i<geoclusters.size();i++)
        {
            if(largest_gc == null) largest_gc = geoclusters.get(i);
            else if(largest_gc.get_geocluster().size() < geoclusters.get(i).get_geocluster().size()){
                largest_gc = geoclusters.get(i);
            }
        }
        largest_cluster = largest_gc;
        return largest_gc;
    }
}
