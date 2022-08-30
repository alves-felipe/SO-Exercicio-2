package view;

import controller.KillController;

public class Main {
	public static void main(String[] args) {
		KillController kill = new KillController();
		
		kill.listaProcessos();
		kill.mataPid(3903);
		kill.mataNome("gedit");
	}

}
