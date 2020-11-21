package agh.cs.lab7;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IEngine;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.SimulationEngine;
import agh.cs.lab5.GrassField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapBoundaryTest {
    private void mainOne(String[] args) throws Exception{
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(2, new Vector2d[]{new Vector2d()});
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(1, 1)};
            System.out.println(map);
            IEngine enegine = new SimulationEngine(directions, map, positions);
            System.out.println(map);
            enegine.run();
            System.out.println(map);
        } catch (Exception e) {
            throw e;
        }
    }
    private void mainOne(String[] args,Vector2d[] pos) throws Exception{
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(2, new Vector2d[]{new Vector2d()});
            System.out.println(map);
            IEngine enegine = new SimulationEngine(directions, map, pos);
            System.out.println(map);
            enegine.run();
            System.out.println(map);
        } catch (Exception e) {
            throw e;
        }
    }
    private SimulationEngine mainOne(String[] args,Vector2d[] posOfGrass,Vector2d[] posOfAn) throws Exception{
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(2, posOfGrass);
            SimulationEngine enegine = new SimulationEngine(directions, map, posOfAn);
            enegine.run();
            return enegine;
        } catch (Exception e) {
            throw e;
        }
    }
    @Test
    void exceptionCheck2() throws Exception {
        String[] args = {"k"};
        boolean flag = false;
        try{
            mainOne(args);
        } catch (Exception e){
            if(e.getMessage().equals("k is not legal move specification")){
                flag = true;
            }
        }
        assertTrue(flag);
    }
    @Test
    void exceptionCheck1() throws Exception {
        String[] args = {"f"};
        boolean flag = false;
        try{
            mainOne(args);
            flag = true;
        } catch (Exception ignored){
        }
        assertTrue(flag);
    }
    @Test
    void exceptionCheck(){
        String[] args = {"f"};
        Vector2d[] tab = {new Vector2d(),new Vector2d()};
        boolean flag = false;
        try{
            mainOne(args,tab);
        } catch (Exception e){
                flag = true;

        }
        assertTrue(flag);
    }
    @Test
    void moveOfAnimals(){
        String[] args = {"f","f"};
        Vector2d[] positionsOfGrasses = {new Vector2d(0,0)};
        Vector2d[] positionsOfAnimals = {new Vector2d(1,1)};
        SimulationEngine res = null;
        boolean flag = false;
        try{
            res = mainOne(args,positionsOfGrasses,positionsOfAnimals);
            flag=true;
        } catch (Exception ignored){}
        assertTrue(flag);

        String result = "(0,2)";
        assertEquals(result,res.getListAsStrings());
    }
    @Test
    void range(){
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f",
                "f","f","f","f","f","f","f","f","f","f","f","f","f"};
        Vector2d[] positionsOfGrasses = {new Vector2d(0,0)};
        Vector2d[] positionsOfAnimals = {new Vector2d(1,1)};
        SimulationEngine res = null;
        boolean flag = false;
        try{
            res = mainOne(args,positionsOfGrasses,positionsOfAnimals);
            flag=true;
        } catch (Exception ignored){}
        assertTrue(flag);

        String result = "(0,25)";
        assertEquals(result,res.getListAsStrings());
    }
}