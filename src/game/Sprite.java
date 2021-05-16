package game;

public interface Sprite {

	double getX();

	double getY();

	void addToLayer();

	void tick();

	void forword();

	void back();

	void up();

	void down();

	void setX(double x);

	void setY(double y);

	boolean isMoovingForword();

	boolean isMoovingDown();

	boolean isMoovingBack();

	boolean isMoovingUp();

	void moove();

	void put(int nbcase);

}