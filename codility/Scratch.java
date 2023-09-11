import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Scratch {
    public boolean getTrue(){
        return true;
    }
    public static int minRoomsNeeded(int[] maxGuestsPerRoom){
        int[] sorted = Arrays.stream(maxGuestsPerRoom).sorted().toArray();
        int result = 0;
        int maxForCurrentRoom=0;
        for(int i=0;i<sorted.length;++i){
            result++;
            maxForCurrentRoom=sorted[i];
            if(maxForCurrentRoom==1)
                continue;
            else{
                i+=(maxForCurrentRoom-1);
            }
        }
        return result;
    }

    public static int arrangeBasketballs(int[] ballPositions){
        int orgFirstPos = Arrays.stream(ballPositions).min().getAsInt();
        int orgLastPos = Arrays.stream(ballPositions).max().getAsInt();
        int len = orgLastPos-orgFirstPos+1;
        ArrayList<Boolean> boxes = new ArrayList<>();
        for(int i=0; i<len; ++i)
            boxes.add(false);
        for(int i : ballPositions)
            boxes.set(i-orgFirstPos,true);
        int finalLen = ballPositions.length;
        int result = finalLen;
        for(int i=0; i<boxes.size()-finalLen; ++i){
            var subList = boxes.subList(i,i+finalLen);
            int tmpMinEmpty=0;
            for(boolean b : subList){
                if(!b)
                    tmpMinEmpty++;
            }
            if(tmpMinEmpty < result)
                result = tmpMinEmpty;
        }
        return result;
    }

    public static int countLowerBeforeUpper(String input){
        int result=0;
        char first = 'a', last = 'z';
        for(char i=first; i<=last;++i){
            int currChar = input.lastIndexOf(i);
            int upperChar = input.indexOf(Character.toUpperCase(i));
            if(currChar>=0 && currChar>=0 && currChar<upperChar)
                result++;
        }
        return result;
    }
}
