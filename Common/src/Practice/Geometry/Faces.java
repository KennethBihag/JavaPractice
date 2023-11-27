package Practice.Geometry;

import Practice.Geometry.Geometry.*;
import Practice.Geometry.Vertices.*;

public class Faces {
    public static class Triangle extends Face
    {
        {
            vertexCount=3;
            vertices = new Vertex[3];
        }
        public Triangle() throws Exception{
            fillData(Position.class);
        }
    }
    public static class Quad extends Face{
        {
            vertexCount = 4;
            vertices = new Vertex[vertexCount];
        }
        public Quad() throws Exception{
            fillData(ColoredVertex.class);
        }
    }
    public static class Polygon{
    }
}
