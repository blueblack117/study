package practice.svn;

import logger.TestLogger;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 디렉토리 및 파일 복사/수정/삭제 하기 (JDK 1.7)
 */
public class FileWorkerUpdatedCopy {

    static Path root = Paths.get("./snippet/sample");
    static Path targetRoot = Paths.get("./snippet/copyToWalk");

    public static void main(String[] args) throws IOException {
        Map<String, ContentsInfo> fileTreeMap = MetaFileReader.read();

        Map<String, ContentsInfo> afterFileTreeMap = new HashMap<>();
        CopyWalker walker = new CopyWalker();
        walker.setFileMap(afterFileTreeMap);
        Files.walkFileTree(root, walker);

        Set<String> danglingKeySet = fileTreeMap.keySet();
        for (String key : afterFileTreeMap.keySet()) {
            if (danglingKeySet.contains(key)) {
                danglingKeySet.remove(key);
            }
        }

        for (String key : danglingKeySet) {
            ContentsInfo info = fileTreeMap.get(key);

            if (info.isDirectory()) {
                TestLogger.print((info.isDirectory() ? "D" : "F") + "(D):" + info.getPath());
                DeleteWalker deleteWalker = new DeleteWalker();
                deleteWalker.setFileMap(afterFileTreeMap);
                Files.walkFileTree(info.getPath(), deleteWalker);
            } else {
                File targetFile = info.getPath().toFile();
                if (targetFile.exists()) {
                    TestLogger.print((info.isDirectory() ? "D" : "F") + "(D):" + info.getPath());
                    targetFile.delete();
                    afterFileTreeMap.put(info.getPath().toString(), new ContentsInfo(false, info.getPath(), 'd'));
                }
            }
        }

        MetaFileWriter.write(afterFileTreeMap);
    }

    public static class CopyWalker extends SimpleFileVisitor<Path> {

        Map<String, ContentsInfo> fileTreeMap = null;

        public void setFileMap(Map<String, ContentsInfo> fileTreeMap) {
            this.fileTreeMap = fileTreeMap;
        }

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
                // nothing
            } else {
//                TestLogger.print("D(T):" + destination);
                File dest = destination.toFile();

                if (!dest.exists()) {
                    TestLogger.print("D(A):" + destination);
                    fileTreeMap.put(destination.toString(), new ContentsInfo(true, destination, 'c'));
                    dest.mkdirs();
                } else {
                    TestLogger.print("D(U):" + destination);
                    ContentsInfo info = fileTreeMap.get(destination.toString());
                    if (info == null) {
                        fileTreeMap.put(destination.toString(), new ContentsInfo(true, destination, 'u'));
                    } else {
                        info.setMode('u');
                    }
                }
            }
        }

        private void copyFile(Path source) {
            Path destination = getTargetPath(source);
//            TestLogger.print("F(T):" + destination);

            File destFile = destination.toFile();
            if (destFile.exists()) {
                TestLogger.print("F(U):"+ destination);
                ContentsInfo info = fileTreeMap.get(destination.toString());
                if (info == null) {
                    fileTreeMap.put(destination.toString(), new ContentsInfo(false, destination, 'u'));
                } else {
                    info.setMode('u');
                }
            } else {
                TestLogger.print("F(A):"+ destination);
                fileTreeMap.put(destination.toString(), new ContentsInfo(false, destination, 'c'));

                BufferedWriter bw = null;
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(source.toFile())));
                    bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile)));
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

    public static class DeleteWalker extends SimpleFileVisitor<Path> {

        Map<String, ContentsInfo> fileTreeMap = null;

        public void setFileMap(Map<String, ContentsInfo> fileTreeMap) {
            this.fileTreeMap = fileTreeMap;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
            File targetDir = dir.toFile();
            if (targetDir.exists()) {
                targetDir.delete();
                TestLogger.print("D(D):"+ dir);
                fileTreeMap.put(dir.toString(), new ContentsInfo(true, dir, 'd'));
            }
            return FileVisitResult.CONTINUE;
//            return super.postVisitDirectory(dir, exc);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
            System.out.println("D:" + dir);
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            System.out.println("FD:" + file);
            File targetFile = file.toFile();
            if (targetFile.exists()) {
                targetFile.delete();
                TestLogger.print("F(D):"+ file);
                fileTreeMap.put(file.toString(), new ContentsInfo(false, file, 'd'));
            }
            return FileVisitResult.CONTINUE;
//            return super.visitFile(file, attrs);
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

