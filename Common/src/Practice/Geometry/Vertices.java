package Practice.Geometry;
import Practice.Geometry.Geometry.*;
public class Vertices {
    public static class Position extends Vertex{

        public Position(){
            stride=3;
            data=new float[stride];
            fillData(-1);
        }
        public Position(float x, float y, float z){
            stride=3;
            data = new float[stride];
            data[0]=x;
            data[1]=y;
            data[2]=z;
        }
    }
    public static class ColoredVertex extends Vertex{
        {
            stride=7;
            data = new float[7];
        }
        public ColoredVertex(){
            fillData(0);
            data[stride-1] = 1;
        }
        public ColoredVertex(float x, float y, float z,
                             float r, float g, float b, float a){
            data[0]=x; data[1]=y; data[2]=z;
            data[3]=r; data[4]=g; data[5]=b; data[6]=a;
        }
    }
}
