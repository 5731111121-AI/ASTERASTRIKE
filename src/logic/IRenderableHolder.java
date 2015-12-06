package logic;

import java.util.concurrent.CopyOnWriteArrayList;

public interface IRenderableHolder {

	public CopyOnWriteArrayList<IRenderable> getSortedRenderableObject();
}
