import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import mediator.ChatClientConnector;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws IOException
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
    ChatClientConnector connector = new ChatClientConnector(model);
    Thread t = new Thread(connector);
    t.start();
  }
}
