import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JurusanService {
    

    private List<Jurusan> listJurusan = new ArrayList<>(
        Arrays.asList(
            new Jurusan("Teknik Informatika", 130, new Fakultas("Fakultas Ilmu Komputer")),
            new Jurusan("Sistem Informatika", 131, new Fakultas("Fakultas Ilmu Komputer")),
            new Jurusan("Teknik Sipil", 150, new Fakultas("Fakultas Teknik")),
            new Jurusan("Teknik Mesin", 151, new Fakultas("Fakultas Teknik")),
            new Jurusan("Teknik Electro", 152, new Fakultas("Fakultas Teknik")),
            new Jurusan("Arsitektur", 153, new Fakultas("Fakultas Teknik")),
            new Jurusan("Farmasi", 120, new Fakultas("Fakultas Farmasi")),
            new Jurusan("Ilmu Hukum", 110, new Fakultas("Fakultas Hukum"))
        )
    );

    public void addJurusan(Jurusan jurusan){
        this.listJurusan.add(jurusan);
    }

    public List<Jurusan> getAllJurusan(){
        return this.listJurusan;
    }


}
