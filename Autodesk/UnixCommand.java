import java.util.Arrays;

public class UnixCommand {

    public static int[] solution(String[] commands) {
        int[] arr = new int[3];
        int cpCount = 0;
        int lsCount = 0;
        int mvCount = 0;

        for (String command : commands) {
            if (command.equals("cp")) {
                cpCount++;
            } else if (command.equals("ls")) {
                lsCount++;
            } else if (command.equals("mv")) {
                mvCount++;
            } else if (command.startsWith("!")) {
                String repeated = findCommand(commands, command);
                if (repeated.equals("cp")) {
                    cpCount++;
                } else if (repeated.equals("ls")) {
                    lsCount++;
                } else if (repeated.equals("mv")) {
                    mvCount++;
                }

            }
        }
        arr[0] = cpCount;
        arr[1] = lsCount;
        arr[2] = mvCount;

        return arr;
    }

    static String findCommand(String[] commands, String com) {
        if (!com.startsWith("!")) {
            return com;
        }

        int index = Integer.parseInt(com.substring(1)) - 1;
        return findCommand(commands, commands[index]);
    }

    public static void main(String[] args) {
        String[] commands = { "ls", "cp", "mv", "mv", "mv", "!1", "!3", "!6" };
        int[] result = solution(commands);

        System.out.println(Arrays.toString(result));
    }
}
