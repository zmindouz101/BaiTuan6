import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSide {
    private static final int PORT_NUMBER = 8282;

    public static void main(String[] args) throws IOException {
        // Get data from store
        Sever.getInstance().loadAllStudentsData();
        List<Student> students = Sever.getInstance().getTop5StudentWithHighestMark();

        //
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        System.out.println("Server is listening on PORT 8282 ... ");

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket);

            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(students);
            socket.close();
        }
    }
}
