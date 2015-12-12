package com.geoclusters;


import java.util.Date;

/**
 * Created by noelwilson on 10/12/2015.
 *
 * A Geo is a square in the Geo block that holds an index, optional user owner and assigned_data
 */
public class Geo {
    int index;
    User user;
    Geo up, down, left, right;
    Date assigned_date;
    Geoblock parent_block;

    public Geo(int i, Geoblock pb) {
        index = i;
        up = null;
        down = null;
        right = null;
        down = null;
        parent_block = pb;
    }

    /**
     * Link a Geo to another Geo by direction, as each geo represents a square it can be connected to
     * 4 directions left, right, up and down
     * @param direction
     * @param g
     */
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

    /**
     * Retrieve Geo from a Geo connection by the side of the Geo we want to get from
     * @param direction String: direction to get link, "left", "right", "up", "down"
     * @return Geo / null
     */
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

    /**
     * Assign Geo to a user, this saves the user and date the user has owned the block from
     * @param u user assigned to block
     * @param date date user was originally assigned to block
     */
    public void assign_geo(User u, Date date){
        user = u;
        assigned_date = date;
    }

    /**
     * Get User from Geo
     * @return
     */
    public User get_user(){
        return user;
    }

    /**
     * Get date that user was assigned block
     * @return
     */
    public Date get_assigned_date(){
        return assigned_date;
    }

    /**
     * Recursive function will check that the current block has a user and isn't in an existing cluster
     * then it should be added to the arg Geocluster, it's conections will then be polled in the same way to
     * see if they should be added to the arg Geocluster
     * @param cluster cluster to store Geos that are connected
     * @return Geocluster cluster containing connected Geos
     */
    public Geocluster get_cluster(Geocluster cluster){
        if(user != null && parent_block.in_clusters(this) == false){
            cluster.add(this);
            if(up != null) up.get_cluster(cluster);
            if(down != null) down.get_cluster(cluster);
            if(right != null) right.get_cluster(cluster);
            if(left != null) left.get_cluster(cluster);

            return cluster;
        }
        return null;
    }

    /**
     * Output neat string data
     * @return "String index, User.name, User.assigned_date"
     */
    public String output(){
        return (Integer.toString(index) + ", " + user.name + ", " + assigned_date.toString());
    }
}
