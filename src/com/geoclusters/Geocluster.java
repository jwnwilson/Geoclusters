package com.geoclusters;

import java.util.ArrayList;

/**
 * Created by noelwilson on 10/12/2015.
 */
public class Geocluster {
    ArrayList<Geo> geocluster;

    public Geocluster(){
        geocluster = new ArrayList<Geo>();
    }

    public void remove(Geo g){
        geocluster.remove(g);
    }

    public void add(Geo g){
        geocluster.add(g);
    }

    public String output(){
        String output_str = "";
        for(int i=0;i<geocluster.size();i++){
            output_str = geocluster.get(i).output();
        }

        return output_str;
    }
}
