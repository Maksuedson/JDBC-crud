package modelo;

public class Funcionario {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String departamento;
    private Double salario;
    
    public Funcionario(){
    }
    
        public Funcionario(int id){
        this.id = id;
    }

    public Funcionario(int id, String firstName, String lastName, String email, String departamento, Double salario) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departamento = departamento;
        this.salario = salario;
    }
    
        public Funcionario(String firstName, String lastName, String email, String departamento, Double salario) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departamento = departamento;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "\nid=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", departamento=" + departamento + ", salario=" + salario;
    }
    
    
    
    
}
