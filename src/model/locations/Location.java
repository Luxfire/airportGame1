package model.locations;
import model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 19.09.2017.
 */
public class Location {
    public Player player;
    public Rectangle moveZone;
    public ImageIcon mapTexture;
    public int x;
    public int y;
    public int width;
    public int height;
    public void update() {}
}
