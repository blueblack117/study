package file.walkFileTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 디렉토리 및 파일 검색하면서 작업 하기 (JDK 1.7)
 */
public class FileWorkerTest {

    public static void main(String[] args) throws IOException {

        File root = new File("./snippet/sample");
        TestWalker walker = new TestWalker();
        Files.walkFileTree(root.toPath(), walker);
    }

    public static class TestWalker extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
            return super.postVisitDirectory(dir, exc);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
            System.out.println("D:" + dir);
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            System.out.println("F:" + file);
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            if (exc instanceof AccessDeniedException) {
                return FileVisitResult.SKIP_SUBTREE;
            }
            return super.visitFileFailed(file, exc);
        }
    }
}
