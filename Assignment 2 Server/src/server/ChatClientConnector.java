package server;

import mediator.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClientConnector implements Runnable
{
  private int PORT = 1234;
  private boolean running;
  private ServerSocket welcomeSocket;
  private Model model;

  public ChatClientConnector(Model model)
  {
    this.model = model;
  }

  public void start() throws IOException
  {
    model.addLog("Starting Server...");
    welcomeSocket = new ServerSocket(PORT);

    while (true)
    {
      try
      {
        Socket socket = welcomeSocket.accept();

        ChatClientHandler logInClientHandler = new ChatClientHandler(socket,
            model);
        Thread thread = new Thread(logInClientHandler);
        thread.setDaemon(true);
        thread.start();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

  }

  @Override public void run()
  {
    try
    {
      start();
    }
    catch (IOException e)
    {
      try
      {
        model.addLog("Error : " + e.getMessage());
      }
      catch (IOException ioException)
      {
        ioException.printStackTrace();
      }
    }
  }

  public void stop()
  {
    running = false;
    try
    {
      welcomeSocket.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
