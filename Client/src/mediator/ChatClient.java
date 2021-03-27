package mediator;

import com.google.gson.Gson;
import model.Model;
import model.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements ServerModel
{
  public static final String HOST = "localhost";
  public static final int PORT = 1234;
  private String host;
  private int port;
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Model model;
  private boolean running;
  private String user;
  private ClientReceiver clientReceiver;

  public ChatClient(Model model) throws IOException
  {
    this.host = HOST;
    this.port = PORT;
    this.model = model;
    this.running = false;
    socket = new Socket(HOST, PORT);

  }

  @Override public void disconnect() throws IOException
  {
    socket.close();
    in.close();
    out.close();
  }

  @Override public void connect() throws IOException
  {
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);

  }

  @Override public boolean verifyLog(String password, String name)
      throws IOException
  {
    out.println(password);
    out.println(name);
    this.user = name;
    String answer = in.readLine();
    if (answer.equals("approved"))
    {
      clientReceiver = new ClientReceiver(this, in);
      Thread thread = new Thread(clientReceiver);
      thread.start();
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean isRunning()
  {
    return running;
  }


  @Override public void setMessage(String message) throws IOException
  {
    model.setMessage(message);
  }

  @Override public void sendMessage(String message)
  {
    Gson gson = new Gson();

    Message sentMessage = new Message( message, user);
    String json = gson.toJson(sentMessage);
    out.println(json);

  }

}
