package examprep2.threads;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Observable implements Runnable{

    private RandomUser user;

    public RandomUserControl() {
        this.user = null;
    }
    
    public void fetchRandomUser() {
        try {
            user = RandomUserGenerator.getRandomUser();
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        setChanged();
        notifyObservers(this);
    }

    public RandomUser getUser() {
        return user;
    }

    @Override
    public void run() {
        fetchRandomUser();
    }
    
}
