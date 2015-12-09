package logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RenderableHolder {

	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities = new CopyOnWriteArrayList<IRenderable>();;

	public RenderableHolder() {
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public void add(IRenderable e) {
		entities.add(e);
		Collections.sort(entities, new Comparator<IRenderable>() {

			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if (o1.getZ() > o2.getZ())
					return 1;
				return -1;
			}
		});
	}

	public List<IRenderable> getRenderableList() {
		return entities;
	}
}
