import java.util.HashMap;

public class Marksheet_ {
    int num = 0;
    double number0 = 0.00, number100 = 100.00, pass = 40.00;

    /**
     * Calculate average marks of student.
     *
     * @param  hm the first {@code HashMap<String, Double>} to calculate average
     *                   String : name of student
     *                   Double : percentage of student
     * @param  studentnum the second {@code int} to calculate average
     *                  if studentnum equal to 0 then throw ArithmeticException
     * @return the double value 
     */
    public double avgMarks(HashMap<String, Double> hm, int studentnum) {
        double avg = number0;
        try {
            if (studentnum == number0)
                throw new ArithmeticException();
            for (HashMap.Entry<String, Double> entry : hm.entrySet())
                avg = avg + entry.getValue();
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception : " + e.getMessage());
            System.out.println("Number of student value greater then 0 ");
        }
        return (avg / studentnum);
    }

    /**
     * Find Maximum marks of student.
     *
     * @param  hm the first {@code HashMap<String, Double>} to calculate average
     *                   String : name of student
     *                   Double : percentage of student
     * @return the double value 
     */
    public double maxMarks(HashMap<String, Double> hm) {
        double max = number0, temporary;
        for (HashMap.Entry<String, Double> entry : hm.entrySet()) {
            temporary = entry.getValue();
            if (max < temporary)
                max = temporary;
        }
        return max;
    }

    /**
     * Find Minimum marks of student.
     *
     * @param  hm the first {@code HashMap<String, Double>} to Find Minimum marks
     *                   String : name of student
     *                   Double : percentage of student
     * @return the double value 
     */
    public double minMarks(HashMap<String, Double> hm) {
        double min = number100, temporary;
        for (HashMap.Entry<String, Double> entry : hm.entrySet()) {
            temporary = entry.getValue();
            if (min > temporary)
                min = temporary;
        }
        return min;
    }

    /**
     * Calculate average of passing student.
     *                  passing condition : above 40 percentage marks 
     *                  
     * @param  hm the first {@code HashMap<String, Double>} to calculate average of passing student
     *                   String : name of student
     *                   Double : percentage of student
     * @param  studentnum the second {@code int} to calculate average of passing student
     *                  if studentnum equal to 0 then throw ArithmeticException
     * @return the double value 
     */
    public double passStdPer(HashMap<String, Double> hm, int studentnum) {
        int count = num;
        double temporary;
        try {
            if (studentnum == number0)
                throw new ArithmeticException();
            for (HashMap.Entry<String, Double> entry : hm.entrySet()) {
                temporary = entry.getValue();
                if (temporary >= pass)
                    count++;
            }
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception : " + e.getMessage());
            System.out.println("Number of student value greater then 0 ");
        }
        return (count * number100) / studentnum;
    }
}

