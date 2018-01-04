// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package model;

import message.ISubscriber;
import message.Message;

public class SoundPlayer implements ISubscriber
{

  private SoundBank _soundBank;
  private int _soundNumber;

  public SoundPlayer(SoundBank soundBank, int soundNumber)
  {
    _soundBank = soundBank;
    _soundNumber = soundNumber;
  }

  @Override
  public void notify(Message message)
  {
    _soundBank.play(_soundNumber);
  }

}
