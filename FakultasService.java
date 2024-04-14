import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakultasService {
    


    private List<Fakultas> listFakultas = new ArrayList<>(
        Arrays.asList(
            new Fakultas("Fakultas Ilmu Komputer"),
            new Fakultas("Fakultas Teknik"),
            new Fakultas("Fakultas Farmasi")
        )
    );


    public void addFakultas(Fakultas fakultas){
        listFakultas.add(fakultas);
    }


    public List<Fakultas> getAllFakultas(){
        return this.listFakultas;
    }


}
