package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class ChatViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> logs;
  private StringProperty text;
  public ChatViewModel(Model model)
  {
    this.model = model;
    this.text = new SimpleStringProperty();
    logs = FXCollections.observableArrayList();
    logs.add("Start chatting with other people!");
    model.addListener("message", this);
  }
  public ObservableList<String> getLogs()
  {
    return logs;
  }

  public void setMessage(String inputField) throws IOException
  {
    model.sendMessage(inputField);
  }

  public void reset() {
    logs.clear();
    text.set("");
  }

  public StringProperty getText()
  {
    return text;
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      logs.add(1, evt.getNewValue() + "");
    });
  }

}
