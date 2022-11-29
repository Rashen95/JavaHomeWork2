//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.*;

public class Task02 {
    public static void main(String[] args) {
        int[] massive = new int[]{15, 1, 10, 2, 8, -5, 19, 7, 6, 15, 10, 0, 1, -1};
        try (FileWriter writer = new FileWriter("log_file.txt", true)) {
            StringBuilder log = new StringBuilder();
            for (int i = 0; i < massive.length; i++) {
                if (i == 0) {
                    log.append("[");
                    log.append(massive[i]);
                    log.append(", ");
                }
                else if (i == massive.length - 1) {
                    log.append(massive[i]);
                    log.append("]");
                }
                else {
                    log.append(massive[i]);
                    log.append(", ");
                }
            }
            writer.write(log.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int[] sort_massive = bubble_sort(massive);
        for (int i = 0; i < sort_massive.length; i++) {
            if (i == 0) {
                System.out.printf("[%s, ", sort_massive[i]);
            } else if (i == sort_massive.length - 1) {
                System.out.printf("%s]", sort_massive[i]);
            } else {
                System.out.printf("%s, ", sort_massive[i]);
            }
        }
    }


    static int[] bubble_sort(int[] massive) {
        for (int i = 1; i < massive.length; i++) {
            if (massive[i] < massive[i - 1]) {
                int temp = massive[i];
                massive[i] = massive[i - 1];
                massive[i - 1] = temp;
                try (FileWriter writer = new FileWriter("log_file.txt", true)) {
                    StringBuilder log = new StringBuilder();
                    for (int j = 0; j < massive.length; j++) {
                        if (j == 0) {
                            log.append("[");
                            log.append(massive[j]);
                            log.append(", ");
                        }
                        else if (j == massive.length - 1) {
                            log.append(massive[j]);
                            log.append("]");
                        }
                        else {
                            log.append(massive[j]);
                            log.append(", ");
                        }
                    }
                    writer.write(log.toString());
                    writer.append('\n');
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        if (!massive_checker(massive)) {
            bubble_sort(massive);
        }
        return massive;
    }

    static boolean massive_checker(int[] massive) {
        boolean check = true;
        for (int i = 1; i < massive.length; i++) {
            if (massive[i] < massive[i - 1]) {
                check = false;
                break;
            }
        }
        return check;
    }
}
