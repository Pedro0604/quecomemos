package usuarios;

public class Cliente extends NoAdmin {

    private String email;

    public Cliente() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
