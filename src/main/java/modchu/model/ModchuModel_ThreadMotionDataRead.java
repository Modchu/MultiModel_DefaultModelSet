package modchu.model;

import java.lang.reflect.Method;
import java.util.ArrayList;

import modchu.lib.Modchu_Debug;

public class ModchuModel_ThreadMotionDataRead extends Thread {
	public static ModchuModel_ThreadMotionDataRead instance;
	public ArrayList<Integer> readList;
	public String[] nameArray;
	public Method method;
	public Object methodObject;

	@Override
	public void run() {
		//Modchu_Debug.mDebug("ModchuModel_ThreadMotionDataRead run()");
		boolean b = true;
		while (b) {
			//Modchu_Debug.dDebug("ModchuModel_ThreadMotionDataRead 1", 2);
			if (readList != null
					&& !readList.isEmpty()) {
				//Modchu_Debug.dDebug("ModchuModel_ThreadMotionDataRead 2", 2);
				int i1 = 0;
				ModchuModel_MotionData motionData = null;
				i1 = readList.get(0);
				//Modchu_Debug.dDebug("ModchuModel_ThreadMotionDataRead 3", 2);
				motionData = ModchuModel_MotionDataMaster.threadLoadMotionData(i1, nameArray);
				boolean b2 = motionData != null;
				while(b2) {
					Modchu_Debug.dDebug("ModchuModel_ThreadMotionDataRead completionMotionData now. ( "+motionData.getCompleteDataCount()+" / "+motionData.getMaxMotionFrame()+" )", 2);
					motionData = ModchuModel_MotionDataMaster.completionMotionData(motionData);
					//motionData = ModchuModel_MotionDataMaster.debugMotionData(motionData);
					ModchuModel_MotionDataMaster.setMotionDataMap(i1, motionData);
					if (motionData.getCompleteData()) b2 = false;
				}
				if (motionData != null) Modchu_Debug.dDebug("ModchuModel_ThreadMotionDataRead completionMotionData end.", 2, 50);
				else Modchu_Debug.dDebug("ModchuModel_ThreadMotionDataRead motionData == null error !! end.", 2, 50);
				if (method != null) {
					try {
						method.invoke(methodObject, motionData);
					} catch (Exception e) {
					}
				}
				Modchu_Debug.dDebug(null, 2);
				readList.remove(0);
			} else {
				b = false;
			}
		}
		instance = null;
	}

	public void regster(int i, String[] s1) {
		if (readList != null); else readList = new ArrayList();
		if (!readList.contains(i)) readList.add(i);
		nameArray = s1;
	}

	public void regster(Object o, Method m) {
		methodObject = o;
		method = m;
	}
}

