package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

public class OptionsParser {
    private final static Set VALU = Set.of("f","forward", "b","backward", "l","left", "r","right");
    public static MoveDirection[] parse(String[] args){
        Stream<String> our_stream = Arrays.stream(args);
        return our_stream.filter(VALU::contains).map(OptionsParser::whatEn).toArray(MoveDirection[]::new);
    }
    private static MoveDirection whatEn(String cha){
        return switch (cha){
            case "f","forward" ->MoveDirection.FORWARD;
            case "b","backward"->MoveDirection.BACKWARD;
            case "l","left"->MoveDirection.LEFT;
            case "r","right"->MoveDirection.RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + cha);
        };
    }

}
