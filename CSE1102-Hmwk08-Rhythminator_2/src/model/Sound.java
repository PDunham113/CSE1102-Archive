package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class represents sounds that can be played. The sounds are stored
 * in sound files on the disk, but get loaded into memory automatically.
 * @author jeff
 */
public class Sound
{

  private String _name;
  private Clip _clip;

  public static final String SOUND_DIR = "sounds";
  private static Hashtable<String, File> _soundFiles = new Hashtable<String, File>();

  private static String[] _extensions = {".aiff", ".wav"};

  /**
   * Creates a new sound from a sound file on disk. The sound file must be present
   * in the sounds directory.
   * @param soundName The base of the file name from which to create the sound.
   */
  public Sound(String soundName)
  {
    this(soundName, _soundFiles.get(soundName));
  }

  /**
   * Creates a new sound from a sound file. The file can be located anywhere on disk.
   * @param soundName What to call the sound.
   * @param soundFile The file that refers to the sound file on disk.
   */
  public Sound(String soundName, File soundFile)
  {
    if(soundFile == null)
      throw new RuntimeException("there is no sound file having name " + soundName);
    _name = soundFile.getName();
    try
    {
      _clip = AudioSystem.getClip();
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
      _clip.open(ais);
    }
    catch(LineUnavailableException exn)
    {
      throw new RuntimeException("Unable to open the line for audio output. Is another program using it?");
    }
    catch(UnsupportedAudioFileException exn)
    {
      System.out.println("Unsupported audio format for that file: " + soundFile.toString());
      throw new RuntimeException("Unsupported audio format for that file: " + soundFile.toString());
    }
    catch(IOException exn)
    {
      System.out.println("Unable to open file: " + soundFile.toString());
      throw new RuntimeException("Unable to open file: " + soundFile.toString());
    }
  }

  /**
   * 
   * @return Array of all sound files that were found in the sound directory.
   */
  public static String[] getAllSoundFileNames()
  {
    Set<String> nameSet = _soundFiles.keySet();
    String[] names = new String[nameSet.size()];
    nameSet.toArray(names);
    Arrays.sort(names);
    return names;
  }

  /**
   * 
   * @return The name of this sound instance.
   */
  public String getName()
  {
    return _name;
  }

  /**
   * Plays the sound. Make sure your speakers are turned up.
   */
  public void play()
  {
    _clip.setFramePosition(0); // necessary for re-playing an already-played clip
    _clip.start();
  }

  /**
   * Scans the default sound directory for sound files.
   */
  public static void scanSoundDir()
  {
    scanSoundDir(SOUND_DIR);
  }

  /**
   * Scans the specified sound directory for sound files.
   * @param dirName
   */
  public static void scanSoundDir(String dirName)
  {
    ArrayList<String> soundFileNames = new ArrayList<String>();
    File directory = new File(dirName);
    File[] files = directory.listFiles();
    for(File file : files)
    {
      String fileName = file.getName();
      for(String ext : _extensions)
      {
        if(fileName.endsWith(ext))
        {
          soundFileNames.add(fileName);
          String shortName = file.getName();
          shortName = shortName.substring(0, shortName.lastIndexOf('.'));
          _soundFiles.put(shortName, file);
          break;
        }
      }
    }
    int count = _soundFiles.size();
    System.out.println("Sound.scanSoundDir class found " + count + " sound files in directory '" + SOUND_DIR + "'");
    _soundFiles.put("(none)", new File(""));
  }

  @Override
  public String toString()
  {
    return "Sound(" + _name + ")";
  }

}
