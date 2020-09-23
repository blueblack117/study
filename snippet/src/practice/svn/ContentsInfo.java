package practice.svn;

import java.nio.file.Path;

public class ContentsInfo {

    boolean directory;
    Path path;
    // c : create
    // u : modify
    // d : delete
    char mode;

    public ContentsInfo(boolean directory, Path path) {
        this.directory = directory;
        this.path = path;
    }

    public ContentsInfo(boolean directory, Path path, char mode) {
        this.directory = directory;
        this.path = path;
        this.mode = mode;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return (directory ? "D&" : "F&") + mode + "&" + path;
    }
}
