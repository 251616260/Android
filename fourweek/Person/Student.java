package fourweek.Person;

/**
 * @author CHENHAOJIA
 * @date 2021-04-07 20:34
 */
public class Student extends Person{
    private String locationClass;//所在班级

    public Student(String name, String sno, int age, String sex, String political, String locationClass) {
        super(name, sno, age, sex, political);
        this.locationClass = locationClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "locationClass='" + locationClass + " " +
                "name=" +this.getName()  +" "+
                "sno= " +this.getSno() +" "+
                "sex=" +this.getSex() +" "+
                "political="+getPolitical()+" "+
                "locationClass="+getLocationClass()+" "+
                '}';
    }

    public String getLocationClass() {
        return locationClass;
    }

    public void setLocationClass(String locationClass) {
        this.locationClass = locationClass;
    }
}
