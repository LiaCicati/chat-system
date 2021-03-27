package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import viewmodel.ChatViewModel;

import java.io.IOException;

public class ChatViewController extends ViewController
{
  @FXML private ListView<String> list;
  @FXML private TextField text;
  private ChatViewModel viewModel;

  @Override protected void init()
  {
    viewModel = getViewModelFactory().getChatViewModel();
    list.setItems(viewModel.getLogs());
  }

  public void reset()
  {
    viewModel.reset();
  }

  @FXML public void setText() throws IOException
  {
    if (!text.getText().equals(""))
    {
      viewModel.setMessage(text.getText());
      text.setText("");
    }
  }
}
