package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}

	private String os() {
		return System.getProperty("os.name").split(" ")[0];
	}
	
	public void listaProcessos(){
		String command = os().equals("Linux") ? "ps -ef" : "TASKLIST /FO TABLE";
		
		try {
			Process p = Runtime.getRuntime().exec(command);
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mataPid(int pid){
		String command = os().equals("Linux") ? "kill -9 " : "TASKKILL /PID ";
		
		try {
			Process p = Runtime.getRuntime().exec(command+pid);
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mataNome(String processo){
		String command = os().equals("Linux") ? "pkill -f " : "TASKKILL /IM ";
		
		try {
			Process p = Runtime.getRuntime().exec(command+processo);
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
