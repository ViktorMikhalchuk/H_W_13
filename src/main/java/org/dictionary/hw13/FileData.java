package org.dictionary.hw13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class FileData {
    private String fileName;
    private long fileSize;
    private String filePath;

    public FileData(String fileName, long fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }


    @Override
    public String toString() {
        return fileName;
    }

    public void saveFile() {
        Path filePath = Paths.get(this.filePath, fileName);

        try {
            Files.write(filePath, Collections.singletonList("I study Java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
