/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemistry;

/**
 *
 * @author Samir Rehmtulla
 */
public class Engine {
    public static Chemistry.Reaction balance(Chemistry.Reaction reaction) {
        int numReactants = reaction.reactantsList.size();
        int numProducts = reaction.productsList.size();
        
        for(int i = 0; i<numReactants; i++) {
            String reactantString = reaction.reactantsList.get(i).get();
            char[] reactant = reactantString.toCharArray();
            for(int j = 0; j < reactant.length; j++) {
                if(Character.isUpperCase(reactant[j])) {
                    
                }
            }
        }
        return reaction;
    }
    
}
