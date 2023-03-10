package view.commands;

import java.awt.Graphics2D;

import controller.Point;
import view.draw.CreateShape;
import view.draw.Calculations;

public class Collision {
    private static Graphics2D graphics2D;

    public static boolean isCollision(CreateShape shape, Point startPoint, Point endPointd) {
    	
    	Point newStartPair = shape.getStartPoint();

    	Point newEndPair = shape.getEndPoint();

    	int Width = newEndPair.getX() - newStartPair.getX();

    	int Height = newEndPair.getY() - newStartPair.getY();

    	int x = startPoint.getX();

    	int X = endPointd.getX();

    	int y = startPoint.getY();

    	int Y = endPointd.getY();

    	int width = X - x;

    	int height = Y - y;

    	boolean collisionDetect = x <= newStartPair.getX() + Width && x + width >= newStartPair.getX()

    	&& y <= newStartPair.getY() + Height && height + y >= newStartPair.getY();

    	return collisionDetect;
    }

    	
    	
//        graphics2D = createShape.getGraphics2d();
//        Calculations calculations = new Calculations(startPoint,endPointd);
//        graphics2D.setClip(calculations.getX(),calculations.getY(),calculations.getx1(),calculations.gety1());
//        calculations.setPoint(createShape.getStartPoint(),createShape.getEndPoint());
//        return graphics2D.hitClip(calculations.getX(),calculations.getY(),calculations.getx1(),calculations.gety1());
//    }

}
