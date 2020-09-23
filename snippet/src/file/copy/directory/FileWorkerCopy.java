package file.copy.directory;

import logger.TestLogger;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 디렉토리 및 파일 복사 하기 (JDK 1.7)
 */
public class FileWorkerCopy {

    static Path root = Paths.get("./snippet/sample");
    static Path targetRoot = Paths.get("./snippet/copyToWalk");

    public static void main(String[] args) throws IOException {
        TestWalker walker = new TestWalker();
        Files.walkFileTree(root, walker);
    }

    public static class TestWalker extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
            return super.postVisitDirectory(dir, exc);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
            TestLogger.print("D:" + dir);
            createDir(dir);
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            TestLogger.print("F:" + file);
            copyFile(file);
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            if (exc instanceof AccessDeniedException) {
                return FileVisitResult.SKIP_SUBTREE;
            }
            return super.visitFileFailed(file, exc);
        }

        private Path getTargetPath(Path source) {
            Path destination = null;
            Path pathRelative = root.relativize(source);
            if (pathRelative == null) {
//                TestLogger.print("[pathRelative] :: root");
//                destination = targetRoot;
            } else {
//                TestLogger.print("[pathRelative] :: " + pathRelative);
                destination = Paths.get(targetRoot.toString() + File.separator + pathRelative.toString());
//                TestLogger.print("T:" + destination);
            }
            return destination;
        }

        private void createDir(Path source) {
            Path destination = getTargetPath(source);

            if (destination == null) {
//                TestLogger.print("D: [pathRelative] :: root");
            } else {
                TestLogger.print("D(T):" + destination);
                File dest = destination.toFile();
                if (!dest.exists()) {
                    dest.mkdirs();
                }
            }
        }

        private void copyFile(Path source) {
            Path destination = getTargetPath(source);
            TestLogger.print("F(T):" + destination);

            BufferedWriter bw = null;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(source.toFile())));
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination.toFile())));
                while (true) {
                    String str = br.readLine();
                    if (str == null) break;
                    bw.write(str);
                    bw.newLine();
                }
                br.close();
                bw.close();
            } catch (IOException E) {
            }
        }
    }
}
