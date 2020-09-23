package file.search;

import logger.TestLogger;

import java.io.*;
import java.util.Date;

public class FileFindNDownload {
    public static void main(String args[]) {
        FileHandler fileHandler = new FileHandler();
        File sourceFile;
        String fileName = "test1111.txt";
//        String fileName = "test1sd1.txt";
        try {
//            sourceFile = fileHandler.absolutePath(fileName);
//            System.out.println(sourceFile);

            fileHandler.download(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound..." + fileName);
        } catch (IOException e) {
            System.out.println("IOException..." + e.getMessage());
        }
    }
}

class FileHandler {

    protected String serverFolder = "C:\\DEV_JJOBS_V2\\gitspaces\\java\\FileTransfer\\";
    protected String targetFolder = "./snippet/sample/TARGET/";

    private File sourceFile;

    public FileHandler() {
        super();
    }

    public File absolutePath(String filename) throws FileNotFoundException {
        File sourceRoot = new File(serverFolder);
        File sourceFile = new File(serverFolder + filename);
        if (sourceFile.exists() && sourceFile.isFile()) {
            return sourceFile;
        }
        FilePathHolder absoluteFilePathHolder = new FilePathHolder();
        traversalAbsolutePath(filename, sourceRoot.getAbsolutePath(), absoluteFilePathHolder);
        if (absoluteFilePathHolder.getTraversalAbsoluteFilePath() == null) {
            throw new FileNotFoundException();
        }
        TestLogger.print("result file >> " + absoluteFilePathHolder.getTraversalAbsoluteFilePath().getAbsolutePath());

        this.sourceFile = absoluteFilePathHolder.getTraversalAbsoluteFilePath();
        return absoluteFilePathHolder.getTraversalAbsoluteFilePath();
    }

    private void traversalAbsolutePath(String filename, String path, FilePathHolder absoluteFilePathHolder) {
        File sourceRoot = new File(path);

        File sourceFile = new File(serverFolder + filename);
        if (sourceFile.exists() && sourceFile.isFile()) {
            absoluteFilePathHolder.setTraversalAbsoluteFilePath(sourceFile);
            TestLogger.print("find file >> " + absoluteFilePathHolder.getTraversalAbsoluteFilePath().getAbsolutePath());
            return;
        }

        if (sourceRoot.isDirectory()) {
            File[] fileList = sourceRoot.listFiles();
            for (File file : fileList) {
                if (file.isDirectory()) {
                    traversalAbsolutePath(filename, file.getAbsolutePath(), absoluteFilePathHolder);
                } else {
                    TestLogger.print("candidate file >> " + file.getAbsolutePath());
                    if (file.getName().equals(filename)) {
                        absoluteFilePathHolder.setTraversalAbsoluteFilePath(file);
                        TestLogger.print("find file >> " + absoluteFilePathHolder.getTraversalAbsoluteFilePath().getAbsolutePath());
                        return;
                    }
                }
            }
        }
    }

    public void download(String filename) throws IOException {
        File sourceFile = absolutePath(filename);
        File downloadFile = new File(targetFolder + filename);
        if (sourceFile.exists() && sourceFile.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(downloadFile));

            String line = null;
            String cr = null;
            while ((line = br.readLine()) != null) {
                if (cr != null) {
                    bw.write(cr);
                } else {
                    cr = "\r\n";
                }
                bw.write(line);
            }
            bw.flush();
            br.close();
            bw.close();
        } else {
            TestLogger.print(new Date() + "]] Filename is not exist.");
        }
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

}

class FilePathHolder {
    private File traversalAbsoluteFilePath;

    public File getTraversalAbsoluteFilePath() {
        return traversalAbsoluteFilePath;
    }

    public void setTraversalAbsoluteFilePath(File traversalAbsoluteFilePath) {
        this.traversalAbsoluteFilePath = traversalAbsoluteFilePath;
    }
}