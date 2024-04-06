/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ShortestDisModel;

import java.util.List;
import java.util.Random;

/**
 *
 * @author chiran
 */
public class ShortestDisControl {
    List<Integer> computedPath;
    
    
    public void shortestDistnace(int[][]map){
        ShortestDisModel model = new ShortestDisModel(map);
        computedPath = model.findShortestPath(0);
    }
    
    public boolean checkPlayerAnswer(List<Integer> playerAnswer) {
        if (playerAnswer.size() != computedPath.size()) {
            return false;
        }
        for (int i = 0; i < playerAnswer.size(); i++) {
            if (!playerAnswer.get(i).equals(computedPath.get(i))) {
                return false;
            }
        }
        return true;
    }
}
