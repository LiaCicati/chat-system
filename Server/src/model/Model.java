package model;

import utility.observer.subject.NamedPropertyChangeSubject;

import java.io.IOException;

public interface Model extends NamedPropertyChangeSubject
{
  void addLog(String log) throws IOException;
  boolean verifyLog(String pass, String name);
  void addMessage(String message, String user);
  String getList();
  void addUser(String user);
}
