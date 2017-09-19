package view.locations;

import model.Kid;
import model.Mom;
import model.Player;

import java.awt.*;

/**
 * Created by user on 19.09.2017.
 */
public class Location {
    public Player player;
    public Rectangle moveZone;
    public Rectangle doorUpOne;
    public Rectangle doorUpTwo;
    public Rectangle doorDownOne;
    public Rectangle doorDownTwo;
    public Rectangle doorLeft;
    public Rectangle doorRight;
    public Mom mom;
    public Kid kid;

    public Location(){}
    public void paint(Graphics g)
    {}
}
