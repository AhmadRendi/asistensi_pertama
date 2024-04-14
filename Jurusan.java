public class Jurusan {
    

    private String name;

    private Integer nim;

    private Fakultas fakultas;

    public Jurusan() {
    }

    public Jurusan(String name, Integer nim, Fakultas fakultas) {
        this.name = name;
        this.nim = nim;
        this.fakultas = fakultas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }

    
}
