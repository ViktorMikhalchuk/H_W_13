package org.dictionary;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        this.fileMap = new HashMap<>();
    }

    public void add(String filePath, String fileName, long fileSize) {
        FileData fileData = new FileData(fileName, fileSize, filePath);

        if (!isPathConsistent(filePath, fileData)) {
            System.out.println("Error: Path inconsistency. Path in FileData does not match the key path.");
            return;
        }

        fileMap.computeIfAbsent(filePath, k -> new ArrayList<>()).add(fileData);
    }

    private boolean isPathConsistent(String keyPath, FileData fileData) {
        return keyPath.equals(fileData.getFilePath());
    }

    public List<FileData> find(String filePath) {
        return fileMap.getOrDefault(filePath, new ArrayList<>());
    }

    public List<FileData> filterBySize(String filePath, long maxSize) {
        List<FileData> result = new ArrayList<>();
        List<FileData> files = fileMap.getOrDefault(filePath, new ArrayList<>());

        for (FileData file : files) {
            if (file.getFileSize() <= maxSize) {
                result.add(file);
            }
        }

        return result;
    }

    public void remove(String filePath) {
        fileMap.remove(filePath);
    }

    public List<FileData> sortBySize(String filePath) {
        List<FileData> files = fileMap.getOrDefault(filePath, new ArrayList<>());
        files.sort(Comparator.comparingLong(FileData::getFileSize));
        return files;
    }

    public void saveAllFiles() {
        for (Map.Entry<String, List<FileData>> entry : fileMap.entrySet()) {
            for (FileData file : entry.getValue()) {
                file.saveFile();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Files in FileNavigator:\n");

        for (Map.Entry<String, List<FileData>> entry : fileMap.entrySet()) {
            sb.append(entry.getKey()).append("-> ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }
}
