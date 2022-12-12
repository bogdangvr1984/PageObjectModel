package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class AudioPostPage extends SeleniumWrappers{
	
public WebDriver driver;
	
	public AudioPostPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By playButton = By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-play']");
	public By sliderMusicPlayer = By.xpath("//span[@class='mejs-time-current']");
	public By sliderVolume = By.xpath("//a[@class='mejs-horizontal-volume-slider']");

}
