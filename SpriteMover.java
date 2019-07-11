
public class SpriteMover implements Runnable {
	
	Model model;
    View view;

	SpriteMover(Model modelIn, View viewIn) {
		model = modelIn;
		view = viewIn;
	}
	SpriteMover(){
		run();
	}


	public void run() {
		while (true) {
			
			
			model.updateScene(view.getWidth(), view.getHeight());
			view.repaint();
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {}
		}
	}
}