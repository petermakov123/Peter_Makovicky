package sk.tsystems.gamestudio.controller;

import java.util.Formatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sk.tsystems.gamestudio.game.puzzle.core.Field;
import sk.tsystems.gamestudio.game.puzzle.core.Tile;

@Controller
public class PuzzleController {
	private Field field = new Field(4, 4);

	@RequestMapping("/puzzle")
	public String index() {
		return "puzzle";
	}
	@RequestMapping("/puzzle/move")
	public String move(int tile) {
		field.move(tile);
		return "puzzle";
	}

	public String getHtmlField() {
		@SuppressWarnings("resource")
		Formatter f = new Formatter();
		f.format("<table>\n");
		for (int row = 0; row < field.getRowCount(); row++) {
			f.format("<tr>\n");
			for (int column = 0; column < field.getColumnCount(); column++) {
				f.format("<td>\n");
				Tile tile = field.getTile(row, column);
				if (tile != null)
					 f.format("<a href='/puzzle/move?tile=%d'><img src='/images/puzzle/img%d.jpg'></a>", tile.getValue(), tile.getValue());
//					f.format("<a href='/puzzle/move?tile=%d'>%2d</a> ", tile.getValue(),tile.getValue());
				f.format("</td>\n");

			}
			f.format("</tr>\n");
		}
		f.format("</table>\n");

		return f.toString();
	}

	public String getMessage() {
		return "Hello from Java";
	}
}
