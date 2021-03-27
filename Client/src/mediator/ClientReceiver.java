package mediator;

import com.google.gson.Gson;
import model.Message;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientReceiver implements Runnable
{
  private BufferedReader in;
  private ChatClient client;

  public ClientReceiver(ChatClient client, BufferedReader in)
  {
    this.client = client;
    this.in = in;
  }

  @Override public void run()
  {
    Gson gson = new Gson();

    while (true)
    {
      try
      {
        String reply = in.readLine();
        Message message = gson.fromJson(reply, Message.class);
        if (message.getBody().equals("chatters"))
        {
          client.setMessage("chatters");
        }
        else
        {
          client.setMessage(message.getUser() + " : " + message.getBody());
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
