package playercontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerboundary.Application;
import playerboundary.LightningLevelApplication;
import playerboundary.SplashScreenApplication;

public class LightningTimerController implements ActionListener {
	
	Application app;
	Model model;
	int levelNumber;

	@Override
	public void actionPerformed(ActionEvent e) {
		LightningLevelApplication l = (LightningLevelApplication) app.getLevelApplications().get(levelNumber);
		if(l.getTimeLeft() == 0)
        {
            l.getTimer().stop();
            l.getLevelModel().exitLevel();
            app.getMapApplication().refreshPanel();
            // make sure we're still in the level before kicking us out to main menu
            if (app.getContentPane().getName().equals(l.getName())) {
            	app.setContentPane(app.getMapApplication());
            }
        }
        else
        {
           l.decrementTimeLeft();
           l.resetObjectiveValue(l.getTimeLeft());
        }
	}
	
	public LightningTimerController(Application app, Model m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}