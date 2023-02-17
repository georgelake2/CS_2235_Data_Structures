package Chapter_4;

public class Experiment {
    public static String concat1(char c, int n) {
        String answer = "";
        for (int i=0; i<n; i++) {
            answer += c;
        }
        return answer;
    }

    public static String concat2(char c, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i<n; i++) {
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String [] args) {
        int n= 1000000;

        int trials = 10;
        long avg_time;


        //System.out.println(concat1('*', n));
        //System.out.println(concat2('&', n));

        // Run concat1 (String)
        long startTime = System.currentTimeMillis();
        for (int i=0; i<trials; i++) {
            concat1('*', n);
        }
        long endTime = System.currentTimeMillis();
        avg_time = (endTime - startTime) / trials;
        System.out.println("Time concat1 took: " + avg_time);

        // Run concat2 (String)
        startTime = System.currentTimeMillis();
        for (int i=0; i<trials; i++) {
            concat2('&', n);
        }
        endTime = System.currentTimeMillis();
        avg_time = (endTime - startTime) / trials;
        System.out.println("Time concat2 took: " + avg_time);
    }
}
