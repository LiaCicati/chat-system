package mediator;

import model.Log;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model
{
//  private Converter converter;
  private PropertyChangeSupport property;
  private ArrayList<String> list = new ArrayList<>();

  public ModelManager()
  {
    property = new PropertyChangeSupport(this);
  }
  public Log getLog() throws IOException
  {
    return Log.getInstance();
  }
  @Override public synchronized void addLog(String log) throws IOException
  {
    Log.getInstance().addLog(log);
    property.firePropertyChange("add", null, log);
  }

  public void addUser(String user)
  {
    list.add(user);
  }

  public String getList()
  {
    String s = "";
    for (int i = 0; i < list.size() - 1; i++)
    {
      s += list.get(i) + " , ";
    }
    s += list.get(list.size() - 1);
    return s;
  }

  @Override public boolean verifyLog(String request)
  {
    return request.equals("connect");
  }

  @Override public void addMessage(String message, String user)
  {

    property.firePropertyChange("user", null, user);
    property.firePropertyChange("message", null, message);

  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {

    property.addPropertyChangeListener(propertyName, listener);
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(propertyName, listener);
  }
}
