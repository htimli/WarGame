package game;

import java.awt.geom.Point2D;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpriteImpl implements Sprite {
	
	
	private ImageView imageView;

    private Pane layer;

    protected double x;
    protected double y;

    protected double dx;
    protected double dy;
    
    private Case _case;
    
    private static Board board = new Board();
    
    private static HashMap<Integer,Point2D.Double> cases  = new HashMap<>(); 
    
    
    
	public SpriteImpl(Image image, Pane layer, double x, double y, double dx, double dy) {
		super();
		
		this.imageView = new ImageView(image);
		this.layer = layer;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		
		
		_case = board.getCase(0);
		
		imageView.relocate(x, y);
		this.addToLayer();
	}
	
	
	public Case getCase() {
		return _case;
	}


	@Override
	public double getX() {
		return x;
	}


	@Override
	public double getY() {
		return y;
	}


	@Override
	public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }
	@Override
	public void tick() {
		x+=dx;
		y+=dy;
		imageView.relocate(x, y);
		
	}
	@Override
	public void forword() {
		x+=dx;
	}
	
	@Override
	public void back() {
		x-=dx;
	}
	
	@Override
	public void up() {
		y-=dy;
	}
	
	@Override
	public void down() {
		y+=dy;
	}
	
	
	@Override
	public void setX(double x) {
		this.x = x;
	}


	@Override
	public void setY(double y) {
		this.y = y;
	}


	@Override
	public boolean isMoovingForword() {
		int nbCase = this.getNbCase();
		return (nbCase <=Settings.TURN_BOARD_1 || (nbCase > Settings.TURN_BOARD_4 && nbCase <= Settings.TURN_BOARD_5)); 
	}
	@Override
	public boolean isMoovingDown() {
		int nbCase = this.getNbCase();
		return ( (nbCase > Settings.TURN_BOARD_1 && nbCase <= Settings.TURN_BOARD_2) || (nbCase > Settings.TURN_BOARD_5 && nbCase <= Settings.TURN_BOARD_6 ));
	}
	@Override
	public boolean isMoovingBack(){
		int nbCase = this.getNbCase();
		return ((nbCase > Settings.TURN_BOARD_2 && nbCase <= Settings.TURN_BOARD_3) || (nbCase > Settings.TURN_BOARD_6 && nbCase < Settings.BOARD_NB_CASES));
	}
	@Override
	public boolean isMoovingUp() {
		int nbCase = this.getNbCase();
		return (nbCase > Settings.TURN_BOARD_3 && nbCase <= Settings.TURN_BOARD_4) ;
	}
	
	@Override
	public void moove () {
		if(this.getNbCase()< Settings.BOARD_NB_CASES-1) {
			_case = board.getCase(this.getNbCase()+1);
				
			if(isMoovingUp()) {
				imageView.setRotate(3*Settings.ROTATION);	
				up();
			}
			else if(isMoovingBack()){
				imageView.setRotate(2*Settings.ROTATION);	
				back();
			}
			else if( isMoovingDown()){
				imageView.setRotate(Settings.ROTATION);	
				down();
			}
			else {
				imageView.setRotate(0);	
				forword();
			}
			imageView.relocate(x, y);
		}
	}
					
	public void detectPositions() {
		this.imageView.setVisible(false);
		while (this.getNbCase()< 34){
			Point2D.Double p = new Point2D.Double(this.getX(), this.getY());
			cases.put(this.getNbCase(),p);
			this.moove();
		}
		cases.put(this.getNbCase(),new Point2D.Double(this.getX(), this.getY())); //for the last case
	}
	@Override
	public void relocate(int nbcase) {
		Point2D.Double p = cases.get(nbcase);
		this.setX(p.x);
		this.setY(p.y);
		imageView.relocate(x,y);
		this._case = SpriteImpl.board.getCase(nbcase);
	}
    public int getNbCase() {
    	return this._case.getNbCase();
    }


	public HashMap<Integer, Point2D.Double> getCases() {
		return cases;
	}


	@Override
	public ImageView getImageView() {
		return this.imageView;
	}
    
	
    

}
