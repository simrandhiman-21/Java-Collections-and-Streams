import java.io.*;

// Writer Thread
class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes());
            System.out.println("Writer: Sent message.");
            pos.close();
        } catch (IOException e) {
            System.err.println("Writer error: " + e.getMessage());
        }
    }
}

// Reader Thread
class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = pis.read(buffer);
            
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Reader: Received message → " + message);

            pis.close();
        } catch (IOException e) {
            System.err.println("Reader error: " + e.getMessage());
        }
    }
}

// Main Class
public class PipedCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            // Wait for both threads to finish
            writer.join();
            reader.join();

            System.out.println("Communication between threads completed successfully.");

        } catch (IOException | InterruptedException e) {
            System.err.println("Main error: " + e.getMessage());
        }
    }
}
