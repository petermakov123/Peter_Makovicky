package sk.tsystems.gamestudio.service;

import java.util.List;

import sk.tsystems.gamestudio.entity.Score;

public interface ScoreService {
	
	void addScore(Score score);
	
	List<Score> getToScores(String game);

	
		
	
}
