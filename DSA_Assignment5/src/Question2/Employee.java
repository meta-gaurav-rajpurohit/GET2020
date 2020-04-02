package Question2;

public class Employee {
    private String name;
    private double salary;
    private int age;
    private Employee next;
    
    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        Employee next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", age=" + age
                + ", next=" + next + "]";
    }

}
