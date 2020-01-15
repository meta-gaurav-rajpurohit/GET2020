import java.io.*;

public class main__ {
    public static void main(String args[]) {

        int process_num, i, chance = 3, minchance = 0, number2 = 2;
        double awt, tat;
        boolean flag = true;

        while (flag) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter number of process : ");
                process_num = Integer.parseInt(br.readLine());
                int p[][] = new int[process_num][number2];
                Process processNum[] = new Process[process_num];

                String name;
                
                for(i=0; i < process_num ; i++){
                    System.out.print("Arival time : ");
                    p[i][0] = Integer.parseInt(br.readLine());
                    System.out.print("Bust time : ");
                    p[i][1] = Integer.parseInt(br.readLine());                    
                }
                
                for (i = 0; i < process_num; i++) {
                    name = "P" + (i + 1);
                    processNum[i] = new Process(name, p[i][0], p[i][1]);
                }
                
                processNum[0].waiting_time = 0;
                i = 1;
                // set waiting time for each process
                while (i < process_num) {
                    processNum[i].waitingTime(processNum[i - 1]);
                    i++;
                }

                i = 0;
                //set turnaround time and complete time
                while (i < process_num) {
                    processNum[i].turnaroundTime();
                    processNum[i].completeTime();
                    i++;
                }

                awt = Process.average_waiting_time / process_num;
                tat = Process.average_turn_around_time / process_num;
                System.out.println(String.format(
                        " %-15s %-15s %-15s %-15s %-15s %-15s", "Process name",
                        "Arrive Time", " Bust Time", " Turnaround Time",
                        " Waiting Time", "Complete Time"));

                i = 0;
                while (i < process_num) {
                    processNum[i].show();
                    i++;
                }
                System.out.println(" Average Waiting Time : " + awt
                        + "\n Average Turnaround Time : " + tat);
                chance = minchance;
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception : "+ e.getMessage());
                System.out.println("Please enter number not "
                        + "string(Contain alphabet, spacial charecter, space, operator) : "
                        + "\nExample :- \n 1, 12, 164, 908 ");
                chance--;
            } catch (IOException e) {
                System.out.println("Input Outout Exception : " + e.getMessage());
                chance--;
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
                chance--;
            }
            if (chance == minchance)
                flag = false;
            else
                System.out.println("\nRemain Chances available : " + chance);
        }
    }
}
