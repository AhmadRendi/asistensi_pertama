public class Mahasiswa {


    private String name;
    
    private String nim;

    private Jurusan jurusan;

    private boolean statusLulus;

    private boolean statusAktif;

    private boolean statusDiTerima;

    private boolean statusMendaftar;

    public Mahasiswa() {
    }

    public Mahasiswa(String name, Jurusan jurusan) {
        this.name = name;
        this.jurusan = jurusan;
        this.statusDiTerima = false;
        this.statusMendaftar = true;
        this.statusLulus = false;
        this.statusAktif = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public boolean isStatusLulus() {
        return statusLulus;
    }

    public void setStatusLulus(boolean statusLulus) {
        this.statusLulus = statusLulus;
    }

    public boolean isStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }

    public boolean isStatusDiTerima() {
        return statusDiTerima;
    }

    public void setStatusDiTerima(boolean statusDiTerima) {
        this.statusDiTerima = statusDiTerima;
    }

    public boolean isStatusMendaftar() {
        return statusMendaftar;
    }

    public void setStatusMendaftar(boolean statusMendaftar) {
        this.statusMendaftar = statusMendaftar;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }
}
