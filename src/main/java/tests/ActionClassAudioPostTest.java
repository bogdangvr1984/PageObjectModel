package tests;

import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassAudioPostTest extends BaseTest{
	
	@Test
	public void audioPostTest() throws InterruptedException {
		
		app.menu.hoverElement(app.menu.blogLink);
		app.menu.navigateTo(app.menu.blogSubMenuPostFormats);
		app.postFormat.click(app.postFormat.audioPost);
		app.audioPost.click(app.audioPost.playButton);
		app.audioPost.dragAndDrop(app.audioPost.sliderMusicPlayer, 200, 0);
		app.audioPost.dragAndDrop(app.audioPost.sliderVolume, -50, 0);
		
		Thread.sleep(3000);
		
	}
	
	

}
