package library;

import java.io.*;
import libraryUtil.FileClose;

public class FileWriter {
	public static void write() {
		
		BookUtil booklist = new BookUtil(Book.toString());
	
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("LibraryProject/booklist.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(booklist); //묵시적 형변환
			
			System.out.println("object.txt 저장완료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(oos, fos);
		}
	}


	public static void main(String[] args) {
		write();
	}
}