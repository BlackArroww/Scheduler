import java.util.Comparator;

public class PrioComparator implements Comparator<Prozess> {
	@Override
	public int compare(Prozess firstProcess , Prozess secondProcess) {
		return Integer.compare(secondProcess.getPrio(), firstProcess.getPrio());
	}
}
