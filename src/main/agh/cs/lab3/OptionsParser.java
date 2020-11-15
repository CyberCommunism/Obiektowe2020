package agh.cs.lab3;
import agh.cs.lab2.MoveDirection;
public class OptionsParser {
    public static MoveDirection[] parse(String[] args) throws Exception{
        MoveDirection[] result = new MoveDirection[args.length];
        MoveDirection curr = null;
        int index = 0;
        for(String x:args){
            try{
                curr = whatEn(x);
            } catch (Exception e) {
                throw e;
            }
            result[index] = curr;
            index++;
        }
        return result;
    }
    private static MoveDirection whatEn(String cha) throws Exception{
        return switch (cha){
            case "f","forward" ->MoveDirection.FORWARD;
            case "b","backward"->MoveDirection.BACKWARD;
            case "l","left"->MoveDirection.LEFT;
            case "r","right"->MoveDirection.RIGHT;
            default -> throw new IllegalArgumentException(cha  + " is not legal move specification");
        };
    }

}
