package model;


/**
 * Created by admin on 2017/5/19.
 */
public class Spittler {
    private Long id;

    private String name;

    private String password;

    private String email;

    public Spittler() {
    }

    public Spittler(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spittler)) return false;

        Spittler spittler = (Spittler) o;

        if (id != null ? !id.equals(spittler.id) : spittler.id != null) return false;
        if (name != null ? !name.equals(spittler.name) : spittler.name != null) return false;
        if (password != null ? !password.equals(spittler.password) : spittler.password != null) return false;
        return email != null ? email.equals(spittler.email) : spittler.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
