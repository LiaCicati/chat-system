package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Log
{
  private static Log instance;
  private ArrayList<LogLine> logs;
  private BufferedWriter out;
  private static Object lock = new Object();
  private File logFile;

  private Log() throws IOException
  {
    this.logFile = new File("LogList.txt");
    this.out = new BufferedWriter(new FileWriter(logFile, true));
    this.logs = new ArrayList<>();
  }

  public void addLog(String text)
  {

    LogLine logLine = new LogLine(text);
    instance.addToFile(logLine);
    System.out.println(logLine);
    logs.add(logLine);
  }

  public ArrayList<LogLine> getAll()
  {
    return logs;
  }

  public static Log getInstance() throws IOException
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Log();
        }
      }
    }
    return instance;
  }

  private synchronized void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter(logFile, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}


