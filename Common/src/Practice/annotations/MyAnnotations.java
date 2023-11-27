package Practice.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Modifier;

import static java.lang.System.out;
public class MyAnnotations{
    @Override
    public String toString(){
        return "MyAnnotationClass";
    }
    public  void print(){
        out.println("MyAnnotation class print\n");
    }
    public static class Trials{
        @Deprecated
        public static void DeprMethod(){
            out.println("This method is deprecated.");
        }
        @SuppressWarnings("deprecation")
        public static void CallDepr(){
            out.print("Suppressed deprecation: ");
            DeprMethod();
        }
    }

    @Retention(RetentionPolicy.RUNTIME) //@Target(ElementType.METHOD)
    @Target(ElementType.TYPE)
    public @interface MyAnnotation{
        //boolean hasDecimal() default true;
        boolean value() default true;
        Class<?> anyClass() default Object.class;
    }

    @MyAnnotation(anyClass = String.class)
    public static class AnnotationClient{
        private float x;
        public AnnotationClient(){}
        public AnnotationClient(float X){
            x=X;
        }
        //@MyAnnotation//@MyAnnotation(false)//(hasDecimal = false)
        public void getDecimal(){
            Class<?> thisClass = this.getClass();
            boolean b=false;
/*            for(var m : thisClass.getDeclaredMethods()){
                if(m.getName()=="getDecimal") {
                    MyAnnotation myAnnot = m.getAnnotation(MyAnnotation.class);
                    b=//myAnnot.hasDecimal();
                            myAnnot.value();
                }
            }*/
            MyAnnotation myAnnot = this.getClass().getAnnotation(MyAnnotation.class);
            //if(b)
            if(myAnnot.value())
                out.printf("%( 010.2f\n",x);
            else
                out.printf("No decimal number available.\n");
        }
        public void showStaticMethods() {
            Class<?> c = this.getClass().getAnnotation(MyAnnotation.class)
                    .anyClass();
            if (c == Object.class){
                out.println("No classes to show.");
                return;
            }
            out.printf("Static methods of %s:\n",c.getSimpleName());
            for(var m : c.getDeclaredMethods()){
                int mods = m.getModifiers();
                if(Modifier.isStatic(mods))
                    out.println("\t"+m.getName());
            }

        }
    }
}