package de.scholzf.javapoly.Entity.GameObjects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class Game {

    public int getNextKey() {
        return GameObject.Canvas.getInstance().getNextKey();
    }

    public static void playSound(String fileName) {

        try{
            int period = fileName.lastIndexOf('.');
            int separator = fileName.lastIndexOf(File.separator);
            String completeName = fileName + (period > separator ? "" : ".wav");

            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(new FileInputStream("sounds" + File.separator + completeName));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }

}
