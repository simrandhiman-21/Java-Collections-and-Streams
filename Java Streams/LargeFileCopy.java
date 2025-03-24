import java.io.*;

public class LargeFileCopy {

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";          // Source file path (100MB+)
        String destBuffered = "buffered_copy.dat";    // Buffered destination
        String destUnbuffered = "unbuffered_copy.dat";// Unbuffered destination

        // Measure and display execution time
        long bufferedTime = copyFile(sourceFile, destBuffered, true);
        long unbufferedTime = copyFile(sourceFile, destUnbuffered, false);

        // Display Execution Time Comparison
        System.out.println("\nExecution Time Comparison:");
        System.out.printf("Buffered Streams:   %.2f ms%n", bufferedTime / 1_000_000.0);
        System.out.printf("Unbuffered Streams: %.2f ms%n", unbufferedTime / 1_000_000.0);

        System.out.println(bufferedTime < unbufferedTime ? "\n✅ Buffered streams are faster." : "\n🚀 Unbuffered streams are faster.");
    }

    // Method to copy file with option for buffered or unbuffered stream
    private static long copyFile(String source, String destination, boolean useBuffered) {
        long startTime = System.nanoTime();
        
        try (
            InputStream is = useBuffered ? 
                new BufferedInputStream(new FileInputStream(source)) : 
                new FileInputStream(source);
            
            OutputStream os = useBuffered ? 
                new BufferedOutputStream(new FileOutputStream(destination)) : 
                new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[4096];  // 4 KB buffer size
            int bytesRead;
            
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            System.out.println((useBuffered ? "Buffered" : "Unbuffered") + " copy completed: " + destination);

        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
        
        return System.nanoTime() - startTime;
    }
}
