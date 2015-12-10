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

    void public set_link(String direction, Geo g){
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

    Geo public get_link(String direction) {
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
    }

    void public assign_geo(User u){
        user = u;
        assigned_date = new Date();
    }

    User public get_user(){
        return user;
    }

    Date public get_assigned_date(){
        return assigned_date;
    }


}
