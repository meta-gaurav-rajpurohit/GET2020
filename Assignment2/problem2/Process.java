public class Process {
    public String name;
    public int arrival_time;
    public int burst_time;
    public int completion_time;
    public int turn_around_time;
    public int service_time;
    public int waiting_time;
    public static double average_waiting_time;
    public static double average_turn_around_time;

    /**
     * Parameterize Constructor of Process class to initialize variable
     *
     * @param namethe first {@code String} to initialization
     * @param arriveal_ timethe second {@code int} to initialization
     * @param bust_time the third {@code int} to initialization
     */
    public Process(String name, int arrival_time, int burst_time) {
        this.name = name;
        this.arrival_time = arrival_time;
        this.burst_time = burst_time;
    }

    /**
     * Calculate waiting time for each process.
     *
     * @param p the first {@code Process} to calculate waiting time
     */
    public void waitingTime(Process p) {
        this.service_time = p.service_time + p.burst_time;
        this.waiting_time = this.service_time - this.arrival_time;
        average_waiting_time += this.waiting_time;
    }

    /**
     * Calculate turnaround time for each process.
     *
     * @param no parameter pass
     */
    public void turnaroundTime() {
        this.turn_around_time = this.waiting_time + this.burst_time;
        average_turn_around_time += this.turn_around_time;
    }

    /**
     * Calculate complete time for each process.
     *
     * @param no parameter pass
     */
    public void completeTime() {
        this.completion_time = this.turn_around_time + this.arrival_time;
    }

    /**
     * Show the values of each process.
     *
     * @param no parameter pass
     */
    public void show() {
        System.out.println(String.format(
                " %-15s %-15s %-15s %-15s %-15s %-15s ", this.name,
                this.arrival_time, this.burst_time, this.turn_around_time,
                this.waiting_time, this.completion_time));

    }
}
