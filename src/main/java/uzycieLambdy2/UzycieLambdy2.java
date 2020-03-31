package uzycieLambdy2;

import java.io.*;

public class UzycieLambdy2 {
    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");

        double copyTime = fileCopyTime(FileCopy.useIOStream, source, target);
        System.out.println(copyTime);
    }

    public static double fileCopyTime(FileCopy fileCopy, File source, File target) throws IOException {
        // zlap czas poczatkowy
        long start = System.currentTimeMillis();

        // przekopiuj
        fileCopy.copy(source, target);

        // zlap czas po zakonczeniu
        long end = System.currentTimeMillis();

        // zwroc wartosc
        return end - start;
    }

}

interface FileCopy {
    void copy(File source, File target) throws IOException;

    FileCopy useIOStream = (source1, target1) -> {
        try (FileInputStream in = new FileInputStream(source1);
             FileOutputStream out = new FileOutputStream(target1)) {
            int anotherByte;
            while (((anotherByte = in.read()) != -1)) {
                out.write(anotherByte);
            }

        }
    };

}