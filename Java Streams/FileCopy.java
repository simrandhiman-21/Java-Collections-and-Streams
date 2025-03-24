import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";   // Source file path
        String destFile = "destination.txt";  // Destination file path

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Check if source file exists
            File src = new File(sourceFile);
            if (!src.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            // Initialize input and output streams
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];  // Buffer to hold file data
            int bytesRead;

            // Read and write bytes from source to destination
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException ex) {
                System.out.println("Failed to close streams: " + ex.getMessage());
            }
        }
    }
}
