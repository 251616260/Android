package fourweek.Person;

/**
 * @author CHENHAOJIA
 * @date 2021-04-07 20:30
 */
public class Person {
    private String name;
    private String sno;
    private int age;
    private String sex;
    private String political;

    public Person() {
    }

    public Person(String name, String sno, int age, String sex, String political) {
        this.name = name;
        this.sno = sno;
        this.age = age;
        this.sex = sex;
        this.political = political;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }
}
