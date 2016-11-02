package youth.hong;

import java.util.ArrayList;
import java.util.List;

public class Boy {
	private String name;
	private List<Command> commands = new ArrayList<Command>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void doCommand() {
		for (Command command : commands) {
			command.execute();
			commands.remove(command);
		}
	}
	
	public void undoCommand() {
		for (Command command : commands) {
			command.undo();
			commands.remove(command);
		}
	}

	public void addCommand(Command c) {
		commands.add(c);
	}
	
	
}
