package com.geoclusters;


import java.util.Date;

/**
 * Created by noelwilson on 10/12/2015.
 */
public class Geo {
    int index;
    User user;
    Geo up, down, left, right;
    Date assigned_date;

    public Geo(int i) {
        index = i;
        up = null;
        down = null;
        right = null;
        down = null;
    }

    public void set_link(String direction, Geo g){
        if(direction == "up"){
            up = g;
        }
        if(direction == "down"){
            down = g;
        }
        if(direction == "right"){
            right = g;
        }
        if(direction == "left"){
            left = g;
        }
    }

    public Geo get_link(String direction) {
        if(direction == "up"){
            return up;
        }
        if(direction == "down"){
            return down;
        }
        if(direction == "right"){
            return right;
        }
        if(direction == "left"){
            return left;
        }

        return null;
    }

    public void assign_geo(User u, Date date){
        user = u;
        assigned_date = date;
    }

    public User get_user(){
        return user;
    }

    public Date get_assigned_date(){
        return assigned_date;
    }

    public Geocluster get_cluster(Geocluster cluster, Geoblock gb){
        if(user != null && gb.in_clusters(this) == false){
            cluster.add(this);
            if(up != null) up.get_cluster(cluster, gb);
            if(down != null) down.get_cluster(cluster, gb);
            if(right != null) right.get_cluster(cluster, gb);
            if(left != null) left.get_cluster(cluster, gb);

            return cluster;
        }
        return null;
    }

    public String output(){
        return (Integer.toString(index) + ", " + user.name + ", " + assigned_date.toString());
    }


}
