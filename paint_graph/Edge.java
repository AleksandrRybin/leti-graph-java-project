package paint_graph;

import java.awt.*;
import java.awt.geom.Point2D;


class Edge {
    private final Node source;
    private final Node destination;

    private final int arrowSize;
    private Color colorEdge;

    public Edge(Node s, Node d){
        source = s;
        destination = d;
        colorEdge = new Color(0,0,0);
        arrowSize = 20;
    }
    public Edge(Edge other) {
        this.source = other.source;
        this.destination = other.destination;
        this.colorEdge = other.colorEdge;
        this.arrowSize = other.arrowSize;
    }

    public double getAngle() {
        Point2D p = new Point2D.Double(destination.getX() - source.getX(),
                destination.getY() - source.getY());

        double len = Math.sqrt(((Point2D.Double) p).x* ((Point2D.Double) p).x +
                ((Point2D.Double) p).y*((Point2D.Double) p).y);

        double ar_ang = Math.acos( (((Point2D.Double) p).x) / len);
        if(destination.getY() - source.getY() >= 0)
            ar_ang = Math.PI * 2 - ar_ang;
        return ar_ang;
    }

    public Point2D.Double getOffsetDestination()
    {
        Point2D p = new Point2D.Double(destination.getX() - source.getX(),
                destination.getY() - source.getY());

        double len = Math.sqrt(((Point2D.Double) p).x* ((Point2D.Double) p).x +
                ((Point2D.Double) p).y*((Point2D.Double) p).y);

        return new Point2D.Double(destination.getX() - ((Point2D.Double) p).x * destination.getRadius() / 2 / len,
                destination.getY() -((Point2D.Double) p).y * destination.getRadius() / 2 / len);
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public Color getColorEdge() {
        return colorEdge;
    }

    public void setColorEdge(Color colorEdge) {
        this.colorEdge = colorEdge;
    }

    public int getArrowSize() {
        return arrowSize;
    }



}

