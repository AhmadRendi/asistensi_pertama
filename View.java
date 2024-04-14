import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    
    private Scanner scanner = new Scanner(System.in);
    private MahasiswaService mahasiswaService = new MahasiswaService();
    private FakultasService fakultasService = new FakultasService();
    private JurusanService jurusanService = new JurusanService();
    private PanitiaService panitiaService = new PanitiaService();

    private Mahasiswa viewAddMahasiswa(){
        System.out.print("Masukan Nama : ");
        String name = scanner.nextLine();
        Fakultas fakultas = choiseFakultas();

        System.out.println(fakultas.getName());

        Jurusan jurusan = choiseJurusan(fakultas);

        Mahasiswa mahasiswa = new Mahasiswa(name, jurusan);

        return mahasiswa;
    }


    private Fakultas  choiseFakultas(){
        Map<Integer, Fakultas> listMap = new HashMap<>();


        for (int i = 0; i < fakultasService.getAllFakultas().size(); i++){
            listMap.put(i + 1, fakultasService.getAllFakultas().get(i));
        }

        for(Map.Entry<Integer, Fakultas> maEntry : listMap.entrySet()){
            System.out.println(maEntry.getKey() + " : " + maEntry.getValue().getName());
        }
        
        System.out.print("Pilih Fakultas : ");
        Integer choise = scanner.nextInt();

        Fakultas fakultas = listMap.get(choise);

        return fakultas;
    }

    private Jurusan choiseJurusan(Fakultas fakultas){
        Map<Integer, Jurusan> listMap = new HashMap<>();

        for(int i = 0; i < jurusanService.getAllJurusan().size(); i++){
            if(jurusanService.getAllJurusan().get(i).getFakultas().getName() == fakultas.getName()){
                listMap.put(i + 1, jurusanService.getAllJurusan().get(i));
            }
        }

        for(Map.Entry<Integer, Jurusan> maEntry : listMap.entrySet()){
            System.out.println(maEntry.getKey() + " : " + maEntry.getValue().getName());
        }

        System.out.print("Pilih Jurusan : ");
        Integer choise = scanner.nextInt();

        Jurusan jurusan = listMap.get(choise);

        return jurusan;
    }

    private void viewMahasiswaTerdaftar(){
        if(!mahasiswaService.mahasiswaTerdaftar().isEmpty()){
            for(Mahasiswa mahasiswa : mahasiswaService.mahasiswaTerdaftar()){
                System.out.println("Nama : " + mahasiswa.getName());
                System.out.println("Stanbuk : " + mahasiswa.getNim());
                System.out.println("Fakultas : " + mahasiswa.getJurusan().getFakultas().getName());
                System.out.println("Jurusan : " + mahasiswa.getJurusan().getName());
            }
        }else {
            System.out.println("Tidak ada Mahasiswa Terdaftar");
        }
    }

    private void viewMahasiswaMendaftar(){
        if(!mahasiswaService.mahasiswaMendaftar().isEmpty()){
            for(Mahasiswa mahasiswa : mahasiswaService.mahasiswaMendaftar()){
                System.out.println("Nama : " + mahasiswa.getName());
                System.out.println("Stanbuk : " + mahasiswa.getNim());
                System.out.println("Fakultas : " + mahasiswa.getJurusan().getFakultas().getName());
                System.out.println("Jurusan : " + mahasiswa.getJurusan().getName());
            }
        }else {
            System.out.println("Tidak ada Mahasiswa Mendaftar");
        }
    }

    private void viewMahasiswaLulus(){
        if(!mahasiswaService.mahasiswaLulusList().isEmpty()){
            for(Mahasiswa mahasiswa : mahasiswaService.mahasiswaLulusList()){
                System.out.println("Nama : " + mahasiswa.getName());
                System.out.println("Stanbuk : " + mahasiswa.getNim());
                System.out.println("Fakultas : " + mahasiswa.getJurusan().getFakultas().getName());
                System.out.println("Jurusan : " + mahasiswa.getJurusan().getName());
            }
        }
    }

    private boolean viewLogin(){
        System.out.print("Masukan Username : ");
        String username = scanner.nextLine();

        System.out.print("Masukan Password : ");
        String password = scanner.nextLine();

        if(panitiaService.login(username, password)){
            return true;
        }
        return false;
    }



    private void menu(){
        System.out.println(
            "1. Mendaftar \n2. Validasi"
        );
    }

    private void menuPanitia(){
        System.out.println(
            "1. Validasi \n2. List Mahasiswa Mendaftar " +
            "\n3. List Mahasiswa Terdaftar \n4. List Mahasiswa Lulus"
        );
    }


    public void view(){

        int choise = 0;
        while (true) {
            menu();
            System.out.print("Masukan Pilihan : ");
            choise = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\033[H\033[2J");  

            if(choise == 1){
                Mahasiswa mahasiswa = viewAddMahasiswa();
                mahasiswaService.mendaftar(mahasiswa);
            }else if (choise == 2) {
                if(viewLogin()){
                    System.out.print("\033[H\033[2J");  
                    menuPanitia();
                    choise = scanner.nextInt();
                    System.out.print("\033[H\033[2J");  
                    if(choise == 1){

                    }else if (choise == 2){
                        viewMahasiswaMendaftar();
                    }else if (choise == 3){
                        viewMahasiswaTerdaftar();
                    }else if (choise == 4){
                        viewMahasiswaLulus();
                    }
                }
            }
        }
    }
    


}
