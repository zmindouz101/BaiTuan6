import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private final static String SERVER_IP = "127.0.0.1";
    private final static int SERVER_PORT = 8282;

    public static void main(String[] args) throws IOException {
        List<Student> students;
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println(socket);
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            System.out.println("\nThong tin 5 sinh vien co diem cao nhat...");
            students = (List<Student>) ois.readObject();
            students.forEach(el -> {
                System.out.println(el.toString());
            });

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Khong the ket noi Sever, Vui long kiem tra mang !");
        }
    }
}
