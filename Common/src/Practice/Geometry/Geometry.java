package Practice.Geometry;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public interface Geometry {
    public abstract class Vertex{
        protected short stride;
        protected float[] data;
        protected void fillData(float d){
            Arrays.fill(data,d);
        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<stride;++i){
                sb.append(String.format("%+.4f",data[i]));
                if(i<stride-1)
                    sb.append(',');
            }
            return sb.toString();
        }
    }
    public abstract class Face{
        protected short vertexCount;
        protected Vertex[] vertices;
        protected void fillData(Class<?> pointClass) throws Exception
        {
            Constructor<?> defC = pointClass.getConstructor();
            Arrays.fill(vertices, defC.newInstance());
        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<vertexCount;++i){
                sb.append(vertices[i]);
                if(i<vertexCount-1)
                    sb.append('\n');
            }
            return sb.toString();
        }
    }
}
