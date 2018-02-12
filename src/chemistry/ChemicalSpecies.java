package chemistry;

import java.util.List;

public class ChemicalSpecies {
    public enum element {
        H,He,Li,Be,B,C,N,O,S
    }
    public int coefficient;
    public List<element> elements;
    public List<Integer> subscripts;
    public int charge;
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.coefficient > 1) {
            sb.append(coefficient);
        }
        for(int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i).name());
            if(subscripts.get(i) > 1) {
                sb.append("<sub>").append(subscripts.get(i)).append("</sub>");
            }
        }
        return sb.toString();
    }    
}