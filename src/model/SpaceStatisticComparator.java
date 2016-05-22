package model;

import java.util.Comparator;

final class SpaceStatisticComparator implements Comparator<SpaceStatistic> {

	@Override
	public final int compare(SpaceStatistic o1, SpaceStatistic o2) {
		if(o1.getSpaceRelFreq() > o2.getSpaceRelFreq()){
			return -1;
		}else if(o1.getSpaceRelFreq() == o2.getSpaceRelFreq()){
			return 0;
		}else{
			return 1;
		}
	}
}
