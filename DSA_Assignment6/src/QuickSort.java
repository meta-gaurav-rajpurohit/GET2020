import java.util.List;


public class QuickSort {
    
    private void swap(int firstEmployeeIndex, int secondEmployeeIndex, List<Employee> employees) {
        Employee tempEmployee = employees.get(firstEmployeeIndex);
        employees.set(firstEmployeeIndex, employees.get(secondEmployeeIndex));
        employees.set(secondEmployeeIndex, tempEmployee);
    }
    
    private int partition(List<Employee> employees, int start, int end) {
        Employee pivotEmployee = employees.get(end);
        int index = start - 1;
        for (int secondIndex = start; secondIndex <= (end - 1); secondIndex++) {
            Employee currentEmployee = employees.get(secondIndex);
            if (currentEmployee.salary > pivotEmployee.salary) {
                index++;
                swap(index, secondIndex, employees);
            } else if (currentEmployee.salary == pivotEmployee.salary) {
                if (currentEmployee.age < pivotEmployee.age) {
                    index++;
                    swap(index, secondIndex, employees);
                }
            }
        }
        swap(index + 1, end, employees);
        return (index + 1);
    }
    
    private void quickSort(List<Employee> employees, int start, int end) {
        if (start < end) {
            int almostMiddleIndex = partition(employees, start, end);
            quickSort(employees, start, almostMiddleIndex - 1);
            quickSort(employees, almostMiddleIndex + 1, end);
        }
    }
    
    public void quickSort(List<Employee> employees) {
        quickSort(employees, 0, employees.size() - 1);
    }
}
