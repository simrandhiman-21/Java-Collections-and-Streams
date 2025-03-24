import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {

    public static void main(String[] args) {
        String sourceFile = "source.jpg";          // Original image file
        String destFile = "copy.jpg";              // Copied image file

        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(sourceFile);

            // Write byte array back to new image
            byteArrayToImage(imageBytes, destFile);

            // Verify if the original and copied files are identical
            if (areFilesIdentical(sourceFile, destFile)) {
                System.out.println("\n✅ The copied image is identical to the original.");
            } else {
                System.out.println("\n❌ The copied image is NOT identical to the original.");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Convert image file to byte array
    private static byte[] imageToByteArray(String filePath) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            System.out.println("✅ Image converted to byte array.");
            return baos.toByteArray();
        }
    }

    // Write byte array back to image file
    private static void byteArrayToImage(byte[] data, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("✅ Byte array written back to image: " + filePath);
        }
    }

    // Compare if two files are identical
    private static boolean areFilesIdentical(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];

            int bytesRead1, bytesRead2;

            while ((bytesRead1 = fis1.read(buffer1)) != -1) {
                bytesRead2 = fis2.read(buffer2);

                if (bytesRead1 != bytesRead2 || !Arrays.equals(buffer1, buffer2)) {
                    return false;
                }
            }
            return fis2.read() == -1;
        }
    }
}
