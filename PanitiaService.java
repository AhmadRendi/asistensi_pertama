public class PanitiaService extends Panitia {
    
    public boolean login(String username, String password){
        if(USERNAME.equals(username) && PASSWORD.equals(password)){
            return true;
        }
        return false;
    }

}
