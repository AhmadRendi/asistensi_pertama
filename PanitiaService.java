import java.util.List;

public class PanitiaService extends Panitia {
    
    public boolean login(String username, String password){
        if(USERNAME.equals(username) && PASSWORD.equals(password)){
            return true;
        }
        return false;
    }

    public Mahasiswa validationTerdaftar(List<Mahasiswa> list, String nim){
        Mahasiswa mahasiswa = new Mahasiswa();
        for(int i = 0; i < list.size(); i++){
            if(nim.equals(list.get(i).getNim())){
                mahasiswa = list.get(i);
            }
        }

        mahasiswa.setStatusAktif(true);
        mahasiswa.setStatusDiTerima(true);
        mahasiswa.setStatusMendaftar(false);

        return mahasiswa;
    }

}
