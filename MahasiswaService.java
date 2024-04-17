import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaService{
    

    private List<Mahasiswa> mahasiswa = new ArrayList<>();
     
    private String numberFirst = "0000";

    // private boolean validateName(String name){
    //     boolean checkNumber = Pattern.matches(".*\\d.*", name);
    //     boolean cehckSymbol = Pattern.compile("[\\p{Punct}]").matcher(name).find();
    //     if(!checkNumber && !cehckSymbol){
    //         return true;
    //     }
    //     throw new InputMismatchException("Name Is Not Valid!");
    // }


    public void mendaftar(Mahasiswa mhs){
        
        LocalDate localDate = LocalDate.now();
        Integer year = localDate.getYear();

        if(listSesusaiJurusanPendaftar(mhs.getJurusan()).isEmpty()){
            int number = 0;
            String nimMhsTemp = mhs.getJurusan().getNim().toString() + year.toString()  + numberFirst;
            Long n = Long.valueOf(nimMhsTemp);
            Long nimMhs = n + number++;
            mhs.setNim(String.valueOf(nimMhs));
        }else {
            int n = listSesusaiJurusanPendaftar(mhs.getJurusan()).size();
            String nimMahasiswaLast = 
                listSesusaiJurusanPendaftar(mhs.getJurusan()).get(n - 1).getNim();
            Long temp = Long.valueOf(nimMahasiswaLast);
            Long tempNim = temp + 1;
            mhs.setNim(String.valueOf(tempNim));
        }
        mahasiswa.add(mhs);
    }

    private List<Mahasiswa> listSesusaiJurusanPendaftar(Jurusan jurusan){
        List<Mahasiswa> list = new ArrayList<>();
        for(Mahasiswa mahasiswa : mahasiswa){
            if(mahasiswa.getJurusan().getName() == jurusan.getName()){
                list.add(mahasiswa);
            }
        }
        return list;
    }


    public List<Mahasiswa>  mahasiswaTerdaftar(){
        List<Mahasiswa> list = new ArrayList<>();
        for (Mahasiswa mahasiswa2 : mahasiswa) {
            if(mahasiswa2.isStatusDiTerima()){
                list.add(mahasiswa2);
            }           
        }
        return list;
    }

    public List<Mahasiswa> mahasiswaMendaftar(){

        List<Mahasiswa> list = new ArrayList<>();

        for(Mahasiswa mhs : mahasiswa){
            if(mhs.isStatusMendaftar()){
                list.add(mhs);
            }
        }
        return list;
    }

    public List<Mahasiswa> mahasiswaLulusList(){
        List<Mahasiswa> list = new ArrayList<>();

        for(Mahasiswa mhs : mahasiswa){
            if(mhs.isStatusLulus()){
                list.add(mhs);
            }
        }
        return list;
    }

    public void validationTerdaftar(Mahasiswa mahasiswa){
        for (int i = 0; i < mahasiswaMendaftar().size(); i++){
            if(mahasiswaMendaftar().get(i).equals(mahasiswa.getNim())){
                mahasiswaMendaftar().get(i).setStatusAktif(mahasiswa.isStatusAktif());
                mahasiswaMendaftar().get(i).setStatusDiTerima(mahasiswa.isStatusDiTerima());
                mahasiswaMendaftar().get(i).setStatusMendaftar(mahasiswa.isStatusMendaftar());
            }
        }
    }

    public void validationLulus(String nim){
        for (int i = 0; i < mahasiswaTerdaftar().size(); i++){
            if(mahasiswaTerdaftar().get(i).getNim().equals(nim)){
                mahasiswaTerdaftar().get(i).setStatusLulus(true);
            }
        }
    }

    

     
    
}
