package fourweek.Person;

/**
 * @author CHENHAOJIA
 * @date 2021-04-07 20:43
 */
public class Teacher extends Person{
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Teacher(String name, String sno, int age, String sex, String political, String department) {
        super(name, sno, age, sex, political);
        this.department = department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "department='" + department + '\'' +
                "name=" +this.getName()  +" "+
                "sno= " +this.getSno() +" "+
                "sex=" +this.getSex() +" "+
                "political="+getPolitical()+" "+
                "department"+getDepartment()+" "+
                '}';
    }
}
