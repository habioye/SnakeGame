package MainMenu;

public class GameSettings {
	String difficulty;
	int musicVolume;
	int soundVolume;

	public GameSettings(String difficulty, int musicVolume, int soundVolume) {
		this.difficulty = difficulty;
		this.musicVolume = musicVolume;
		this.soundVolume = soundVolume;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getMusicVolume() {
		return musicVolume;
	}

	public void setMusicVolume(int musicVolume) {
		this.musicVolume = musicVolume;
	}

	public int getSoundVolume() {
		return soundVolume;
	}

	public void setSoundVolume(int soundVolume) {
		this.soundVolume = soundVolume;
	}

	@Override
	public String toString() {
		return "GameSettings [difficulty=" + difficulty + ", musicVolume=" + musicVolume + ", soundVolume="
				+ soundVolume + "]";
	}

}
