package com.targetindia.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users", "vinod", "Desktop", "package.json");
        Path path2 = Path.of("/Users", "vinod", "Desktop", "package.json.backup");
        Path path3 = Path.of("/Users", "vinod", "Documents", "_temp", "package.json");

        Files.deleteIfExists(path2);
        System.out.printf("'%s' is a valid path? %s%n", path.toFile().getAbsolutePath(), Files.exists(path));

        Files.copy(path, path2);
//        Files.move(path, path3);
        Path path4 = Path.of("/Users/vinod/Documents/_temp/vinod/kumar/bangalore");
        Files.createDirectories(path4);
        String content = Files.readString(path);
        System.out.println(content);
    }
}
