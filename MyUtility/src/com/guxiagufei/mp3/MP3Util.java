package com.guxiagufei.mp3;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;

public class MP3Util {
	
	public static MP3File createMp3File(File file){
		try {
			return new MP3File(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TagException e) {
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//读取播放时间
	
	public static String getPlayLength(File file){
		try {
			MP3File mp3File = new MP3File(file);
			MP3AudioHeader header = mp3File.getMP3AudioHeader();
			String playLength = header.getTrackLengthAsString();
			return playLength;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TagException e) {
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
