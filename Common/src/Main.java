import Practice.jdbc.MyPooler;
import Practice.Geometry.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args){
        try(MyPooler myPooler = new MyPooler((short)10,(short)4)) {
        } catch (Exception e){
            out.println(e);
        }finally{
            Vertices.ColoredVertex v = new Vertices.ColoredVertex(3,6,9,1,0.3333f,0.5f,1.0f);
            out.println(v);
        }
    }
}
