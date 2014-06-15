package utilits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasus on 15.06.14.
 */
abstract public class EventPublisher<E> {
    List<E> subscribers = new ArrayList<E>();

    public void addSubscriber(E subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public void removeSubscriber(E subscriber) {
        subscribers.remove(subscriber);
    }

    abstract public void publish();
}
