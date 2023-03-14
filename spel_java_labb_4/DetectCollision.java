import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.*;
import java.io.*;

public class DetectCollision {
    public DetectCollision(Boll obj_1, Spelare obj_2, Boxes obj_3){
        int sant = 0;
        int temp = 0;
        for(int i=0;i<obj_3.len_squares();i++){
            if 
            (
            //obj_3.get_square(i).dead == 1 &&
            obj_3.get_square(i).hp > 1 && 
            obj_1.getX() <= obj_3.get_square(i).getX() + obj_3.get_square(i).getWidth() && 
            obj_1.getX() + obj_1.getWidth() >= obj_3.get_square(i).getX() &&
            obj_1.getY() <= obj_3.get_square(i).getY() + obj_3.get_square(i).getHeight() && 
            obj_1.getY() + obj_1.getHeight() >= obj_3.get_square(i).getY()
            )
            {
                obj_3.get_square(i).hp -= 1;
                //obj_3.alive();
                //obj_3.get_square(i).dead = 0; 
                sant  = 1;
                obj_2.score++;
                temp = i;
                break;
            }
        }
        if 
        (
        obj_1.getX() < obj_2.getX() + obj_2.getWidth() && 
        obj_1.getX() + obj_1.getWidth() > obj_2.getX() && 
        obj_1.getY() < obj_2.getY() + obj_2.getHeight() && 
        obj_1.getY() + obj_1.getHeight() > obj_2.getY()
        )
        {
            //sant = 1;
            obj_1.speed_Y *= -1;
        }
        
        if 
        (
            obj_1.getX() <= 2 || obj_1.getX() >= 780
        )
        {
            obj_1.speed_X *= -1;
        }
        if 
        (
            obj_1.getY() < 0 && obj_1.speed_Y <0
        )
        {
            obj_1.speed_Y *= -1;
        }

        if (sant == 1){
            int target_left_side_x = obj_3.get_square(temp).getX();
            int target_right_side_x = obj_3.get_square(temp).getX() + obj_3.get_square(temp).getWidth();
            int target_bottom_side_y = obj_3.get_square(temp).getY() + obj_3.get_square(temp).getHeight();
            int target_top_side_y = obj_3.get_square(temp).getY();
            
            int self_left_side_x = obj_1.getX();
            int self_right_side_x = obj_1.getX() + obj_1.getWidth();
            int self_top_side_y = obj_1.getY();
            int self_bottom_side_y = obj_1.getY() + obj_1.getHeight();

            boolean self_is_right_of_target = self_left_side_x >= target_right_side_x;
            boolean self_is_left_of_target = self_right_side_x <= target_left_side_x;
            boolean self_is_below_of_target = self_top_side_y >= target_bottom_side_y;
            boolean self_is_above_of_target = self_bottom_side_y <= target_top_side_y;
            
            if (self_is_right_of_target && !self_is_above_of_target && !self_is_below_of_target && !self_is_left_of_target){obj_1.speed_X = Math.abs(obj_1.speed_X);}
		    else if (self_is_left_of_target && !self_is_above_of_target && !self_is_below_of_target && !self_is_right_of_target){obj_1.speed_X = -Math.abs(obj_1.speed_X);}
		    else if (self_is_below_of_target && !self_is_above_of_target && !self_is_left_of_target && !self_is_right_of_target){obj_1.speed_Y = Math.abs(obj_1.speed_Y);}
		    //else {obj_1.speed_Y = -Math.abs(obj_1.speed_Y);}
            else {obj_1.speed_Y *= -1;}


            /*
            if 
            (
            obj_1.getX() > obj_3.get_square(temp).getX() + obj_3.get_square(temp).getWidth() && 
            !(obj_1.getY() + obj_1.getHeight() < obj_3.get_square(temp).getY()) && 
            !(obj_1.getY() > obj_3.get_square(temp).getY() + obj_3.get_square(temp).getHeight()) && 
            !(obj_1.getX() + obj_1.getWidth() < obj_3.get_square(temp).getX())
            )
            {
                // Right
                //obj_1.speed_Y *= -1; 
                obj_1.speed_X = Math.abs(obj_1.speed_X);
            }

            else if
                (
                obj_1.getX() + obj_1.getWidth() < obj_3.get_square(temp).getX() && 
                !(obj_1.getY() + obj_1.getHeight() < obj_3.get_square(temp).getY()) && 
                !(obj_1.getY() > obj_3.get_square(temp).getY() + obj_3.get_square(temp).getHeight()) && 
                !(obj_1.getX() > obj_3.get_square(temp).getX() + obj_3.get_square(temp).getWidth())
                )
                {
                    // Left
                    //obj_1.speed_X *= -1;
                    obj_1.speed_X = -Math.abs(obj_1.speed_X);
                }

            else if 
                (
                (obj_1.getY() > obj_3.get_square(temp).getY() + obj_3.get_square(temp).getHeight()) && 
                !(obj_1.getY() + obj_1.getHeight() < obj_3.get_square(temp).getY()) && 
                !(obj_1.getX() + obj_1.getWidth() < obj_3.get_square(temp).getX()) && 
                !(obj_1.getX() > obj_3.get_square(temp).getX() + obj_3.get_square(temp).getWidth())
                )
                {
                    // UP
                    //obj_1.speed_Y *= -1;
                    obj_1.speed_Y = -Math.abs(obj_1.speed_Y);
                }

            else if 
            (
                (obj_1.getY() + obj_1.getHeight() < obj_3.get_square(temp).getY()) &&
                !(obj_1.getY() > obj_3.get_square(temp).getY() + obj_3.get_square(temp).getHeight()) &&
                !(obj_1.getX() + obj_1.getWidth() < obj_3.get_square(temp).getX()) &&
                !(obj_1.getX() > obj_3.get_square(temp).getX() + obj_3.get_square(temp).getWidth())
            )
                {
                    // Down
                    //obj_1.speed_Y *= -1; 
                    obj_1.speed_Y = Math.abs(obj_1.speed_Y);
                }
            else {
                obj_1.speed_Y *= -1;
            }
        */
    }
    }

}

