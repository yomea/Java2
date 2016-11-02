package youth.hong;

public class WatchFilm implements Command {

	@Override
	public void execute() {
		System.out.println("去看电影");
	}

	@Override
	public void undo() {
		System.out.println("不去看电影");
	}

}
