
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "A", 10, 20000));
        employees.add(new Employee(2, "B", 9, 20000));
        employees.add(new Employee(3, "C", 10, 10000));
        employees.add(new Employee(4, "D", 40, 10000));
        
        QuickSort sort = new QuickSort();
        sort.quickSort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}