package file.exec;

import logger.TestLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProcessRunner {
    public static void main(String[] args)
            throws IOException, InterruptedException {
        String[] command = new String[]{"cmd", "/c", "echo", "hello~~~~"};

        ProcessRunner runner = new ProcessRunner();
        runner.byRuntime(command);
        runner.byProcessBuilder(command);
//        runner.byProcessBuilderRedirect(command);
    }

    public void byRuntime(String[] command)
            throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        printStream(process);
    }

    public void byProcessBuilder(String[] command)
            throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        printStream(process);
    }

    private void printStream(Process process)
            throws IOException, InterruptedException {
        int exitValue = process.waitFor();
        TestLogger.print(exitValue);
        TestLogger.print(process.exitValue());
        try (InputStream psout = process.getInputStream()) {
            stdout(psout, System.out);
        }
    }

    public void stdout(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int n = 0;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
    }
}
