package viewmodel;

import mediator.Model;

public class ViewModelFactory
{

  private LogViewModel logViewModel;

  public ViewModelFactory(Model model)
  {

    logViewModel = new LogViewModel(model);
  }

  public LogViewModel getLogViewModel()
  {
    return logViewModel;
  }
}
