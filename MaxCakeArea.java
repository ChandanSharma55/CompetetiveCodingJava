import java.util.*;

public class MaxCakeArea {
	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		int hl = horizontalCuts.length;
		int vl = verticalCuts.length;
		int hmax = horizontalCuts[0];
		int vmax = verticalCuts[0];
		for (int i = 0; i < hl - 1; i++) {
			hmax = Math.max(hmax, Math.abs(horizontalCuts[i] - horizontalCuts[i + 1]));
		}
		hmax = Math.max(hmax, h - horizontalCuts[hl - 1]);
		for (int i = 0; i < vl - 1; i++) {
			vmax = Math.max(vmax, Math.abs(verticalCuts[i] - verticalCuts[i + 1]));
		}
		vmax = Math.max(vmax, w - verticalCuts[vl - 1]);

		return hmax * vmax;
	}

	public static void main(String args[]) {
		int h = 5;
		int w = 4;
		int[] hc = {3,1};
		int 
	}
}
