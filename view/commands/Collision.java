package view.commands;

import java.awt.Graphics2D;

import controller.Point;
import view.draw.CreateShape;
import view.draw.Calculations;

public class Collision {
    private static Graphics2D graphics2D;

    public static boolean isCollision(CreateShape createShape, Point startPoint, Point endPointd) {
        graphics2D = createShape.getGraphics2d();
        Calculations calculations = new Calculations(startPoint,endPointd);
        graphics2D.setClip(calculations.getX(),calculations.getY(),calculations.getx1(),calculations.gety1());
        calculations.setPoint(createShape.getStartPoint(),createShape.getEndPoint());
        return graphics2D.hitClip(calculations.getX(),calculations.getY(),calculations.getx1(),calculations.gety1());
    }

}
