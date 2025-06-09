import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class testOf {

    private testOf() {};

    public static void main(String[] args) {
        
        List<String> listaModificabile = new ArrayList<>(List.of("uno", "due", "tre"));
        List<String> copia = new LinkedList(listaModificabile);
        listaModificabile.add("quattro");
        copia.remove("tre");
        System.out.println(listaModificabile + "; " + copia);

    }

}
