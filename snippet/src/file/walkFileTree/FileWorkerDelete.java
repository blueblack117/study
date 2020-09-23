package file.walkFileTree;

import logger.TestLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 디렉토리 및 파일 검색하면서 삭제하기 (JDK 1.7)
 */
public class FileWorkerDelete {

    public static void main(String[] args) throws IOException {

        File root = new File("./snippet/copyToWalk/TARGET");
        Files.walkFileTree(root.toPath(),
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult postVisitDirectory(
                            Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(
                            Path file, BasicFileAttributes attrs)
                            throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }
                });

        if (Files.exists(root.toPath())) {
            TestLogger.print("delete fail");
        } else {
            TestLogger.print("delete success");
        }
    }
}
