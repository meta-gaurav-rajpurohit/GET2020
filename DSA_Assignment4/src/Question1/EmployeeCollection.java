package Question1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCollection {

        private List<Employee> employeeList;

        public EmployeeCollection() {
                employeeList = new ArrayList<>();
        }
        public void addEmployee(Employee employee) throws Exception {
                if (employee == null) {
                        throw new Exception("Null object can't be added.");
                }

                if (isUnique(employee.getId())) {
                        employeeList.add(employee);
                } else {
                        throw new Exception("ID is not unique");
                }
        }

        private Boolean isUnique(int id) {
                for (Employee iterator : employeeList) {
                        if (iterator.getId() == id) {
                                return false;
                        }
                }
                return true;
        }

        public List<Employee> sortById() {
                List<Employee> sortedList = employeeList;
                Collections.sort(sortedList);
                return employeeList;
        }

        public List<Employee> sortByName() {
                List<Employee> sortedList1 = employeeList;
                Collections.sort(sortedList1, new SortByName());
                return sortedList1;
        }

}