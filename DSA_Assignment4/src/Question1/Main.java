package Question1;


import java.util.List;

public class Main {

        public static void main(String[] args) {
                Main mainObject = new Main();
                try {
                        mainObject.userInput();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }

        /*
         * function to get user input
         * 
         * @throws exception
         */
        private void userInput() throws Exception {
                EmployeeCollection employeeCollection = new EmployeeCollection();
                employeeCollection.addEmployee(new Employee(1, "gaurav", "xyz street"));
                employeeCollection.addEmployee(new Employee(3, "gunajn", "xyz street"));
                employeeCollection.addEmployee(new Employee(2, "kashish", "xyz street"));

                System.out.println("sort by id : ");
                List<Employee> sortedOnId = employeeCollection.sortById();
                for (Employee employee : sortedOnId) {
                        System.out.println(employee.getEmployeeName());
                }
                
                System.out.println("sort by name : ");
                List<Employee> sortedOnName = employeeCollection.sortByName();
                for (Employee employee : sortedOnName) {
                        System.out.println(employee.getEmployeeName());
                }
        }
}
